package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites),
    DeleteAllDialogFragment.DeleteAllDialogListener, MenuProvider {
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModels()

    private val itemTouchHelper: ItemTouchHelper =
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun isLongPressDragEnabled(): Boolean {
                return false
            }

            override fun isItemViewSwipeEnabled(): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteQuotationAtPosition(viewHolder.adapterPosition)
            }
        })

    private val itemClicked: QuotationListAdapter.ItemClicked =
        object : QuotationListAdapter.ItemClicked {
            override fun onClick(author: String) {
                if (author == "Anonymous") {
                    Snackbar.make(
                        binding.root,
                        "No se puede mostrar información si el autor es anónimo",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data =
                        Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + author)
                    try {
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Snackbar.make(
                            binding.root,
                            "No se puede mostrar la página solicitada",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter(itemClicked)
        binding.recyclerView.adapter = adapter
        viewModel.listaFavs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateMenu()
        }

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteAllConfirmed() {
        viewModel.deleteAllQuotations()
    }

    override fun onDeleteAllCancelled() {
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.item_Delete -> {
                DeleteAllDialogFragment(this).show(childFragmentManager, null)
                true
            }
            else -> {
                false
            }
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        menu.findItem(R.id.item_Delete).isVisible = viewModel.isDeleteAllVisible.value ?: false
        super.onPrepareMenu(menu)
    }


}

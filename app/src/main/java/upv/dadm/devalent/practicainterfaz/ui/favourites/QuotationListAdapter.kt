package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import upv.dadm.devalent.practicainterfaz.databinding.QuotationItemBinding
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

class QuotationListAdapter(private val itemClicked: ItemClicked) :
    ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(
        QuotationDiff
    ) {

    class ViewHolder(QuotationItemBinding: QuotationItemBinding, itemClicked: ItemClicked) :
        RecyclerView.ViewHolder(QuotationItemBinding.root) {

        val binding =
            upv.dadm.devalent.practicainterfaz.databinding.QuotationItemBinding.bind(itemView)

        init {
            binding.root.setOnClickListener {
                itemClicked.onClick(binding.msgAutor.text.toString())
            }
        }

        fun bind(quotation: Quotation) {
            binding.msgCita.text = quotation.cita
            binding.msgAutor.text = quotation.autor
        }
    }

    interface ItemClicked {
        fun onClick(author: String)
    }

    object QuotationDiff : DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            (QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return ViewHolder(binding, itemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
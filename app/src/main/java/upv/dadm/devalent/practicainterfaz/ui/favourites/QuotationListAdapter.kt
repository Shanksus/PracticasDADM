package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

class QuotationListAdapter :
    ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff) {

    class ViewHolder(QuotationItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(Quotation : Quotation) {
            binding.
        }
    }

    object QuotationDiff : DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }
}
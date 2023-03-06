package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import upv.dadm.devalent.practicainterfaz.databinding.QuotationItemBinding
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

class QuotationListAdapter : ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(
    QuotationDiff
) {

    class ViewHolder(QuotationItemBinding: QuotationItemBinding) :
        RecyclerView.ViewHolder(QuotationItemBinding.root) {

        fun bind(quotation: Quotation) {
            val binding = QuotationItemBinding.bind(itemView)
            binding.msgCita.text = quotation.cita
            binding.msgAutor.text = quotation.autor
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            (QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
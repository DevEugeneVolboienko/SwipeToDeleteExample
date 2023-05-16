package walby.eugene.example.swipe_to_delete.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import walby.eugene.example.swipe_to_delete.R
import walby.eugene.example.swipe_to_delete.databinding.ItemDataBinding
import walby.eugene.example.swipe_to_delete.ui.base.BaseViewHolder

class DataAdapter(private val dataList: MutableList<DataViewModel>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as DataViewHolder).bind(dataList[position])
    }

    fun remoteAt(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class DataViewHolder(itemView: View) : BaseViewHolder<DataViewModel>(itemView) {
        override fun bind(item: DataViewModel) {
            val binding = DataBindingUtil.bind<ItemDataBinding>(itemView)
            binding?.viewModel = item
        }
    }
}
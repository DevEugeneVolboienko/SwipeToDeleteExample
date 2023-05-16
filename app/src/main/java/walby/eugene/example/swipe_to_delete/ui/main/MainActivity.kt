package walby.eugene.example.swipe_to_delete.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import walby.eugene.example.swipe_to_delete.R
import walby.eugene.example.swipe_to_delete.databinding.ActivityMainBinding
import walby.eugene.example.swipe_to_delete.ui.main.adapter.listener.SwipeToDeleteListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        binding.viewModel = viewModel
        initDataRecycler()
    }

    private fun initDataRecycler() {
        val deleteIcon = resources.getDrawable(R.drawable.ic_delete, theme)
        val swipeHandler = object : SwipeToDeleteListener(deleteIcon) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.removeDataAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.rvData)
    }
}

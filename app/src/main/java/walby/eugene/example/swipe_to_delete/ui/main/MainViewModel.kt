package walby.eugene.example.swipe_to_delete.ui.main

import walby.eugene.example.swipe_to_delete.R
import walby.eugene.example.swipe_to_delete.ui.main.adapter.DataAdapter
import walby.eugene.example.swipe_to_delete.ui.main.adapter.DataViewModel

class MainViewModel {
    val dataAdapter = DataAdapter(mockData())

    fun removeDataAt(position: Int) {
        dataAdapter.remoteAt(position)
    }

    private fun mockData(): MutableList<DataViewModel> {
        val dataList = mutableListOf<DataViewModel>()
        for (i in 0..20) {
            dataList.add(DataViewModel().apply {
                title.set("Title $i")
                description.set("Some description text $i")
                imageId.set(R.mipmap.ic_launcher_round)
            })
        }
        return dataList
    }
}
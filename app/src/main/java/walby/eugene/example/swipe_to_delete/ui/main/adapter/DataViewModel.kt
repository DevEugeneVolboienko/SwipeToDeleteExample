package walby.eugene.example.swipe_to_delete.ui.main.adapter

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    val imageId = ObservableInt()
    val title = ObservableField<String>()
    val description = ObservableField<String>()
}
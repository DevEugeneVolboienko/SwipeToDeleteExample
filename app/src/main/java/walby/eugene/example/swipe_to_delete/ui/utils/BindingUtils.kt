package walby.eugene.example.swipe_to_delete.ui.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("app:imageDrawable")
fun ImageView.bindImage(@DrawableRes drawableResId: Int) {
    this.setImageResource(drawableResId)
}
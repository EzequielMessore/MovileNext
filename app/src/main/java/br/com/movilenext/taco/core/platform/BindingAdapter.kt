package br.com.movilenext.taco.core.platform

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.movilenext.taco.core.extension.getParentActivity
import br.com.movilenext.taco.core.extension.hide
import br.com.movilenext.taco.core.extension.show
import br.com.movilenext.taco.presentation.features.category.CategoriesData
import br.com.movilenext.taco.presentation.features.category.CategoriesError
import br.com.movilenext.taco.presentation.features.category.CategoriesState
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_category.view.*

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("image")
    fun setImageByRes(imageView: ImageView, id: Int) {
        Glide.with(imageView.context).load(id).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("categoryState")
    fun setStateVisibility(view: View, state: MutableLiveData<CategoriesState>) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        parentActivity?.let { act ->
            val content = view.content
            val error = view.container_error

            state.observe(act, Observer {
                when (it) {
                    is CategoriesError -> {
                        error.show()
                        content.hide()
                    }
                    is CategoriesData -> {
                        error.hide()
                        content.show()
                    }
                }
            })
        }
    }

}
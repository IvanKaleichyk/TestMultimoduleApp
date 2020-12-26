package com.koleychik.feature_clothes.screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.koleychik.feature_clothes.R
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.feature_clothes.navigation.ClothesNavigatorComponent
import com.koleychik.feature_clothes.viewModelFactories.ClothesViewModelFactory
import javax.inject.Inject

class ClothesFragment : Fragment(R.layout.fragment_clothes) {

    @Inject
    internal lateinit var viewModelFactory: ClothesViewModelFactory

    @Inject
    lateinit var navigator: ClothesNavigator

    private val viewModel: ClothesViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ClothesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val component = ClothesFeatureComponentHolder.getComponent()
        component.inject(this)

        val text: TextView = requireView().findViewById(R.id.text)
        val price: TextView = requireView().findViewById(R.id.price)
        val btn: Button = requireView().findViewById(R.id.btnBuy)
        val btnGoToLikes: Button = requireView().findViewById(R.id.btnGoToLike)

        viewModel.model.observe(viewLifecycleOwner, {
            if (it == null) viewModel.model.value = viewModel.getModel()
            else {
                text.text = it.name
                price.text = it.price.toString()
            }
        })

        btn.setOnClickListener {
            viewModel.buy(viewModel.model.value!!)
        }

        btnGoToLikes.setOnClickListener {
            Log.d("MAIN_APP", "btnGoToLikes click")
            navigator.goToLikes()
        }
    }

    override fun onStop() {
        super.onStop()
        ClothesNavigatorComponent.reset()
        ClothesFeatureComponentHolder.reset()
    }
}
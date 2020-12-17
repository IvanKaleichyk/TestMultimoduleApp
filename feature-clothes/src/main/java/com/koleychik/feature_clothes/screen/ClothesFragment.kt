package com.koleychik.feature_clothes.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.koleychik.feature_clothes.R
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.viewModelFactories.ClothesViewModelFactory
import javax.inject.Inject

class ClothesFragment : Fragment(R.layout.fragment_clothes) {

    private val text: TextView by lazy { requireView().findViewById(R.id.text) }
    private val price: TextView by lazy { requireView().findViewById(R.id.price) }
    private val btn: Button by lazy { requireView().findViewById(R.id.btnBuy) }
    private val btnGoToLikes: Button by lazy { requireView().findViewById(R.id.btnGoToLike) }

    @Inject
    internal lateinit var viewModelFactory: ClothesViewModelFactory

//    @Inject
//    lateinit var navigator: ClothesNavigator

    private val viewModel: ClothesViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ClothesViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = ClothesFeatureComponentHolder.getComponent()
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.model.observe(viewLifecycleOwner,{
            if (it == null) viewModel.model.value = viewModel.getModel()
            else{
                text.text = it.name
                price.text = it.price.toString()
            }
        })

        btn.setOnClickListener {
            viewModel.buy(viewModel.model.value!!)
        }

//        btnGoToLikes.setOnClickListener { navigator.goToLikes() }

    }
}
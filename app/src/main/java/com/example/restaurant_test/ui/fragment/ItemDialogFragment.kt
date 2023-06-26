package com.example.restaurant_test.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.restaurant_test.R
import com.example.restaurant_test.databinding.DialogItemBinding
import com.example.restaurant_test.databinding.FragmentHomeBinding
import com.example.restaurant_test.di.AppComponent
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.ui.viewmodels.CartViewModel
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class ItemDialogFragment(
    private val item : MenuItemModel
) :DialogFragment(R.layout.dialog_item) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: DialogItemBinding by Delegates.notNull()
    private  var viewModel : CartViewModel by Delegates.notNull()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogItemBinding.inflate(inflater)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 1).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT)
        //dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_item_dialog_corner)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[CartViewModel::class.java]

        binding.itemTitle.text = item.dishName
        binding.itemPrice.text = item.price.toString()
        binding.itemWeight.text = item.weight.toString()
        binding.itemDescription.text = item.description
        Glide.with(binding.root).load(item.dishImage).into(binding.itemImage)
        binding.cancel.setOnClickListener { dismiss() }
        binding.addToCartBtn.setOnClickListener {
            viewModel.insertCartItem(item = item)
            dismiss()
        }
    }
}
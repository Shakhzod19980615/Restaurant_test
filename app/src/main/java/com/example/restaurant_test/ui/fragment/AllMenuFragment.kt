package com.example.restaurant_test.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant_test.R
import com.example.restaurant_test.databinding.FragmentAllMenuBinding
import com.example.restaurant_test.databinding.FragmentHomeBinding
import com.example.restaurant_test.di.AppComponent
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.ui.adapters.MenuListAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import javax.inject.Inject
import kotlin.properties.Delegates


class AllMenuFragment: Fragment(R.layout.fragment_all_menu) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentAllMenuBinding by Delegates.notNull()
    private  var viewModel : CategoryViewModel by Delegates.notNull()

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
        binding = FragmentAllMenuBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =ViewModelProvider(this,viewModelFactory).get(CategoryViewModel::class.java)
        val menuRV = view.findViewById<RecyclerView>(R.id.menu_rv)
        menuRV.apply {
            layoutManager = GridLayoutManager(
                requireContext(),3, GridLayoutManager.VERTICAL,false)
        }
        val menuAdapter = MenuListAdapter(layoutInflater){item ->
            fragmentManager?.let { ItemDialogFragment(item).show(it,"ItemDialogFormat",) }

        }

        menuRV.adapter = menuAdapter
        viewModel.getMenuList()
        viewModel.menuListLiveData.observe(viewLifecycleOwner){
            menuAdapter.setItems(it.menus)
        }

    }
}
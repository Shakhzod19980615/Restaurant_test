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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant_test.R
import com.example.restaurant_test.databinding.FragmentHomeBinding
import com.example.restaurant_test.di.AppComponent
import com.example.restaurant_test.ui.adapters.CategoryListAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentHomeBinding by Delegates.notNull()
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
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =ViewModelProvider(this,viewModelFactory).get(CategoryViewModel::class.java)

        val categoryRV = view.findViewById<RecyclerView>(R.id.category_rv)
        categoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),LinearLayoutManager.VERTICAL,false
            )
        }

        val categoryAdapter = CategoryListAdapter(layoutInflater ){name ->
            activity?.supportFragmentManager?.commit {
                replace<MenuFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("name" to name )
                ).addToBackStack("replacement")
            }
        }

        categoryRV.adapter =categoryAdapter
        viewModel.getCategoryList()
        viewModel.categoryListLiveData.observe(viewLifecycleOwner){
            categoryAdapter.setItems(it.categories)
        }
    }


}
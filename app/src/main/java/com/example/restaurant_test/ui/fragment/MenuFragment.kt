package com.example.restaurant_test.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.restaurant_test.R
import com.example.restaurant_test.databinding.ActivityMainBinding
import com.example.restaurant_test.databinding.FragmentMenuBinding
import com.example.restaurant_test.di.AppComponent
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer
import kotlin.properties.Delegates

class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentMenuBinding by Delegates.notNull()
    private  var viewModel : CategoryViewModel by Delegates.notNull()
    //private lateinit var tabLayout:TabLayout
    //private lateinit var viewPager2:ViewPager2

    private val categoryName : String? by lazy {
        arguments?.getString("name")
    }
    private lateinit var adapter: FragmentPageAdapter
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
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.categoryName.text = categoryName
         binding.back.setOnClickListener {
             activity?.supportFragmentManager?.commit {
                 replace<HomeFragment>(
                     containerViewId = R.id.fragment_container_view_tag,
                 ).addToBackStack("replacement")
             }
         }

        /*val subCategoryItemAdapter = SubCategoryItemAdapter(
            layoutInflater= layoutInflater,
            onFavouritemClick = {
                viewModel.insertOrDeleteFavouriteItem(item = it)

            },
            onItemClick = { keyword ->
                activity?.supportFragmentManager?.commit {
                    replace<SubMainCategoryDetails>(
                        containerViewId = R.id.fragment_container_view_tag,
                        args = bundleOf("keyword" to keyword)
                    ).addToBackStack("replacement")
                }
            }, onBasketClick = {
                viewModel.postItemToCartList(it)
                val bottomSheetCart = BottomSheetCart()
                val argsCart = Bundle()
                argsCart.putString("keyword",it)
                bottomSheetCart.arguments = argsCart
                bottomSheetCart.show(requireActivity().supportFragmentManager,"BottomSheetDialog")
            }, *//*onRemoveClick = {
                favouriteViewModel.deleteFavouriteItem(id = productMutableListModel[0])
            }*//*
        )*/
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Все меню"))
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Салаты"))
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("С рисом"))
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("С рыбой"))
         adapter = fragmentManager?.let { FragmentPageAdapter(it,lifecycle) }!!
         binding.viewpagerMain.adapter = adapter
         binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewpagerMain.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewpagerMain.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

    }
}
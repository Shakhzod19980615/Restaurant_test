package com.example.restaurant_test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurant_test.databinding.CategoryItemBinding
import com.example.restaurant_test.databinding.MenuItemBinding
import com.example.restaurant_test.domain.model.categoryModel.CategoryItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel

class MenuListAdapter(
    private val layoutInflater: LayoutInflater,
    val onItemClick: (item : MenuItemModel) -> Unit
): RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {
    private  val menuListItem : MutableList<MenuItemModel> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): MenuListAdapter.ViewHolder {
        val binding = MenuItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuListAdapter.ViewHolder, position: Int) {
        holder.bindData(menuListItem = menuListItem[position])
    }

    override fun getItemCount(): Int {
        return menuListItem.size
    }
    fun setItems(menuListItem:List<MenuItemModel>){
        this.menuListItem.clear()
        this.menuListItem.addAll(menuListItem)
        notifyDataSetChanged()
    }
    inner class ViewHolder(
        private var binding : MenuItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(menuListItem:MenuItemModel){
            binding.itemTitle.text = menuListItem.dishName
            Glide.with(binding.root).load(menuListItem.dishImage).into(binding.itemImage)
        }
        init {
            itemView.setOnClickListener {
                val item = menuListItem[bindingAdapterPosition]
                onItemClick(item)
            }

        }
    }

}
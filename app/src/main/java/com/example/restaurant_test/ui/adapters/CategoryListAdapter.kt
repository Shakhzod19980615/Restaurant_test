package com.example.restaurant_test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurant_test.databinding.CategoryItemBinding
import com.example.restaurant_test.domain.model.categoryModel.CategoryItemModel

class CategoryListAdapter(
    private val layoutInflater: LayoutInflater,
    val onItemClick: (name : String) -> Unit
):RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    private  val categoryListItem : MutableList<CategoryItemModel> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {
        val binding = CategoryItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        holder.bindData(categoryListItem=categoryListItem[position])
    }

    override fun getItemCount(): Int {
        return categoryListItem.size
    }

    fun setItems(categoryListItem : List<CategoryItemModel>){
        this.categoryListItem.clear()
        this.categoryListItem.addAll(categoryListItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding :CategoryItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(categoryListItem: CategoryItemModel){
            binding.categoryName.text = categoryListItem.name
            Glide.with(binding.root).load(categoryListItem.image).into(binding.categoryImage)
        }
        init {
            itemView.setOnClickListener {
                val item =categoryListItem[bindingAdapterPosition]
                onItemClick(item.name)
            }
        }
    }

}
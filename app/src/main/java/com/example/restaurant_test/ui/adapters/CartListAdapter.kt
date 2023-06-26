package com.example.restaurant_test.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurant_test.databinding.ItemCartBinding
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.ui.viewmodels.CartViewModel
import kotlin.properties.Delegates

class CartListAdapter(
    private val layoutInflater: LayoutInflater,
    private val onMinusClicked : (item:MenuItemModel)->Unit,
    private val onAddClicked : (item:MenuItemModel)->Unit,
    //val onItemClick: (totalPrice : String) -> Unit,
):RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    private val cartListItem : MutableList<MenuItemModel> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartListAdapter.ViewHolder {
        val binding = ItemCartBinding.inflate(layoutInflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartListAdapter.ViewHolder, position: Int) {
        holder.bindData(cartListItem=cartListItem[position])

    }

    override fun getItemCount(): Int {
        return  cartListItem.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setItems(cartListAddedItem: List<MenuItemModel>){
        this.cartListItem.clear()
        this.cartListItem.addAll(cartListAddedItem)
        notifyDataSetChanged()

    }

    inner class ViewHolder(
        private val binding: ItemCartBinding
    ):RecyclerView.ViewHolder(binding.root){

        @SuppressLint("NotifyDataSetChanged")
        fun bindData(cartListItem:MenuItemModel){
            binding.itemTitle.text = cartListItem.dishName
            binding.itemPrice.text = cartListItem.price.toString()
            binding.itemWeight.text = cartListItem.weight.toString()
            Glide.with(binding.root).load(cartListItem.dishImage).into(binding.itemImage)
            binding.itemCount.text = cartListItem.itemCount.toString()
            println(itemCount.toString())
            binding.btnSubtract.setOnClickListener {

                    onMinusClicked(cartListItem)
                    notifyItemChanged(bindingAdapterPosition)
                    notifyItemRangeRemoved(bindingAdapterPosition,itemCount)
                    //updatePrice()


            }
            binding.btnAdd.setOnClickListener {
                onAddClicked(cartListItem)
                notifyItemChanged(bindingAdapterPosition)
                notifyDataSetChanged()
                //updatePrice()
            }

        }

    }
   /* fun updatePrice(){
        var subTotalPrice = 0.0
        for (item in 0 until  cartListItem.size){
            subTotalPrice += cartListItem[item].price * cartListItem[item].itemCount
            onItemClick(subTotalPrice.toString())
        }
    }*/
}
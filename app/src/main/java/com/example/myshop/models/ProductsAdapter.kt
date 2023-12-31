package com.example.myshop.models



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductsListsBinding

import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation


class ProductsAdapter (var productList:List<Products>):RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =ProductsListsBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct =productList[position]
        var  binding=holder.binding
        binding.tvId.text=currentProduct.id.toString()
        binding.tvTitle.text=currentProduct.title.toString()
        binding.tvDescription.text=currentProduct.description.toString()
        binding.tvPrice.text=currentProduct.price.toString()
        binding.tvRating.text=currentProduct.rating.toString()
        binding.tvStock.text=currentProduct.stock.toString()
        binding.tvCategory.text=currentProduct.category.toString()
//        binding.ivThumbnail.text=currentProduct.thumbnail
        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .transform(CropCircleTransformation())
            .into(binding.ivThumbnail)

    }
    override fun getItemCount(): Int {
        return productList.size
    }
}
class ProductViewHolder( var binding:ProductsListsBinding): RecyclerView.ViewHolder(binding.root)


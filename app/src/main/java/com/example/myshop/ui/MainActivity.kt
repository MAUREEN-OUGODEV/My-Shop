package com.example.myshop.ui



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.ViewModels.ProductsViewModel
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.models.Products
import com.example.myshop.models.ProductsAdapter


class MainActivity : AppCompatActivity() {
    val productViewModel: ProductsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductsAdapter
    var productList: List<Products> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductsAdapter(emptyList())

    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProduct()
        productViewModel.productsLiveData.observe(this, Observer { productList->
            var productAdapter = ProductsAdapter(productList ?: emptyList())
            binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProducts.adapter = productAdapter
            Toast.makeText(
                baseContext,
                "fetched ${productList?.size} products",
                Toast.LENGTH_LONG
            ).show()
        })
        productViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()
        })
    }
}

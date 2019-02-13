package br.com.wcisang.lodjinhaclean.ui.productList

import android.os.Bundle
import androidx.lifecycle.Observer
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.R
import br.com.wcisang.lodjinhaclean.ui.BaseActivity
import br.com.wcisang.lodjinhaclean.ui.util.ResourceState

class ProductListActivity : BaseActivity<ProductListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        registerObservers()
        viewModel.getProducts(1)
    }

    private fun registerObservers() {
        viewModel.productLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> showLoading()
                ResourceState.SUCCESS -> successList(it.data)
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })
    }

    private fun showLoading() {

    }

    private fun successList(data: List<Produto>?) {

    }

    private fun showGenericError(message: String?) {

    }

    override fun getViewModel(): Class<ProductListViewModel> = ProductListViewModel::class.java
}

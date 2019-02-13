package br.com.wcisang.lodjinhaclean.ui.productDetail

import android.os.Bundle
import androidx.lifecycle.Observer
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.R
import br.com.wcisang.lodjinhaclean.ui.BaseActivity
import br.com.wcisang.lodjinhaclean.ui.util.ResourceState

class ProductDetailActivity : BaseActivity<ProductDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        registerObservers()
        viewModel.getProductDetail(3)
    }

    override fun getViewModel(): Class<ProductDetailViewModel> = ProductDetailViewModel::class.java

    private fun registerObservers() {
        viewModel.productLiveData.observe(this, Observer {
            when(it.status) {
                ResourceState.LOADING -> showLoading()
                ResourceState.SUCCESS -> successProduct(it.data)
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })

        viewModel.reserveLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> showLoadingReserve()
                ResourceState.SUCCESS -> successReserve()
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })
    }

    private fun successReserve() {

    }

    private fun showLoadingReserve() {

    }

    private fun showLoading() {

    }

    private fun successProduct(data: Produto?) {

    }

    private fun showGenericError(message: String?) {

    }

}

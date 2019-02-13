package br.com.wcisang.lodjinhaclean.ui.productList

import android.os.Bundle
import br.com.wcisang.lodjinhaclean.R
import br.com.wcisang.lodjinhaclean.ui.BaseActivity

class ProductListActivity : BaseActivity<ProductListViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        viewModel.getProducts(1)
    }

    override fun getViewModel(): Class<ProductListViewModel> = ProductListViewModel::class.java
}

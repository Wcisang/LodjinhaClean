package br.com.wcisang.lodjinhaclean.ui.productDetail

import android.os.Bundle
import br.com.wcisang.lodjinhaclean.R
import br.com.wcisang.lodjinhaclean.ui.BaseActivity

class ProductDetailActivity : BaseActivity<ProductDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
    }

    override fun getViewModel(): Class<ProductDetailViewModel> = ProductDetailViewModel::class.java


}

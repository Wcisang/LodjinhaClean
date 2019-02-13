package br.com.wcisang.lodjinhaclean

import android.os.Bundle
import br.com.wcisang.lodjinhaclean.ui.BaseActivity
import br.com.wcisang.lodjinhaclean.ui.home.HomeFragment
import br.com.wcisang.lodjinhaclean.ui.productDetail.ProductDetailViewModel

class MainActivity : BaseActivity<ProductDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, HomeFragment())
            .commit()
    }

    override fun getViewModel(): Class<ProductDetailViewModel> {
        return ProductDetailViewModel::class.java
    }
}

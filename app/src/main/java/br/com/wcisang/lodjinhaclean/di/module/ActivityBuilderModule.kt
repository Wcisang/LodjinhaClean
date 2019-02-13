package br.com.wcisang.lodjinhaclean.di.module

import br.com.wcisang.lodjinhaclean.MainActivity
import br.com.wcisang.lodjinhaclean.ui.productDetail.ProductDetailActivity
import br.com.wcisang.lodjinhaclean.ui.productList.ProductListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun bindsMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun bindsProductListActivity() : ProductListActivity

    @ContributesAndroidInjector
    abstract fun bindsContributesAndroidInjector() : ProductDetailActivity

}
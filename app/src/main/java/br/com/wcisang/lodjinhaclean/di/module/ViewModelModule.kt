package br.com.wcisang.lodjinhaclean.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.wcisang.lodjinhaclean.di.ViewModelFactory
import br.com.wcisang.lodjinhaclean.ui.home.HomeViewModel
import br.com.wcisang.lodjinhaclean.ui.productDetail.ProductDetailViewModel
import br.com.wcisang.lodjinhaclean.ui.productList.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    abstract fun bindProductDetailViewModel(viewModel: ProductDetailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindProductListViewModel(viewModel: ProductListViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

}
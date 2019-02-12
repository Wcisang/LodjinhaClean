package br.com.wcisang.lodjinhaclean.di.module

import br.com.wcisang.data.local.source.banner.BannerLocalDataSource
import br.com.wcisang.data.local.source.banner.BannerLocalDataSourceImpl
import br.com.wcisang.data.local.source.category.CategoriaLocalDataSource
import br.com.wcisang.data.local.source.category.CategoriaLocalDataSourceImpl
import br.com.wcisang.data.local.source.product.ProdutoLocalDataSource
import br.com.wcisang.data.local.source.product.ProdutoLocalDataSourceImpl
import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.data.remote.service.LodjinhaServiceFactory
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSourceImpl
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSource
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSourceImpl
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSource
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSourceImpl
import br.com.wcisang.data.repository.BannerRepositoryImpl
import br.com.wcisang.data.repository.CategoriaRepositoryImpl
import br.com.wcisang.data.repository.ProdutoRepositoryImpl
import br.com.wcisang.domain.repository.BannerRepository
import br.com.wcisang.domain.repository.CategoriaRepository
import br.com.wcisang.domain.repository.ProdutoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideLodjinhaService() : LodjinhaService {
            return LodjinhaServiceFactory.makeLodjinhaService()
        }
    }

    @Binds
    abstract fun bindBannerRepository(bannerRepository: BannerRepositoryImpl) : BannerRepository

    @Binds
    abstract fun bindBannerRemoteDataSource(bannerRemoteDataSourceImpl: BannerRemoteDataSourceImpl) : BannerRemoteDataSource

    @Binds
    abstract fun bindBannerLocalDataSource(bannerLocalDataSourceImpl: BannerLocalDataSourceImpl) : BannerLocalDataSource



    @Binds
    abstract fun bindCategoriaRepository(categoriaRepositoryImpl: CategoriaRepositoryImpl) : CategoriaRepository

    @Binds
    abstract fun bindCategoriaRemoteDataSource(categoriaRemoteDataSourceImpl: CategoriaRemoteDataSourceImpl) : CategoriaRemoteDataSource

    @Binds
    abstract fun bindCategoriaLocalDataSource(categoriaLocalDataSourceImpl: CategoriaLocalDataSourceImpl) : CategoriaLocalDataSource



    @Binds
    abstract fun bindProdutoRepository(produtoRepositoryImpl: ProdutoRepositoryImpl) : ProdutoRepository

    @Binds
    abstract fun bindprodutoRemoteDataSource(produtoRemoteDataSourceImpl: ProdutoRemoteDataSourceImpl) : ProdutoRemoteDataSource

    @Binds
    abstract fun bindProdutoLocalDataSource(produtoLocalDataSourceImpl: ProdutoLocalDataSourceImpl) : ProdutoLocalDataSource

}
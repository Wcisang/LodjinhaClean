package br.com.wcisang.lodjinhaclean.di.module

import br.com.wcisang.data.local.source.banner.BannerLocalDataSource
import br.com.wcisang.data.local.source.banner.BannerLocalDataSourceImpl
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSourceImpl
import br.com.wcisang.data.repository.BannerRepositoryImpl
import br.com.wcisang.domain.repository.BannerRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindBannerRepository(bannerRepository: BannerRepositoryImpl) : BannerRepository

    @Binds
    abstract fun bindBannerRemoteDataSource(bannerRemoteDataSourceImpl: BannerRemoteDataSourceImpl) : BannerRemoteDataSource

    @Binds
    abstract fun bindBannerLocalDataSource(bannerLocalDataSourceImpl: BannerLocalDataSourceImpl) : BannerLocalDataSource
}
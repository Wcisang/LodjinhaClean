package br.com.wcisang.data.repository

import br.com.wcisang.data.local.source.banner.BannerLocalDataSource
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository
import io.reactivex.Single
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
    var bannerLocalDataSource: BannerLocalDataSource,
    var bannerRemoteDataSource: BannerRemoteDataSource
): BannerRepository {

    override fun getBanners(): Single<List<Banner>> = bannerRemoteDataSource.getBanners()

}
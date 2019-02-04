package br.com.wcisang.data.remote.source.banner

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Banner
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class BannerRemoteDataSourceImpl @Inject constructor(
    var service: LodjinhaService
) : BannerRemoteDataSource {

    override fun getBanners(): Single<List<Banner>> {
        return service.getBanners()
            .map {
                it.data
            }
    }
}
package br.com.wcisang.data.remote.source.banner

import br.com.wcisang.domain.model.Banner
import io.reactivex.Single

interface BannerRemoteDataSource {

    fun getBanners() : Single<List<Banner>>
}
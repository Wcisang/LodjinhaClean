package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Banner
import io.reactivex.Single

interface BannerRepository {

    fun getBanners() : Single<List<Banner>>
}
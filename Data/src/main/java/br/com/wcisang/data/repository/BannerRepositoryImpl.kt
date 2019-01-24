package br.com.wcisang.data.repository

import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository
import io.reactivex.Single
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(

): BannerRepository {

    override fun getBanners(): Single<List<Banner>> {

    }
}
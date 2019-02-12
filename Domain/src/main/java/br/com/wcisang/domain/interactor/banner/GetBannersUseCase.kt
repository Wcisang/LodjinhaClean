package br.com.wcisang.domain.interactor.banner

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository
import io.reactivex.Single
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(
    var bannerRepository: BannerRepository,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Banner>, Nothing>(postExecutionThread){


    override fun buildUseCaseObservable(params: Nothing?): Single<List<Banner>> {
        return bannerRepository.getBanners()
    }


}
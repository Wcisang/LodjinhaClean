package br.com.wcisang.domain.interactor.banner

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.factory.banner.BannerFactory
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetBannerUseCaseTest {

    private lateinit var getBannersUseCase: GetBannersUseCase
    @Mock lateinit var bannerRepository: BannerRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getBannersUseCase = GetBannersUseCase(bannerRepository, postExecutionThread)
    }

    @Test
    fun getBannersCompletes() {
        stubBanners(Single.just(BannerFactory.makeBannerList(3)))
        val testSingle = getBannersUseCase.buildUseCaseObservable().test()
        testSingle.assertComplete()
    }

    @Test
    fun getBannersReturnData() {
        val banners = BannerFactory.makeBannerList(3)
        stubBanners(Single.just(banners))
        val testSingle = getBannersUseCase.buildUseCaseObservable().test()
        testSingle.assertValue(banners)
    }

    private fun stubBanners(observable: Single<List<Banner>>) {
        whenever(bannerRepository.getBanners())
            .thenReturn(observable)
    }
}
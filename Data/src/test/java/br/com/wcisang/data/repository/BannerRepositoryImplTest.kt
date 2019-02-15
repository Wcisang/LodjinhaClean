package br.com.wcisang.data.repository

import br.com.wcisang.data.factory.banner.BannerFactory
import br.com.wcisang.data.local.source.banner.BannerLocalDataSource
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.domain.model.Banner
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class BannerRepositoryImplTest {

    private val bannerRemoteDataSource = mock<BannerRemoteDataSource>()
    private val bannerLocalDataSource = mock<BannerLocalDataSource>()
    private val repository = BannerRepositoryImpl(bannerLocalDataSource, bannerRemoteDataSource)

    @Test
    fun getBannersCompletes() {
        stubGetBanners(Single.just(BannerFactory.makeBannerList(3)))
        val testObserver = repository.getBanners().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBannersReturnData() {
        val banners = BannerFactory.makeBannerList(3)
        stubGetBanners(Single.just(banners))
        val testObserver = repository.getBanners().test()
        testObserver.assertValue(banners)
    }

    private fun stubGetBanners(single: Single<List<Banner>>) {
        whenever(bannerRemoteDataSource.getBanners())
            .thenReturn(single)
    }
}
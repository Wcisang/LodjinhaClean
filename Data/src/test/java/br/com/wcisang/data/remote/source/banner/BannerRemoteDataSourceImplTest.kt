package br.com.wcisang.data.remote.source.banner

import br.com.wcisang.data.factory.banner.BannerFactory
import br.com.wcisang.data.remote.response.BannerResponse
import br.com.wcisang.data.remote.service.LodjinhaService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class BannerRemoteDataSourceImplTest {

    private val service = mock<LodjinhaService>()
    private val remote = BannerRemoteDataSourceImpl(service)


    @Test
    fun getBannersCompletes() {
        stubService(Single.just(BannerFactory.makeBannerResponse(3)))
        val test = remote.getBanners().test()
        test.assertComplete()
    }

    @Test
    fun getBannersCallsServer() {
        stubService(Single.just(BannerFactory.makeBannerResponse(3)))
        remote.getBanners().test()
        verify(service).getBanners()
    }

    @Test
    fun getBannersReturnData() {
        val response = BannerFactory.makeBannerResponse(3)
        stubService(Single.just(response))
        val test = remote.getBanners().test()
        test.assertValue(response.data)
    }

    fun stubService(observable: Single<BannerResponse>) {
        whenever(service.getBanners())
            .thenReturn(observable)
    }
}
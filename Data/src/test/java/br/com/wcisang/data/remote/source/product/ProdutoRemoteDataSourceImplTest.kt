package br.com.wcisang.data.remote.source.product

import br.com.wcisang.data.factory.produto.ProdutoFactory
import br.com.wcisang.data.remote.response.ProductsResponse
import br.com.wcisang.data.remote.response.ProdutoBestSellersResponse
import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Produto
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class ProdutoRemoteDataSourceImplTest {

    private val service = mock<LodjinhaService>()
    private val remote = ProdutoRemoteDataSourceImpl(service)

    @Test
    fun getProductListCompletes() {
        stubServiceProductList(Single.just(ProdutoFactory.makeProductListResponse(3)))
        val test = remote.getProductList(any()).test()
        test.assertComplete()
    }

    @Test
    fun getProductListCallsServer() {
        stubServiceProductList(Single.just(ProdutoFactory.makeProductListResponse(3)))
        remote.getProductList(any()).test()
        verify(service).getProducts(any())
    }

    @Test
    fun getProductListReturnData() {
        val response = ProdutoFactory.makeProductListResponse(3)
        stubServiceProductList(Single.just(response))
        val test = remote.getProductList(any()).test()
        test.assertValue(response.data)
    }

    fun stubServiceProductList(observable: Single<ProductsResponse>) {
        whenever(service.getProducts(any()))
            .thenReturn(observable)
    }


    @Test
    fun getProductBestSellersCompletes() {
        stubServiceProductBestSellers(Single.just(ProdutoFactory.makeProductBestSellersResponse(3)))
        val test = remote.getBestSellers().test()
        test.assertComplete()
    }

    @Test
    fun getProductBestSellersCallsServer() {
        stubServiceProductBestSellers(Single.just(ProdutoFactory.makeProductBestSellersResponse(3)))
        remote.getBestSellers().test()
        verify(service).getBestSellingProducts()
    }

    @Test
    fun getProductBestSellersReturnData() {
        val response = ProdutoFactory.makeProductBestSellersResponse(3)
        stubServiceProductBestSellers(Single.just(response))
        val test = remote.getBestSellers().test()
        test.assertValue(response.data)
    }

    fun stubServiceProductBestSellers(observable: Single<ProdutoBestSellersResponse>) {
        whenever(service.getBestSellingProducts())
            .thenReturn(observable)
    }

    @Test
    fun getProductDetailCompletes() {
        stubServiceProductDetail(Single.just(ProdutoFactory.makeProduto()))
        val test = remote.getProductDetail(any()).test()
        test.assertComplete()
    }

    @Test
    fun getProductDetailCallsServer() {
        stubServiceProductDetail(Single.just(ProdutoFactory.makeProduto()))
        remote.getProductDetail(any()).test()
        verify(service).getProductDetail(any())
    }

    @Test
    fun getProductDetailReturnData() {
        val response = ProdutoFactory.makeProduto()
        stubServiceProductDetail(Single.just(response))
        val test = remote.getProductDetail(any()).test()
        test.assertValue(response)
    }

    fun stubServiceProductDetail(observable: Single<Produto>) {
        whenever(service.getProductDetail(any()))
            .thenReturn(observable)
    }
}
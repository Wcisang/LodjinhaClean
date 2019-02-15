package br.com.wcisang.data.repository

import br.com.wcisang.data.local.source.product.ProdutoLocalDataSource
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSource
import br.com.wcisang.data.factory.produto.ProdutoFactory
import br.com.wcisang.domain.model.Produto
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Test

class ProdutoRepositoryImplTest {

    private val remoteDataSource = mock<ProdutoRemoteDataSource>()
    private val localDataSource = mock<ProdutoLocalDataSource>()
    private val repository = ProdutoRepositoryImpl(remoteDataSource, localDataSource)


    @Test
    fun getProdutosBestSellersCompletes() {
        stubProdutosBestSellers(Single.just(ProdutoFactory.makeProdutoList(3)))
        val testSingle = repository.getBestSellers().test()
        testSingle.assertComplete()
    }

    @Test
    fun getProdutosBestSellersReturnData() {
        val produtos = ProdutoFactory.makeProdutoList(3)
        stubProdutosBestSellers(Single.just(produtos))
        val testSingle = repository.getBestSellers().test()
        testSingle.assertValue(produtos)
    }

    @Test
    fun getProdutosListCompletes() {
        stubProdutosList(Single.just(ProdutoFactory.makeProdutoList(3)))
        val testSingle = repository.getProductList(any()).test()
        testSingle.assertComplete()
    }

    @Test
    fun getProdutosListReturnData() {
        val produtos = ProdutoFactory.makeProdutoList(3)
        stubProdutosList(Single.just(produtos))
        val testSingle = repository.getProductList(any()).test()
        testSingle.assertValue(produtos)
    }

    @Test
    fun getProdutoDetailCompletes() {
        stubProdutoDetail(Single.just(ProdutoFactory.makeProduto()))
        val testSingle = repository.getProductDetail(any()).test()
        testSingle.assertComplete()
    }

    @Test
    fun getProdutoDetailReturnData() {
        val produto = ProdutoFactory.makeProduto()
        stubProdutoDetail(Single.just(produto))
        val testSingle = repository.getProductDetail(any()).test()
        testSingle.assertValue(produto)
    }

    @Test
    fun reserveProductCompletes() {
        stubReserve(Completable.complete())
        val testObserver = repository.reserveProduct(any()).test()
        testObserver.assertComplete()
    }

    private fun stubProdutosBestSellers(observable: Single<List<Produto>>) {
        whenever(remoteDataSource.getBestSellers())
            .thenReturn(observable)
    }

    private fun stubProdutoDetail(observable: Single<Produto>) {
        whenever(remoteDataSource.getProductDetail(any()))
            .thenReturn(observable)
    }

    private fun stubProdutosList(observable: Single<List<Produto>>) {
        whenever(remoteDataSource.getProductList(any()))
            .thenReturn(observable)
    }

    private fun stubReserve(observable: Completable) {
        whenever(remoteDataSource.reserveProduct(any()))
            .thenReturn(observable)
    }
}
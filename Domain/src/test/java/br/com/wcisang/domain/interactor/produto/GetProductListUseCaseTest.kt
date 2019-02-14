package br.com.wcisang.domain.interactor.produto

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.factory.categoria.CategoryFactory
import br.com.wcisang.domain.factory.produto.ProdutoFactory
import br.com.wcisang.domain.interactor.product.GetProductListUseCase
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetProductListUseCaseTest {

    private lateinit var getProductListUseCase: GetProductListUseCase
    @Mock lateinit var productRepository: ProdutoRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProductListUseCase = GetProductListUseCase(postExecutionThread, productRepository)
    }

    @Test
    fun getProdutosCompletes() {
        stubProdutos(Single.just(ProdutoFactory.makeProdutoList(3)))
        val testSingle = getProductListUseCase.buildUseCaseObservable(
            GetProductListUseCase.Params.forProducts(any())).test()
        testSingle.assertComplete()
    }

    @Test
    fun getProdutosReturnData() {
        val produtos = ProdutoFactory.makeProdutoList(3)
        stubProdutos(Single.just(produtos))
        val testSingle = getProductListUseCase.buildUseCaseObservable(
            GetProductListUseCase.Params.forProducts(any())).test()
        testSingle.assertValue(produtos)
    }

    private fun stubProdutos(observable: Single<List<Produto>>) {
        whenever(productRepository.getProductList(any()))
            .thenReturn(observable)
    }
}
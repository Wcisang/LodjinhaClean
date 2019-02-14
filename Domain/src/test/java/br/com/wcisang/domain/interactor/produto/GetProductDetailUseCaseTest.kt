package br.com.wcisang.domain.interactor.produto

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.factory.produto.ProdutoFactory
import br.com.wcisang.domain.interactor.product.GetProductDetailUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetProductDetailUseCaseTest {

    private lateinit var getProductDetailUseCase : GetProductDetailUseCase
    @Mock lateinit var productRepository: ProdutoRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProductDetailUseCase = GetProductDetailUseCase(postExecutionThread, productRepository)
    }

    @Test
    fun getProdutoDetailCompletes() {
        stubBanners(Single.just(ProdutoFactory.makeProduto()))
        val testSingle = getProductDetailUseCase.buildUseCaseObservable(
            GetProductDetailUseCase.Params.forProject(any())).test()
        testSingle.assertComplete()
    }

    @Test
    fun getProdutoDetailReturnData() {
        val produto = ProdutoFactory.makeProduto()
        stubBanners(Single.just(produto))
        val testSingle = getProductDetailUseCase.buildUseCaseObservable(
            GetProductDetailUseCase.Params.forProject(any())).test()
        testSingle.assertValue(produto)
    }

    private fun stubBanners(observable: Single<Produto>) {
        whenever(productRepository.getProductDetail(any()))
            .thenReturn(observable)
    }
}
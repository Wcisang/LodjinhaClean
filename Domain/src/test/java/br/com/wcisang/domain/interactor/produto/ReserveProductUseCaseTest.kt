package br.com.wcisang.domain.interactor.produto

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.factory.DataFactory
import br.com.wcisang.domain.factory.produto.ProdutoFactory
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.domain.interactor.product.ReserveProductUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ReserveProductUseCaseTest {

    private lateinit var reserveProductUseCase: ReserveProductUseCase
    @Mock lateinit var productRepository: ProdutoRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        reserveProductUseCase = ReserveProductUseCase(postExecutionThread, productRepository)
    }

    @Test
    fun reserveProductCompletes() {
        stubReserve(Completable.complete())
        val testObserver = reserveProductUseCase.buildUseCaseCompletable(
            ReserveProductUseCase.Params.forProject(DataFactory.randomInt())
        ).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun reserveProductThrowsException() {
        reserveProductUseCase.buildUseCaseCompletable().test()
    }

    private fun stubReserve(observable: Completable) {
        whenever(productRepository.reserveProduct(any()))
            .thenReturn(observable)
    }

}
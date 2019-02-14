package br.com.wcisang.domain.interactor.categoria

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.factory.categoria.CategoryFactory
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.repository.CategoriaRepository
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetCategoriaUseCaseTest {

    private lateinit var getCategoriasUseCase: GetCategoriasUseCase
    @Mock lateinit var categoriaRepository : CategoriaRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getCategoriasUseCase = GetCategoriasUseCase(categoriaRepository, postExecutionThread)
    }

    @Test
    fun getBannersCompletes() {
        stubBanners(Single.just(CategoryFactory.makeCategoriaList(3)))
        val testSingle = getCategoriasUseCase.buildUseCaseObservable().test()
        testSingle.assertComplete()
    }

    @Test
    fun getBannersReturnData() {
        val categorias = CategoryFactory.makeCategoriaList(3)
        stubBanners(Single.just(categorias))
        val testSingle = getCategoriasUseCase.buildUseCaseObservable().test()
        testSingle.assertValue(categorias)
    }

    private fun stubBanners(observable: Single<List<Categoria>>) {
        whenever(categoriaRepository.getCategorias())
            .thenReturn(observable)
    }
}
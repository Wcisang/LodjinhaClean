package br.com.wcisang.data.remote.source.category

import br.com.wcisang.data.factory.categoria.CategoryFactory
import br.com.wcisang.data.remote.response.CategoriasResponse
import br.com.wcisang.data.remote.service.LodjinhaService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class CategoriaRemoteDataSourceImplTest {

    private val service = mock<LodjinhaService>()
    private val remote = CategoriaRemoteDataSourceImpl(service)


    @Test
    fun getCategoriesCompletes() {
        stubService(Single.just(CategoryFactory.makeCategoriaResponse(3)))
        val test = remote.getCategorias().test()
        test.assertComplete()
    }

    @Test
    fun getCategoriesCallsServer() {
        stubService(Single.just(CategoryFactory.makeCategoriaResponse(3)))
        remote.getCategorias().test()
        verify(service).getCategorias()
    }

    @Test
    fun getCategoriesReturnData() {
        val response = CategoryFactory.makeCategoriaResponse(3)
        stubService(Single.just(response))
        val test = remote.getCategorias().test()
        test.assertValue(response.data)
    }

    fun stubService(observable: Single<CategoriasResponse>) {
        whenever(service.getCategorias())
            .thenReturn(observable)
    }
}
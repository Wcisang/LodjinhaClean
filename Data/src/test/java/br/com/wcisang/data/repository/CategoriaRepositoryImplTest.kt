package br.com.wcisang.data.repository

import br.com.wcisang.data.factory.categoria.CategoryFactory
import br.com.wcisang.data.local.source.category.CategoriaLocalDataSource
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSource
import br.com.wcisang.domain.model.Categoria
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class CategoriaRepositoryImplTest {

    private val categoriaRemoteDataSource = mock<CategoriaRemoteDataSource>()
    private val categoriaLocalDataSource = mock<CategoriaLocalDataSource>()
    private val repository = CategoriaRepositoryImpl(categoriaRemoteDataSource, categoriaLocalDataSource)

    @Test
    fun getCAtegoriasCompletes() {
        stubGetCategorias(Single.just(CategoryFactory.makeCategoriaList(3)))
        val testObserver = repository.getCategorias().test()
        testObserver.assertComplete()
    }

    @Test
    fun getCategoriasReturnData() {
        val categories = CategoryFactory.makeCategoriaList(3)
        stubGetCategorias(Single.just(categories))
        val testObserver = repository.getCategorias().test()
        testObserver.assertValue(categories)
    }

    private fun stubGetCategorias(single: Single<List<Categoria>>) {
        whenever(categoriaRemoteDataSource.getCategorias())
            .thenReturn(single)
    }
}
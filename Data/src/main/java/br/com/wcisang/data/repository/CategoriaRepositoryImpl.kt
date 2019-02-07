package br.com.wcisang.data.repository

import br.com.wcisang.data.local.source.category.CategoriaLocalDataSource
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSource
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.repository.CategoriaRepository
import io.reactivex.Single
import javax.inject.Inject

class CategoriaRepositoryImpl @Inject constructor(
    var categoriaRemoteDataSource: CategoriaRemoteDataSource,
    var categoriaLocalDataSource: CategoriaLocalDataSource
): CategoriaRepository {


    override fun getCategorias(): Single<List<Categoria>> {
        return categoriaRemoteDataSource.getCategorias()
    }
}
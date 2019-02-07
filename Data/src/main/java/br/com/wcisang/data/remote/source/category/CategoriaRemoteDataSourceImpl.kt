package br.com.wcisang.data.remote.source.category

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single
import javax.inject.Inject

class CategoriaRemoteDataSourceImpl @Inject constructor(
    var lodjinhaService: LodjinhaService
) : CategoriaRemoteDataSource {


    override fun getCategorias(): Single<List<Categoria>> {
        return lodjinhaService
            .getCategorias()
            .map { it.data }
    }
}
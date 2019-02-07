package br.com.wcisang.data.remote.source.category

import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single

interface CategoriaRemoteDataSource {

    fun getCategorias() : Single<List<Categoria>>
}
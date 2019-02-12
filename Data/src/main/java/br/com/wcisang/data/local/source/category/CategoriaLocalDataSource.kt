package br.com.wcisang.data.local.source.category

import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single

interface CategoriaLocalDataSource {

    fun getCategorias() : Single<List<Categoria>>
}
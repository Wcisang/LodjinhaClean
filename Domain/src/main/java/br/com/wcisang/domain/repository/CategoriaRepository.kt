package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single

interface CategoriaRepository {

    fun getCategorias() : Single<List<Categoria>>
}
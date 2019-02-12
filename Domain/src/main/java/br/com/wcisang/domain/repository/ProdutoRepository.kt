package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Produto
import io.reactivex.Single

interface ProdutoRepository {

    fun getBestSellers() : Single<List<Produto>>
}
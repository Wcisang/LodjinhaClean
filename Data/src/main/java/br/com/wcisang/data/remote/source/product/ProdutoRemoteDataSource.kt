package br.com.wcisang.data.remote.source.product

import br.com.wcisang.domain.model.Produto
import io.reactivex.Single

interface ProdutoRemoteDataSource {

    fun getBestSellers() : Single<List<Produto>>
    fun getProductList(categoryId: Int) : Single<List<Produto>>
}
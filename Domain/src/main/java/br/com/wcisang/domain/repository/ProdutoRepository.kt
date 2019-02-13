package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Produto
import io.reactivex.Completable
import io.reactivex.Single

interface ProdutoRepository {

    fun getBestSellers() : Single<List<Produto>>

    fun getProductList(categoryId: Int) : Single<List<Produto>>

    fun getProductDetail(productId: Int) : Single<Produto>

    fun reserveProduct(productId: Int) : Completable
}
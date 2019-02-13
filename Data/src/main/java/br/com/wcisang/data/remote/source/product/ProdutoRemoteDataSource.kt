package br.com.wcisang.data.remote.source.product

import br.com.wcisang.domain.model.Produto
import io.reactivex.Completable
import io.reactivex.Single

interface ProdutoRemoteDataSource {

    fun getBestSellers() : Single<List<Produto>>
    fun getProductList(categoryId: Int) : Single<List<Produto>>
    fun getProductDetail(productId: Int) : Single<Produto>
    fun reserveProduct(productId: Int) : Completable
}
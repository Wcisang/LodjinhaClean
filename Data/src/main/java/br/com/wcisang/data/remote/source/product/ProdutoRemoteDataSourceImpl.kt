package br.com.wcisang.data.remote.source.product

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Produto
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ProdutoRemoteDataSourceImpl @Inject constructor(
    val lodjinhaService: LodjinhaService
) : ProdutoRemoteDataSource{


    override fun reserveProduct(productId: Int): Completable {
        return lodjinhaService.reserveProduct(productId)
    }


    override fun getProductDetail(productId: Int): Single<Produto> {
        return lodjinhaService.getProductDetail(productId)
    }

    override fun getBestSellers(): Single<List<Produto>> {
        return lodjinhaService
            .getBestSellingProducts()
            .map { it.data }
    }

    override fun getProductList(categoryId: Int): Single<List<Produto>> {
        return lodjinhaService
            .getProducts(categoryId)
            .map { it.data }
    }
}
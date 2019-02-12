package br.com.wcisang.data.remote.source.product

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Produto
import io.reactivex.Single
import javax.inject.Inject

class ProdutoRemoteDataSourceImpl @Inject constructor(
    val lodjinhaService: LodjinhaService
) : ProdutoRemoteDataSource{

    override fun getBestSellers(): Single<List<Produto>> {
        return lodjinhaService
            .getBestSellingProducts()
            .map { it.data }
    }
}
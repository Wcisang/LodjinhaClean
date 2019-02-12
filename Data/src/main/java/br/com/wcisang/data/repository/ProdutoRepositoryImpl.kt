package br.com.wcisang.data.repository

import br.com.wcisang.data.local.source.product.ProdutoLocalDataSource
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSource
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import io.reactivex.Single
import javax.inject.Inject

class ProdutoRepositoryImpl @Inject constructor(
    var produtoRemoteDataSource: ProdutoRemoteDataSource,
    var produtoLocalDataSource: ProdutoLocalDataSource
): ProdutoRepository {

    override fun getBestSellers(): Single<List<Produto>> {
        return produtoRemoteDataSource.getBestSellers()
    }
}
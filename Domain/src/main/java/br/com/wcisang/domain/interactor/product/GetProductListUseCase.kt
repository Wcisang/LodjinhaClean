package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    val produtoRepository: ProdutoRepository
): SingleUseCase<List<Produto>, GetProductListUseCase.Params>(postExecutionThread){

    override fun buildUseCaseObservable(params: Params?): Single<List<Produto>> {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        return produtoRepository.getProductList(params.categoryId)
    }


    data class Params constructor(val categoryId: Int) {
        companion object {
            fun forProducts(categoryId: Int) : Params {
                return Params(categoryId)
            }
        }
    }
}
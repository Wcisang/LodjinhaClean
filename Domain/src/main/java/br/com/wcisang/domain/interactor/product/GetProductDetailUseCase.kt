package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    val produtoRepository: ProdutoRepository
): SingleUseCase<Produto, GetProductDetailUseCase.Params>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Single<Produto> {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        return produtoRepository.getProductDetail(params.productId)
    }


    data class Params constructor(val productId : Int){
        companion object {
           fun forProject(productId: Int) : Params {
               return Params(productId)
           }
        }
    }
}
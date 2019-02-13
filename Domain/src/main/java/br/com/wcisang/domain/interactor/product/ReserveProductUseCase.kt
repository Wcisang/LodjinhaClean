package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.CompletableUseCase
import br.com.wcisang.domain.repository.ProdutoRepository
import io.reactivex.Completable
import javax.inject.Inject

class ReserveProductUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    val productRepository: ProdutoRepository
): CompletableUseCase<ReserveProductUseCase.Params>(postExecutionThread){


    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        return productRepository.reserveProduct(params.productId)
    }


    data class Params constructor(var productId: Int) {
        companion object {
            fun forProject(productId: Int) : Params{
                return Params(productId)
            }
        }
    }
}
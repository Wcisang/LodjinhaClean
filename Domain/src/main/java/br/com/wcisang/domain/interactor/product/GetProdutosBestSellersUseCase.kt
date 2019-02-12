package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProdutosBestSellersUseCase @Inject constructor(
    var produtoRepository: ProdutoRepository,
    postExecutionThread: PostExecutionThread
): SingleUseCase<List<Produto>, Nothing>(postExecutionThread){


    override fun buildUseCaseObservable(params: Nothing?): Single<List<Produto>> {
        return produtoRepository.getBestSellers()
    }
}
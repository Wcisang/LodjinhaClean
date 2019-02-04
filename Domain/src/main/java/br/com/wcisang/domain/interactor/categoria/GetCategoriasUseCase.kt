package br.com.wcisang.domain.interactor.categoria

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.repository.CategoriaRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCategoriasUseCase @Inject constructor(
    private val categoriaRepository: CategoriaRepository,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Categoria>, Nothing?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Nothing?): Single<List<Categoria>> {
        return categoriaRepository.getCategorias()
    }


}
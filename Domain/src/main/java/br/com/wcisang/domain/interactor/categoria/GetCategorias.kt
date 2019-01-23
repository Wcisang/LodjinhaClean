package br.com.wcisang.domain.interactor.categoria

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.SingleUseCase
import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single
import javax.inject.Inject

class GetCategorias @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Categoria>, Nothing?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Nothing?): Single<List<Categoria>> {

    }


}
package br.com.wcisang.data.local.source.category

import br.com.wcisang.domain.model.Categoria
import io.reactivex.Single
import javax.inject.Inject

class CategoriaLocalDataSourceImpl  @Inject constructor():
    CategoriaLocalDataSource{

    override fun getCategorias(): Single<List<Categoria>> {
        return Single.just(arrayListOf())
    }
}
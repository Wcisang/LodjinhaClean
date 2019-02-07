package br.com.wcisang.lodjinhaclean.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.categoria.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.model.Categoria
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private var getBannersUseCase: GetBannersUseCase,
    private var getCategoriasUseCase: GetCategoriasUseCase
): ViewModel() {


    override fun onCleared() {
        super.onCleared()
        getBannersUseCase.dispose()
    }

    fun getBanners() {
        getBannersUseCase.execute(BannersObserver())
    }

    fun getCategorias() {
        getCategoriasUseCase.execute(CategoriasObserver())
    }

    inner class BannersObserver : DisposableSingleObserver<List<Banner>>() {

        override fun onSuccess(t: List<Banner>) {
            Log.i("WILL_TESTE", t.toString())
        }

        override fun onError(e: Throwable) {
            Log.i("WILL_TESTE", e.localizedMessage)
        }

    }

    inner class CategoriasObserver : DisposableSingleObserver<List<Categoria>>() {

        override fun onSuccess(t: List<Categoria>) {
            Log.i("WILL_TESTE", t.toString())
        }

        override fun onError(e: Throwable) {
            Log.i("WILL_TESTE", e.localizedMessage)
        }

    }

}
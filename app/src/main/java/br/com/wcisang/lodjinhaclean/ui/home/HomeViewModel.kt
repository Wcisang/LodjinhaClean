package br.com.wcisang.lodjinhaclean.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.banner.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.ui.util.Resource
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private var getBannersUseCase: GetBannersUseCase,
    private var getCategoriasUseCase: GetCategoriasUseCase,
    private var getProdutosBestSellersUseCase: GetProdutosBestSellersUseCase
): ViewModel() {

    var bannersLiveData = MutableLiveData<Resource<List<Banner>>>()
    var categoriaLiveData = MutableLiveData<Resource<List<Categoria>>>()
    var produtoLiveData = MutableLiveData<Resource<List<Produto>>>()


    override fun onCleared() {
        super.onCleared()
        getBannersUseCase.dispose()
        getCategoriasUseCase.dispose()
        getProdutosBestSellersUseCase.dispose()
    }

    fun getBanners() {
        bannersLiveData.postValue(Resource.loading())
        getBannersUseCase.execute(BannersObserver())
    }

    fun getCategorias() {
        categoriaLiveData.postValue(Resource.loading())
        getCategoriasUseCase.execute(CategoriasObserver())
    }

    fun getBestSellers() {
        produtoLiveData.postValue(Resource.loading())
        getProdutosBestSellersUseCase.execute(BestSellersObserver())
    }

    inner class BannersObserver : DisposableSingleObserver<List<Banner>>() {

        override fun onSuccess(t: List<Banner>) {
            bannersLiveData.postValue(Resource.success(t))
        }

        override fun onError(e: Throwable) {
            bannersLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }

    inner class BestSellersObserver : DisposableSingleObserver<List<Produto>>() {

        override fun onSuccess(t: List<Produto>) {
            produtoLiveData.postValue(Resource.success(t))
        }

        override fun onError(e: Throwable) {
            produtoLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }

    inner class CategoriasObserver : DisposableSingleObserver<List<Categoria>>() {

        override fun onSuccess(t: List<Categoria>) {
            categoriaLiveData.postValue(Resource.success(t))
        }

        override fun onError(e: Throwable) {
            categoriaLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }

}
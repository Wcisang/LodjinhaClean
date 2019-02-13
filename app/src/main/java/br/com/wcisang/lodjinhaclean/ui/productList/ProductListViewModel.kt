package br.com.wcisang.lodjinhaclean.ui.productList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.product.GetProductListUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.ui.util.Resource
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
): ViewModel() {

    val productLiveData = MutableLiveData<Resource<List<Produto>>>()

    override fun onCleared() {
        super.onCleared()
        getProductListUseCase.dispose()
    }

    fun getProducts(categoryId: Int) {
        productLiveData.postValue(Resource.loading())
        getProductListUseCase.execute(
            ProductsObserver(),
            GetProductListUseCase.Params.forProducts(categoryId))
    }


    inner class ProductsObserver : DisposableSingleObserver<List<Produto>>() {
        override fun onSuccess(t: List<Produto>) {
            productLiveData.postValue(Resource.success(t))
        }

        override fun onError(e: Throwable) {
            productLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }
}
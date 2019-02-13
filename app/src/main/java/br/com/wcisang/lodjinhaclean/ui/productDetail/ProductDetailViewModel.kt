package br.com.wcisang.lodjinhaclean.ui.productDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.product.GetProductDetailUseCase
import br.com.wcisang.domain.interactor.product.ReserveProductUseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.ui.util.Resource
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    val getProductDetailUseCase: GetProductDetailUseCase,
    val reserveProductUseCase: ReserveProductUseCase
) : ViewModel(){

    val productLiveData = MutableLiveData<Resource<Produto>>()
    val reserveLiveData = MutableLiveData<Resource<Nothing?>>()

    override fun onCleared() {
        super.onCleared()
        getProductDetailUseCase.dispose()
        reserveProductUseCase.dispose()
    }

    fun getProductDetail(productoId: Int) {
        productLiveData.postValue(Resource.loading())
        getProductDetailUseCase.execute(ProductObserver(), GetProductDetailUseCase.Params(productoId))
    }

    fun reserveProduct(productoId: Int) {
        reserveLiveData.postValue(Resource.loading())
        reserveProductUseCase.execute(ReserveObserver(), ReserveProductUseCase.Params(productoId))
    }

    private inner class ProductObserver : DisposableSingleObserver<Produto>() {

        override fun onSuccess(t: Produto) {
            productLiveData.postValue(Resource.success(t))
        }

        override fun onError(e: Throwable) {
            productLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }

    private inner class ReserveObserver : DisposableCompletableObserver() {

        override fun onComplete() {
            reserveLiveData.postValue(Resource.success())
        }

        override fun onError(e: Throwable) {
            reserveLiveData.postValue(Resource.error(e.localizedMessage))
        }

    }

}
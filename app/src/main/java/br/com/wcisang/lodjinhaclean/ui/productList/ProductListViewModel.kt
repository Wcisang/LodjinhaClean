package br.com.wcisang.lodjinhaclean.ui.productList

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.product.GetProductListUseCase
import br.com.wcisang.domain.model.Produto
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        getProductListUseCase.dispose()
    }

    fun getProducts(categoryId: Int) {
        getProductListUseCase.execute(
            ProductsObserver(),
            GetProductListUseCase.Params.forProducts(categoryId))
    }


    inner class ProductsObserver : DisposableSingleObserver<List<Produto>>() {
        override fun onSuccess(t: List<Produto>) {
            Log.i("WILL_TESTE", t.toString())
        }

        override fun onError(e: Throwable) {
            Log.i("WILL_TESTE", e.localizedMessage)
        }

    }
}
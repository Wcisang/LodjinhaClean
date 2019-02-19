package br.com.wcisang.lodjinhaclean.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.wcisang.domain.interactor.banner.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.lodjinhaclean.factory.DataFactory
import br.com.wcisang.lodjinhaclean.factory.banner.BannerFactory
import br.com.wcisang.lodjinhaclean.factory.categoria.CategoryFactory
import br.com.wcisang.lodjinhaclean.factory.produto.ProdutoFactory
import br.com.wcisang.lodjinhaclean.ui.util.ResourceState
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Captor

class HomeViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getBanners = mock<GetBannersUseCase>()
    var getCategorias = mock<GetCategoriasUseCase>()
    var getBestSellers = mock<GetProdutosBestSellersUseCase>()
    var viewmodel = HomeViewModel(getBanners, getCategorias, getBestSellers)

    @Captor
    val captor = argumentCaptor<DisposableSingleObserver<List<Banner>>>()

    @Captor
    val captorCategory = argumentCaptor<DisposableSingleObserver<List<Categoria>>>()

    @Captor
    val captorProduct = argumentCaptor<DisposableSingleObserver<List<Produto>>>()

    @Test
    fun getBannersExecutesUseCase() {
        viewmodel.getBanners()
        verify(getBanners, times(1)).execute(any(), eq(null))
    }

    @Test
    fun getBannersReturnsSuccess() {
        val banners = BannerFactory.makeBannerList(3)
        viewmodel.getBanners()

        verify(getBanners).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(banners)

        Assert.assertEquals(ResourceState.SUCCESS, viewmodel.bannersLiveData.value?.status)
    }

    @Test
    fun getBannersReturnsData() {
        val banners = BannerFactory.makeBannerList(3)

        viewmodel.getBanners()

        verify(getBanners).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(banners)

        Assert.assertEquals(banners, viewmodel.bannersLiveData.value?.data)
    }


    @Test
    fun getBannersReturnsError() {
        viewmodel.getBanners()

        verify(getBanners).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())

        Assert.assertEquals(ResourceState.ERROR, viewmodel.bannersLiveData.value?.status)
    }

    @Test
    fun getBannersReturnsMessageForError() {
        val message = DataFactory.randomString()
        viewmodel.getBanners()

        verify(getBanners).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(message))

        Assert.assertEquals(message, viewmodel.bannersLiveData.value?.message)
    }

    @Test
    fun getCategoriasExecutesUseCase() {
        viewmodel.getCategorias()
        verify(getCategorias, times(1)).execute(any(), eq(null))
    }

    @Test
    fun getCategoriesReturnsSuccess() {
        val categories = CategoryFactory.makeCategoriaList(3)
        viewmodel.getCategorias()

        verify(getCategorias).execute(captorCategory.capture(), eq(null))
        captorCategory.firstValue.onSuccess(categories)

        Assert.assertEquals(ResourceState.SUCCESS, viewmodel.categoriaLiveData.value?.status)
    }

    @Test
    fun getCategoriesReturnsData() {
        val categories = CategoryFactory.makeCategoriaList(3)

        viewmodel.getCategorias()

        verify(getCategorias).execute(captorCategory.capture(), eq(null))
        captorCategory.firstValue.onSuccess(categories)

        Assert.assertEquals(categories, viewmodel.categoriaLiveData.value?.data)
    }


    @Test
    fun getCategoriesReturnsError() {
        viewmodel.getCategorias()

        verify(getCategorias).execute(captorCategory.capture(), eq(null))
        captorCategory.firstValue.onError(RuntimeException())

        Assert.assertEquals(ResourceState.ERROR, viewmodel.categoriaLiveData.value?.status)
    }

    @Test
    fun getCategoriesReturnsMessageForError() {
        val message = DataFactory.randomString()
        viewmodel.getCategorias()

        verify(getCategorias).execute(captorCategory.capture(), eq(null))
        captorCategory.firstValue.onError(RuntimeException(message))

        Assert.assertEquals(message, viewmodel.categoriaLiveData.value?.message)
    }

    @Test
    fun getBestSellersExecutesUseCase() {
        viewmodel.getBestSellers()
        verify(getBestSellers, times(1)).execute(any(), eq(null))
    }


    @Test
    fun getBestSellersReturnsSuccess() {
        val products = ProdutoFactory.makeProdutoList(3)
        viewmodel.getBestSellers()

        verify(getBestSellers).execute(captorProduct.capture(), eq(null))
        captorProduct.firstValue.onSuccess(products)

        Assert.assertEquals(ResourceState.SUCCESS, viewmodel.produtoLiveData.value?.status)
    }

    @Test
    fun getBestSellersReturnsData() {
        val products = ProdutoFactory.makeProdutoList(3)
        viewmodel.getBestSellers()

        verify(getBestSellers).execute(captorProduct.capture(), eq(null))
        captorProduct.firstValue.onSuccess(products)

        Assert.assertEquals(products, viewmodel.produtoLiveData.value?.data)
    }


    @Test
    fun getBestSellersReturnsError() {
        viewmodel.getBestSellers()

        verify(getBestSellers).execute(captorProduct.capture(), eq(null))
        captorProduct.firstValue.onError(RuntimeException())

        Assert.assertEquals(ResourceState.ERROR, viewmodel.produtoLiveData.value?.status)
    }

    @Test
    fun getBestSellersReturnsMessageForError() {
        val message = DataFactory.randomString()
        viewmodel.getBestSellers()

        verify(getBestSellers).execute(captorProduct.capture(), eq(null))
        captorProduct.firstValue.onError(RuntimeException(message))

        Assert.assertEquals(message, viewmodel.produtoLiveData.value?.message)
    }


}
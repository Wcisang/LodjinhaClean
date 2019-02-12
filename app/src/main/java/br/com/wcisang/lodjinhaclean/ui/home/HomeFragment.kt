package br.com.wcisang.lodjinhaclean.ui.home


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.model.Produto

import br.com.wcisang.lodjinhaclean.R
import br.com.wcisang.lodjinhaclean.ui.BaseFragment
import br.com.wcisang.lodjinhaclean.ui.util.ResourceState

class HomeFragment : BaseFragment<HomeViewModel>() {


    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerObservers()
        initCalls()
    }

    private fun initCalls() {
        viewModel.getBanners()
        viewModel.getCategorias()
        viewModel.getBestSellers()
    }

    private fun registerObservers() {
        registerCategoriaObserver()
        registerBannerObserver()
        registerBestSellersObserver()
    }

    private fun registerCategoriaObserver() {
        viewModel.categoriaLiveData.observe(this, Observer {
            when(it.status) {
                ResourceState.LOADING -> showCategoriaLoading()
                ResourceState.SUCCESS -> successCategoria(it.data)
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })
    }

    private fun showCategoriaLoading() {
        Log.i("WILL_TESTE", "Loading Categorias")
    }

    private fun successCategoria(data: List<Categoria>?) {
        Log.i("WILL_TESTE", data.toString())
    }

    private fun registerBannerObserver() {
        viewModel.bannersLiveData.observe(this, Observer {
            when(it.status) {
                ResourceState.LOADING -> showBannerLoading()
                ResourceState.SUCCESS -> successBanners(it.data)
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })
    }

    private fun showBannerLoading() {
        Log.i("WILL_TESTE", "Loading Banners")
    }

    private fun successBanners(data: List<Banner>?) {
        Log.i("WILL_TESTE", data.toString())
    }

    private fun registerBestSellersObserver() {
        viewModel.produtoLiveData.observe(this, Observer {
            when(it.status) {
                ResourceState.LOADING -> showProductLoading()
                ResourceState.SUCCESS -> successProducts(it.data)
                ResourceState.ERROR -> showGenericError(it.message)
            }
        })
    }

    private fun showProductLoading() {
        Log.i("WILL_TESTE", "Loading Produtos")
    }

    private fun successProducts(data: List<Produto>?) {
        Log.i("WILL_TESTE", data.toString())
    }


    private fun showGenericError(message: String?) {
        Log.i("WILL_TESTE", "Erro: $message")
    }




}

package br.com.wcisang.data.remote.service

import br.com.wcisang.data.remote.response.*
import br.com.wcisang.domain.model.Produto
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LodjinhaService {

    @GET("/banner")
    fun getBanners(): Single<BannerResponse>

    @GET("/categoria")
    fun getCategorias(): Single<CategoriasResponse>

    @GET("/produto/maisvendidos")
    fun getBestSellingProducts(): Single<ProdutoBestSellersResponse>

    @GET("/produto")
    fun getProducts(
        @Query("categoriaId") categoryId: Int
    ): Single<ProductsResponse>

    @GET("/produto/{produtoId}")
    fun getProductDetail(@Path("produtoId") productId: Int): Single<Produto>

    @POST("/produto/{produtoId}")
    fun reserveProduct(@Path("produtoId") productId: Int): Completable
}
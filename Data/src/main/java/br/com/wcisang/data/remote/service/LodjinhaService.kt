package br.com.wcisang.data.remote.service

import br.com.wcisang.data.remote.response.BannerResponse
import br.com.wcisang.data.remote.response.CategoriasResponse
import br.com.wcisang.data.remote.response.ProductsResponse
import br.com.wcisang.data.remote.response.ProdutoBestSellersResponse
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
//
//    @GET("/produto/{produtoId}")
//    fun getProduct(@Path("produtoId") productId: Long): Single<Product>
//
//    @POST("/produto/{produtoId}")
//    fun reserve(@Path("produtoId") productId: Long): Completable<ProductReservationResponse>
}
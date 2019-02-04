package br.com.wcisang.data.remote.service

import br.com.wcisang.data.remote.response.BannerResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LodjinhaService {

    @GET("/banner")
    fun getBanners(): Single<BannerResponse>

//    @GET("/categoria")
//    fun getCategories(): Single<CategoriesResponse>
//
//    @GET("/produto/maisvendidos")
//    fun getBestSellingProducts(): Single<BestSellingProductsResponse>
//
//    @GET("/produto")
//    fun getProducts(
//        @Query("offset") offset: Int,
//        @Query("limit") limit: Int,
//        @Query("categoriaId") categoryId: Long
//    ): Single<ProductsResponse>
//
//    @GET("/produto/{produtoId}")
//    fun getProduct(@Path("produtoId") productId: Long): Single<Product>
//
//    @POST("/produto/{produtoId}")
//    fun reserve(@Path("produtoId") productId: Long): Completable<ProductReservationResponse>
}
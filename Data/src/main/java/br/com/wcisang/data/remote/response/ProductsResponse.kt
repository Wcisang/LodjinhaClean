package br.com.wcisang.data.remote.response

import br.com.wcisang.domain.model.Produto
import com.google.gson.annotations.SerializedName

data class ProductsResponse (@SerializedName("data") val data: List<Produto>)
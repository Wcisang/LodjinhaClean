package br.com.wcisang.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Categoria(
    @SerializedName("id") var id: Int,
    @SerializedName("descricao") var descricao: String,
    @SerializedName("urlImagem") var urlImagem: String
): Serializable
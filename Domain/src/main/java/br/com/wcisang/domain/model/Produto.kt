package br.com.wcisang.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Produto (
    @SerializedName("id") var id: Int,
    @SerializedName("categoria") var categoria: Categoria,
    @SerializedName("descricao") var descricao: String,
    @SerializedName("nome") var nome: String,
    @SerializedName("precoDe") var precoDe: Float,
    @SerializedName("precoPor") var precoPor: Float,
    @SerializedName("urlImagem") var urlImagem: String
) : Serializable
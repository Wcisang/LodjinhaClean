package br.com.wcisang.data.remote.response

import br.com.wcisang.domain.model.Banner
import com.google.gson.annotations.SerializedName

data class BannerResponse (
    @SerializedName("data") var data : List<Banner>
)
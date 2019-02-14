package br.com.wcisang.domain.factory.banner

import br.com.wcisang.domain.factory.DataFactory
import br.com.wcisang.domain.model.Banner

object BannerFactory {

    fun makeBanner() : Banner {
        return Banner(DataFactory.randomInt(), DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeBannerList(count: Int) : List<Banner>{
        val projects = mutableListOf<Banner>()
        repeat(count) {
            projects.add(makeBanner())
        }
        return projects
    }
}
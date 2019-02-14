package br.com.wcisang.domain.factory.categoria

import br.com.wcisang.domain.factory.DataFactory
import br.com.wcisang.domain.model.Categoria

object CategoryFactory {

    fun makeCategoria() : Categoria {
        return Categoria(DataFactory.randomInt(), DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeCategoriaList(count: Int) : List<Categoria>{
        val projects = mutableListOf<Categoria>()
        repeat(count) {
            projects.add(makeCategoria())
        }
        return projects
    }
}
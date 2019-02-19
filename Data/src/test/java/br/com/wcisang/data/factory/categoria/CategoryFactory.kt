package br.com.wcisang.data.factory.categoria

import br.com.wcisang.data.factory.DataFactory
import br.com.wcisang.data.remote.response.CategoriasResponse
import br.com.wcisang.domain.model.Categoria

object CategoryFactory {

    fun makeCategoriaResponse(count: Int) : CategoriasResponse{
        return CategoriasResponse(makeCategoriaList(count))
    }

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
package br.com.wcisang.domain.factory.produto

import br.com.wcisang.domain.factory.DataFactory
import br.com.wcisang.domain.factory.categoria.CategoryFactory
import br.com.wcisang.domain.model.Produto

object ProdutoFactory {

    fun makeProduto() : Produto {
        return Produto(DataFactory.randomInt(), CategoryFactory.makeCategoria(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomFloat(), DataFactory.randomFloat(),DataFactory.randomString())
    }

    fun makeProdutoList(count: Int) : List<Produto>{
        val projects = mutableListOf<Produto>()
        repeat(count) {
            projects.add(makeProduto())
        }
        return projects
    }
}
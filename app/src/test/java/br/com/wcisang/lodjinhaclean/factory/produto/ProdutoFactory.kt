package br.com.wcisang.lodjinhaclean.factory.produto

import br.com.wcisang.lodjinhaclean.factory.DataFactory
import br.com.wcisang.lodjinhaclean.factory.categoria.CategoryFactory
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
package br.com.brn.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.brn.orgs.R
import br.com.brn.orgs.model.Produto
import br.com.brn.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(
                nome = "Teste",
                descricao = "teste desc",
                valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "Teste 1",
                descricao = "teste desc 1",
                valor = BigDecimal("19.09")
            ),
            Produto(
                nome = "Teste 2",
                descricao = "teste desc 2",
                valor = BigDecimal("10.09")
            )
        ))
    }
}
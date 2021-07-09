package br.com.brn.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brn.orgs.R
import br.com.brn.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {
            preencheNome(produto)
            preencheDescricao(produto)
            preencheValor(produto)
        }

        private fun preencheValor(produto: Produto) {
            val campoValor = itemView.findViewById<TextView>(R.id.valor)
            campoValor.text = produto.valor.toPlainString()
        }

        private fun preencheDescricao(produto: Produto) {
            val campoDescricao = itemView.findViewById<TextView>(R.id.descricao)
            campoDescricao.text = produto.descricao
        }

        private fun preencheNome(produto: Produto) {
            val campoNome = itemView.findViewById<TextView>(R.id.nome)
            campoNome.text = produto.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
}

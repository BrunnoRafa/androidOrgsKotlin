package br.com.brn.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brn.orgs.R
import br.com.brn.orgs.databinding.ProdutoItemBinding
import br.com.brn.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            preencheNome(produto)
            preencheDescricao(produto)
            preencheValor(produto)
        }

        private fun preencheValor(produto: Produto) {
            val valor = binding.produtoItemValor
            valor.text = produto.valor.toPlainString()
        }

        private fun preencheDescricao(produto: Produto) {
            val descricao = binding.produtoItemDescricao
            descricao.text = produto.descricao
        }

        private fun preencheNome(produto: Produto) {
            val nome = binding.produtoItemNome
            nome.text = produto.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}

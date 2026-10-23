class Item(val nome: String, val preco: Double, val quantidade: Int)

fun main() {
    val itens = listOf(
        Item("Caneta", 2.0, 10),
        Item("Caderno", 15.0, 2)
    )

    println(calculaTotalPedido(itens))
    println(calculaTotalPedido(itens, cupomPercentual = 10.0, frete = 8.0))
    println(calculaTotalPedido(emptyList()))
    println(calculaTotalPedido(itens, cupomPercentual = 150.0))
    println(calculaTotalPedido(itens, frete = -5.0))
    println(calculaTotalPedido(itens, cupomPercentual = 0.0))
    println(calculaTotalPedido(itens, cupomPercentual = 100.0, frete = 8.0))
    println(calculaTotalPedido(listOf(Item("Livro", 40.0, 0))))
}

fun calculaTotalPedido(itens: List<Item>, cupomPercentual: Double? = null, frete: Double = 0.0): Double? {
    var valorProdutos = 0.0

    // Verifica se a lista de itens esta vazia e se o frete é menor que 0
    if (itens.isEmpty() || frete < 0.0) {
        return null
    }
    // Faz o calculo do valor dos itens
    for (item in itens) {
        if (item.quantidade <= 0 || item.preco < 0) {
            return null
        }
        valorProdutos += item.preco * item.quantidade
    }

    // Verifica se o cupom não é nulo, mas está fora do intervalo de 0 a 100
    if (cupomPercentual != null && cupomPercentual !in 0.0..100.0) {
        return null
    }

    // Calcula o valor do desconto (se tiver)
    val valorDesconto = if (cupomPercentual != null) (cupomPercentual * valorProdutos) / 100 else 0.0

    val valorTotal = valorProdutos - valorDesconto + frete

    return valorTotal

}
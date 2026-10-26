

fun main() {

    val listaTrocos = listOf(
    calculaTroco(4550, 5000)	,//2x R$ 2,00, 1x R$ 0,50
    calculaTroco(1000, 1000),	//Sem troco
    calculaTroco(1000, 900),	//Valor insuficiente

    calculaTroco(99, 10000),	//1x R$ 50,00, 2x R$ 20,00, 1x R$ 5,00, 2x R$ 2,00, 1x R$ 0,01
    calculaTroco(250, 1000),	//1x R$ 5,00, 1x R$ 2,00, 1x R$ 0,50
    calculaTroco(-5, 100),
    )

    for (r in listaTrocos) {
        println(r)
    }

}

fun calculaTroco(contaCentavos: Int, pagoCentavos: Int): String {

    val valores = listOf(10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1)
    val partes = mutableListOf<String>()
    if(contaCentavos < 0 || pagoCentavos < 0) return "Dados inválidos"
    if(contaCentavos !in 0..pagoCentavos) return "Valor insuficiente"
    if(contaCentavos == pagoCentavos) return "Sem troco"

    var trocoRestante = (pagoCentavos - contaCentavos)
    var quantas = 0
    for (valor in valores) {
        quantas = trocoRestante / valor
        trocoRestante %= valor

        if (quantas > 0){
            partes.add(formataCentavos(quantas, valor))
        }

    }
    return partes.joinToString (", ")

}

fun formataCentavos(quantas: Int, valor: Int) : String {
    return String.format("%dx R$ %d,%02d", quantas, valor / 100, valor % 100)
}
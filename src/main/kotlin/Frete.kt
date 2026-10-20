fun main() {
    println(calculaFrete(2.0, "SUL"))
    println(calculaFrete(1.0, "SUDESTE", urgente = true))
    println(calculaFrete(3.0, "LESTE"))
    println(calculaFrete(0.0, "SUL"))
    println(calculaFrete(2.5, "NORTE"))
    println(calculaFrete(4.0, "sul"))

}

fun calculaFrete(pesoKg: Double, regiao: String, urgente: Boolean = false): Double? {
    var fretePeso = 0.0
    var freteUrgente = 0.0

    if (pesoKg <= 0.0) {
        return null
    }

    val freteBase: Double = when (regiao) {
        "sul", "SUL" -> 12.0
        "sudeste", "SUDESTE" -> 15.0
        "norte", "NORTE" -> 30.0
        else -> return null
    }

    if (pesoKg > 1.0) {
        fretePeso = (pesoKg - 1.0) * 2.5
    }

    if (urgente) {
        freteUrgente = 10.0
    }

    val freteTotal = +fretePeso + freteBase + freteUrgente
    return freteTotal
}
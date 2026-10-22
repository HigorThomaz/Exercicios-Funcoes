fun main() {
    println(calculaFrete(2.0, "SUL"))
    println(calculaFrete(1.0, "SUDESTE", urgente = true))
    println(calculaFrete(3.0, "LESTE"))
    println(calculaFrete(0.0, "SUL"))
    println(calculaFrete(2.5, "NORTE"))
    println(calculaFrete(4.0, "sul"))
    println(calculaFrete(2.0, "Sul"))
    println(calculaFrete(2.0, "sUl"))

}

fun calculaFrete(pesoKg: Double, regiao: String, urgente: Boolean = false): Double? {

    if (pesoKg <= 0.0) {
        return null
    }

    val freteBase: Double = when (regiao.uppercase()) {
        "SUL" -> 12.0
        "SUDESTE" -> 15.0
        "NORTE" -> 30.0
        else -> return null
    }

    val fretePeso = if (pesoKg > 1.0) {
        (pesoKg - 1.0) * 2.5
    } else {
        0.0
    }

    val freteUrgente = if (urgente) {
        10.0
    } else {
        0.0
    }

    return fretePeso + freteBase + freteUrgente
}
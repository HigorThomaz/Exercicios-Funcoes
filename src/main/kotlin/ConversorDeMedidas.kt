fun main() {
    println(converteMedida("1,5", "km", "m"))
    println(converteMedida(null, "m", "cm"))
    println(converteMedida("10", "kg", "m"))

    print("\n")
    println(converteMedida("1", "m", "m"))
    println(converteMedida("1", "m", "km"))
    println(converteMedida("0", "m", "km"))
    println(converteMedida("1", "m", "xx"))

    print("\n")
    println(converteMedida("250", "cm", "m"))
    println(converteMedida("0", "m", "km"))
    println(converteMedida("abc", "m", "cm"))
    println(converteMedida("-1", "m", "cm"))
    println(converteMedida("3", "m", "m"))

    print("\n")
    println(converteMedida("10", "mm", "cm"))
    println(converteMedida("1", "cm", "mm"))
    println(converteMedida("1500", "mm", "m"))

    println(converteMedida("3", "mm", "cm"))
}

fun converteMedida(valor: String?, de: String, para: String): Double? {

    val medidaDe = cmPorUnidade(de)
    val medidaPara = cmPorUnidade(para)

    val valorDouble = valor?.replace(",", ".")?.toDoubleOrNull()
    if (valorDouble == null || valorDouble < 0) {
        return null
    }

    if (medidaDe == null || medidaPara == null){
        return null
    }

    return valorDouble * medidaDe / medidaPara
}

fun cmPorUnidade(unidade: String) : Double?{

    return when (unidade.lowercase()) {
        "mm" -> 1.0
        "cm" -> 10.0
        "m" -> 1000.0
        "km" -> 1000000.0
        else -> null
    }

}
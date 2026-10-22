fun main() {

    println(formataEvento("Reunião", 9))
    println(formataEvento("Dentista", 14, 30, 45))
    println(formataEvento("Plantão", 23, 30))
    println(formataEvento("Aula", 25))
    println(formataEvento("Aula", 10, duracaoMin = 90))
    println(formataEvento("Aula", 60))
    println(formataEvento("Crochê", 10,60))
    println(formataEvento("Aula", 10, duracaoMin = 0))
}

fun formataEvento(titulo: String, hora: Int, minuto: Int = 0, duracaoMin: Int = 60): String {
    if (hora !in 0..23 || minuto !in 0..59 || duracaoMin <= 0) {
        return "Horário inválido"
    }

    val minutosInicio = hora * 60 + minuto
    val minutosFinal = minutosInicio + duracaoMin
    val minutosDoDiaFinal = minutosFinal % 1440
    val horasCalc = minutosDoDiaFinal / 60
    val minutosCalc = minutosDoDiaFinal % 60

    return "$titulo: ${doisDigitos(hora)}:${doisDigitos(minuto)}-${doisDigitos(horasCalc)}:${doisDigitos(minutosCalc)}"
}


fun doisDigitos(n: Int): String = String.format("%02d", n)
//6. Validador de senha
//
//Escreva validaSenha(senha: String?, tamanhoMinimo: Int = 8, exigeEspecial: Boolean = true): List<String>. Ela devolve a lista de problemas encontrados. Lista vazia significa senha válida.
//
//Regras:
//
//Senha nula ou só com espaços: devolve só Senha obrigatória.
//Senão, devolve os problemas que se aplicam, nesta ordem:
//Mínimo de N caracteres, onde N é o tamanhoMinimo
//Precisa de letra maiúscula
//Precisa de número
//Precisa de caractere especial (só se exigeEspecial for verdadeiro). Especial é qualquer caractere que não seja letra nem número.


fun main() {

    val listaSenhas = listOf(
        validaSenha("Abcdef12!"),
        validaSenha("abc"),
        validaSenha("Abcdef12", exigeEspecial = false),
        validaSenha(null),
        validaSenha("   "),
        validaSenha("Ab1!", tamanhoMinimo = 4),
        validaSenha("abcdefgh1")

    )

    for(senha in listaSenhas){
        println(senha)
    }
}

fun validaSenha(senha: String?, tamanhoMinimo: Int = 8, exigeEspecial: Boolean = true): List<String> {
    val listaErros = mutableListOf<String>()

    if (senha.isNullOrBlank()) {
        listaErros.add(String.format("Senha obrigatória"))
    } else {
        if (senha.length < tamanhoMinimo) {
            listaErros.add("Mínimo de $tamanhoMinimo caracteres")
        }
        if (!senha.any { it.isUpperCase() }) {
            listaErros.add("Precisa de letra maiúscula")
        }

        if (!senha.any { it.isDigit() }) {
            listaErros.add("Precisa de número")
        }

        if (exigeEspecial) {
            if (!senha.any { !it.isLetterOrDigit() }) {
                listaErros.add("Precisa de caractere especial")
            }
        }
    }

    return listaErros
}
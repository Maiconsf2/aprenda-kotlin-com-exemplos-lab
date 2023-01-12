enum class Nivel { INICIANTE, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    // Criando os usuários
    val Alucard = Usuario("Alucard", "alucard@teste.com")
    val Dante = Usuario("Dante", "dante@teste.com")
    val Nero = Usuario("Nero", "nero@teste.com")
    val Vergil = Usuario("Vergil", "vergil@teste.com")

    // Criando a lista de conteúdos da formação
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial",120),
        ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin",120),
        ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin",60),
        ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin",120),
        ConteudoEducacional("O Poder das Funções em Kotlin",60),)

    // Criando a formação para Kotlin
    val kotlinExperience = Formacao("Kotlin Experience", listaConteudosKotlin, Nivel.INTERMEDIARIO)

    // Verificando se a variável de formação não é nula, caso não seja, matriculando alunos
    kotlinExperience?.let{
        kotlinExperience.matricular(Alucard, Dante, Nero, Vergil)
    }

    // Imprimindo na tela
    println("Formação: ${kotlinExperience.nome}\n\t\tConteúdos:")
    kotlinExperience.mostrarConteudos()
    println("\t\tInscritos:")
    kotlinExperience.mostrarInscritos()

}
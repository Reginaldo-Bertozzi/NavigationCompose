package com.example.navigationcompose

// Classe selada (sealed class) que representa as diferentes telas da aplicação.
sealed class Screen(val route: String) {
    // Objeto que representa a tela principal da aplicação com a rota "main_screen".
    object MainScreen : Screen("main_screen")

    // Objeto que representa a tela de detalhes da aplicação com a rota "detail_screen".
    object DetailScreen : Screen("detail_screen")

    // Função que permite adicionar argumentos à rota da tela.
    fun withArgs(vararg args: String): String {
        // Cria uma string de construção para compor a rota com os argumentos.
        return buildString {
            // Adiciona a parte inicial da rota.
            append(route)

            // Itera sobre os argumentos fornecidos, adicionando-os à rota.
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

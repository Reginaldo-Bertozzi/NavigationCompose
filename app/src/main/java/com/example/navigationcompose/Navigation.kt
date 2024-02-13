package com.example.navigationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Esta função @Composable define a estrutura de navegação da aplicação.
@Composable
fun Navigation() {
    // Cria um controlador de navegação para gerenciar as transições entre telas.
    val navController = rememberNavController()

    // Define o ponto de início e as rotas para as diferentes telas da aplicação.
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        // Configura a tela principal da aplicação.
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        // Configura a tela de detalhes, permitindo um argumento opcional para o nome.
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Philipp"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}

// Define a composição da tela principal da aplicação.
@Composable
fun MainScreen(navController: NavController) {
    // Declara e inicializa uma variável de estado para armazenar o texto da TextField.
    var text by remember {
        mutableStateOf("")
    }

    // Define a estrutura da tela principal usando um Column.
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {
        // Declara e configura uma TextField para entrada de texto.
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Verifica se o texto está vazio e atribui um valor padrão se necessário.
        if (text == "") {
            text = "Reginaldo"
        }

        // Adiciona um espaçamento vertical.
        Spacer(modifier = Modifier.height(8.dp))

        // Adiciona um botão que, ao ser clicado, navega para a tela de detalhes com o texto fornecido.
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.withArgs(text))
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Vai para a tela de Detalhes")
        }
    }
}

// Define a composição da tela de detalhes, exibindo uma caixa com o nome fornecido.
@Composable
fun DetailScreen(name: String?) {
    // Configura uma caixa (Box) que centraliza o texto de saudação com o nome.
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello, $name!")
    }
}

package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationcompose.ui.theme.NavigationComposeTheme
/*
What you need to know about having different screens
in jetpack compose and navigating between them.
https://www.youtube.com/watch?v=4gUeyNkGE3g&t=577s
 */
// Classe que representa a atividade principal da aplicação, estendendo ComponentActivity.
class MainActivity : ComponentActivity() {
    // Sobrescreve o método onCreate para inicializar a atividade quando ela é criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Chama a implementação do método onCreate na classe pai.
        super.onCreate(savedInstanceState)

        // Define o conteúdo da atividade usando o Compose, chamando a função Navigation().
        setContent {
            Navigation()
        }
    }
}


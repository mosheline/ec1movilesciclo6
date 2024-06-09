package pe.edu.idat.ec1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.idat.ec1.ui.theme.Ec1Theme
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import pe.edu.idat.ec1.ui.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ec1Theme {
                    MiMenu()
            }
        }
    }
}
@Composable
fun MiMenu() {
    var elegirPregunta by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Button(onClick = { elegirPregunta = 1 })
        {
            Text("Pregunta 1")
        }
        Button(onClick = { elegirPregunta = 2 })
        {
            Text("Pregunta 2")
        }
        Button(onClick = { elegirPregunta = 3 })
        {
            Text("Pregunta 3")
        }
        Button(onClick = { elegirPregunta = 4 })
        {
            Text("Pregunta 4")
        }
        when (elegirPregunta) {
            1 -> Pregunta1()
            2 -> Pregunta2()
            3 -> Pregunta3()
            4 -> Pregunta4()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ec1Theme {
        MiMenu()
    }
}


package pe.edu.idat.ec1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec1.ui.theme.Ec1Theme

@Composable
fun Pregunta3() {
    var numero by remember { mutableStateOf("") }
    var vocal by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text("Ingrese un número entero") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val num = numero.toIntOrNull() ?: 0
            vocal = obtenerVocal(num)
        }) {
            Text("Mostrar Vocal")
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (numero.isNotEmpty()) {
            Text(text = vocal)
        }
    }
}

fun obtenerVocal(numero: Int): String {
    return when (numero) {
        1 -> "El número $numero corresponde a la vocal A"
        2 -> "El número $numero corresponde a la vocal E"
        3 -> "El número $numero corresponde a la vocal I"
        4 -> "El número $numero corresponde a la vocal O"
        5 -> "El número $numero corresponde a la vocal U"
        else -> "Número fuera del rango, ingresar del 1 al 5"
    }
}

@Preview(showBackground = true)
@Composable
fun Pregunta3Preview() {
    Ec1Theme {
        Pregunta3()
    }
}
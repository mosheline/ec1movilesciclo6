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
fun Pregunta4() {
    var limite by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {
        OutlinedTextField(value = limite, onValueChange = { limite = it },label = { Text("Ingrese un número entero") },modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val lim = limite.toIntOrNull() ?: 0
            resultado = calcularCuboCuarta(lim)})
        {
            Text("Calcular Cubo y Cuarta")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth())
        {
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.Start)
            {
                Text(text = resultado, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

fun calcularCuboCuarta(lim: Int): String {
    var resultado = ""
    for (num in 1..lim) {
        resultado += "Número: $num, Cubo: ${num * num * num}, Cuarta: ${num * num * num * num}\n"
    }
    return resultado
}

@Preview(showBackground = true)
@Composable
fun Pregunta4Preview() {
    Ec1Theme {
        Pregunta4()
    }
}
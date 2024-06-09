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
fun Pregunta1() {
    var cantidad by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var resultados by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally)
    {
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio por unidad") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val c = cantidad.toDoubleOrNull() ?: 0.0
            val p = precio.toDoubleOrNull() ?: 0.0
            resultados = calcularTotal(c, p)
        }) {
            Text("Calcular Total")
        }
        Spacer(modifier = Modifier.height(8.dp))
        for (resultado in resultados) {
            Text(text = resultado)
        }
    }
}

fun calcularTotal(cantidad: Double, precio: Double): List<String> {
    val montoACobrar = cantidad * precio
    val descuento = if (montoACobrar > 200) montoACobrar * 0.2 else 0.0
    val totalACobrar = montoACobrar - descuento
    return listOf(
        "Monto a Cobrar: $montoACobrar",
        "Descuento 20%: $descuento",
        "Total a Cobrar: $totalACobrar"
    )
}


@Preview(showBackground = true)
@Composable
fun Pregunta1Preview() {
    Ec1Theme {
        Pregunta1()
    }
}
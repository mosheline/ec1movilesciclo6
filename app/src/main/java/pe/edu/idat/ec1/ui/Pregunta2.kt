package pe.edu.idat.ec1.ui
import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec1.ui.theme.Ec1Theme

@Composable
fun Pregunta2() {
    var montoPrestamo by remember { mutableStateOf("") }
    var resultados by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {
        OutlinedTextField(
            value = montoPrestamo,
            onValueChange = { montoPrestamo = it },
            label = { Text("Monto del préstamo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val cantidad = montoPrestamo.toDoubleOrNull() ?: 0.0
            resultados = calcularPrestamo(cantidad)})
        {
            Text("Calcular Cuotas")
        }
        Spacer(modifier = Modifier.height(8.dp))

        if (resultados.isNotEmpty()) {
            Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Column(modifier = Modifier.weight(1f),horizontalAlignment = Alignment.Start)
                    {
                        Text(text = "Valor Solicitado:")
                        Text(text = "Cuotas Asignadas:")
                        Text(text = "Interés en %:")
                        Text(text = "Pago por Cuota:")
                        Text(text = "Total a Pagar:")
                    }
                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End)
                    {
                        for (resultado in resultados) {
                            Text(text = resultado)
                        }
                    }
                }
            }
        }
    }
}

fun calcularPrestamo(cantidad: Double): List<String> {
    val interes = if (cantidad < 4000) 0.12 else 0.10
    val total = cantidad * (1 + interes)
    val (numCuotas, valorCuota) = when {
        cantidad < 1000 -> 1 to total
        cantidad in 2000.0..3000.0 -> 2 to total / 2
        cantidad > 5000 -> 3 to total / 3
        else -> 5 to total / 5
    }
    val decimalFormat = DecimalFormat("#,###.00")
    val integerFormat = DecimalFormat("#,###")

    return listOf(
        decimalFormat.format(cantidad),
        numCuotas.toString(),
        integerFormat.format(interes * 100),
        decimalFormat.format(valorCuota),
        decimalFormat.format(total)
    )
}

@Preview(showBackground = true)
@Composable
fun Pregunta2Preview() {
    Ec1Theme {
        Pregunta2()
    }
}
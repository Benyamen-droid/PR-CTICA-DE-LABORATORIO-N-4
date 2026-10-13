// Actividad 2: State Hoisting (pares e impares)
// Código tal como aparece en el informe (se añaden solo los imports para que compile).

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyStateHoisting() {
    var cont1 by rememberSaveable { mutableStateOf(0) }
    var cont2 by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyStateHoisting1(cont1, onClick = { cont1 += if (cont1 % 2 == 0) 1 else 2 })
        MyStateHoisting2(cont2, onClick = { cont2 += 2 })
    }
}

@Composable
fun MyStateHoisting1(cont: Int, onClick: () -> Unit) {
    Button(onClick = onClick) { Text(text = "Pulsar1") }
    Text(text = "He sido pulsado $cont veces")
}

@Composable
fun MyStateHoisting2(cont: Int, onClick: () -> Unit) {
    Button(onClick = onClick) { Text(text = "Pulsar2") }
    Text(text = "He sido pulsado $cont veces")
}

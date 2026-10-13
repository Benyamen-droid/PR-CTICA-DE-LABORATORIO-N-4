// Actividad 1: botón Agregar
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
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StateExample() {
    var clics by rememberSaveable { mutableStateOf(0) }

    MyTareas(
        clics = clics,
        onAgregar = { clics++ }
    )
}

@Composable
fun MyTareas(clics: Int, onAgregar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onAgregar) {
            Text(if (clics == 0) "Agregar" else "Tarea $clics")
        }
        for (i in clics + 1..clics + 3) {
            Text("Tarea $i")
        }
    }
}

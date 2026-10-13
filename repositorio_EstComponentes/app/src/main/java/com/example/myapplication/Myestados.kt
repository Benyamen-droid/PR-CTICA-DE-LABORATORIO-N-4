package ruelas.donia.primeraapp.components

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

// ================= PRACTICA DE LABORATORIO N° 4 =================
// Inicia con el boton "Agregar" y debajo Tarea 1, Tarea 2 y Tarea 3.
// En cada clic el texto del boton se reemplaza por la tarea que subio:
//   clic 1: boton "Tarea 1" | lista: Tarea 2, Tarea 3, Tarea 4
//   clic 2: boton "Tarea 2" | lista: Tarea 3, Tarea 4, Tarea 5
//   ... y asi sucesivamente.

// Padre: guarda el estado (State Hoisting)
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StateExample() {
    // Cantidad de clics. rememberSaveable conserva el valor al girar la pantalla
    var clics by rememberSaveable { mutableStateOf(0) }

    MyTareas(
        clics = clics,
        onAgregar = { clics++ }
    )
}

// Hijo: solo muestra el estado y avisa cuando se pulsa el boton
@Composable
fun MyTareas(clics: Int, onAgregar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onAgregar) {
            // Sin clics dice "Agregar"; luego muestra la tarea que subio
            Text(if (clics == 0) "Agregar" else "Tarea $clics")
        }
        // Siempre se muestran 3 tareas: las que siguen despues del boton
        for (i in clics + 1..clics + 3) {
            Text("Tarea $i")
        }
    }
}

// ================= ACTIVIDAD: STATE HOISTING =================
// El primer boton incrementa en impares (1, 3, 5, ...) y el segundo en pares
// (2, 4, 6, ...). Solo se modifica el padre; los hijos no cambian.

// Padre: guarda los dos estados y define como se incrementa cada uno
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MyStateHoisting() {
    var cont1 by rememberSaveable { mutableStateOf(0) }
    var cont2 by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Impares: si el valor es par suma 1, si es impar suma 2 -> 1, 3, 5, ...
        MyStateHoisting1(cont1, onClick = { cont1 += if (cont1 % 2 == 0) 1 else 2 })
        // Pares: siempre suma 2 -> 2, 4, 6, ...
        MyStateHoisting2(cont2, onClick = { cont2 += 2 })
    }
}

// Hijos (sin estado propio): reciben el valor y la accion por parametros
@Composable
fun MyStateHoisting1(cont: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Pulsar1")
    }
    Text(text = "He sido pulsado $cont veces")
}

@Composable
fun MyStateHoisting2(cont: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Pulsar2")
    }
    Text(text = "He sido pulsado $cont veces")
}
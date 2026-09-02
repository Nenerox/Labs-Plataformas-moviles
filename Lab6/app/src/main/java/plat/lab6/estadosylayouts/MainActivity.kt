package plat.lab6.estadosylayouts

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab6.estadosylayouts.ui.theme.Lab6Theme
import kotlin.inc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                Contador()
            }
        }
    }
}

@Composable
fun Top(modifier: Modifier = Modifier,
           contador: Int,
           onMas: () -> Unit,
           onMenos: () -> Unit,
){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Andres Pineda",
            fontSize = 50.sp,
            textAlign = TextAlign.Center)

        Row(modifier = modifier
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically) {
            FilledTonalIconButton(
                onClick = {onMenos()},
                shape = CircleShape,
                modifier = modifier
                    .size(50.dp)){
                Icon(painter = painterResource(R.drawable.menos),
                    contentDescription = null,
                    modifier = modifier.size(45.dp))
            }

            Text(contador.toString(),
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold)

            FilledTonalIconButton(
                onClick = {onMas()},
                shape = CircleShape,
                modifier = modifier
                    .size(50.dp)){
                Icon(painter = painterResource(R.drawable.mas),
                    contentDescription = null,
                    modifier = modifier.size(45.dp))
            }
        }

    }
}

@Composable
fun Estadisticas(
    modifier: Modifier = Modifier,
    incrementos: Int,
    decrementos: Int,
    max: Int,
    min: Int,
    cambios: Int
    ){
    Column(modifier = modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text("Total incrementos: ",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text(incrementos.toString(),
                fontSize = 25.sp)
        }
        Row(modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text("Total decrementos: ",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text(decrementos.toString(),
                fontSize = 25.sp)
        }
        Row(modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text("Valor maximo: ",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text(max.toString(),
                fontSize = 25.sp)
        }
        Row(modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text("Valor minimo: ",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text(min.toString(),
                fontSize = 25.sp)
        }
        Row(modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text("Total cambios",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text(cambios.toString(),
                fontSize = 25.sp)
        }
    }
}

@Composable
fun Historial(
    modifier: Modifier = Modifier,
    numero: Int,
    isSuma: Boolean
){
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .size(100.dp)
        .background(color = if (isSuma){Color.Green } else {Color.Red}),
        contentAlignment = Alignment.Center
    ) {
        Text(text = numero.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp)
    }
}

@Composable
fun Contador(modifier: Modifier = Modifier){
    var contador by remember { mutableStateOf(0) }
    var incrementos by remember { mutableStateOf(0) }
    var decrementos by remember { mutableStateOf(0) }
    var max by remember { mutableStateOf(0) }
    var min by remember { mutableStateOf(0) }
    var cambios by remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        Top(
            contador = contador,
            onMas = {
                contador++
                incrementos++
                cambios++
                if (max < contador) max = contador},
            onMenos = {
                contador--
                decrementos++
                cambios++
                if (min > contador) min = contador},
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 2.dp,
            color = Color.LightGray
        )

        Estadisticas(
            incrementos = incrementos,
            decrementos = decrementos,
            max = max,
            min = min,
            cambios = cambios
            )

        Text("Historial: ",
            modifier = modifier.padding(start = 15.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        //TODO: lista con los cuadros de historial Lazyverticalgrid

        FilledTonalButton(
            onClick = {
                contador = 0
                incrementos = 0
                decrementos = 0
                max = 0
                min = 0
                cambios = 0
            },
            modifier = modifier.fillMaxWidth()
                .padding(15.dp)
        ) { Text("Reiniciar")}
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPreview() {
    Lab6Theme {
            Contador()
    }
}

@Preview(showBackground = true)
@Composable
fun historial() {
    Lab6Theme {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Historial(numero = 1, isSuma = true)
            Historial(numero = 0, isSuma = false)
        }
    }
}
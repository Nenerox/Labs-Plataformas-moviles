package plat.lab4.andres_pineda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab4.andres_pineda.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                App()
                Fondo()
            }
        }
    }
}
@Composable
fun Fondo(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.delvalle),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(80.dp),
            alpha = 0.2f
        )
    }
}

@Composable
fun App(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .background(color = Color.Green)) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .fillMaxHeight()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(modifier = modifier) {
                Text(
                    text = "Universidad del Valle \n de Guatemala",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp,
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Box(modifier = modifier) {
                Text(
                    text = "Programación de plataformas \n móviles, Seccion 30",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    lineHeight = 36.sp,
                    )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "INTEGRANTES",
                    Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Alejandro Sagastume \n Andres Pineda \n Jimena Vasquez",
                    Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "CATEDRÁTICO",
                    Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Juan Carlos Durini",
                    Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Andres Pineda")
                Text(text = "25212")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio4Theme {
        App()
        Fondo()
    }
}
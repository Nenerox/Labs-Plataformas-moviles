package plat.lab5.andres_pineda

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab5.andres_pineda.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Programa(
                        modifier = Modifier.padding(innerPadding)
                            .background(MaterialTheme.colorScheme.background)
                    )
                }
            }
        }
    }
}

@Composable
fun Programa(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Top){
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(top= 30.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            ,verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.actualizacion),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                    .padding(10.dp)

            )
            Text("Actualizacion disponible",
                modifier = Modifier
                .weight(1f)
                    .padding(horizontal = 8.dp)
            )
            TextButton(
                colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp"))
                    context.startActivity(intent)
                }) {
                Text("Descargar",
                    color = MaterialTheme.colorScheme.tertiary)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
            ){
                Text("Lunes",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold)
                Text("3 de agosto",
                    fontSize = 18.sp)
            }
            OutlinedCard(modifier = Modifier
                .height(40.dp),
                ){
                    Text("Terminar Jornada",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            , fontSize = 18.sp
                            ,color = MaterialTheme.colorScheme.tertiary)
            }
        }
        ElevatedCard(modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .shadow(4.dp,RoundedCornerShape(4.dp)),
            shape = RoundedCornerShape(4.dp)
        ){
            Column(modifier = Modifier
                .padding(15.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Masil",
                        modifier = Modifier.weight(1f),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                        )
                    IconButton(modifier = Modifier,
                        onClick = {
                        val latitude = 14.551662859297982
                        val longitude = -90.73433390045733
                        val geoUri = "geo:$latitude,$longitude?q=$latitude,$longitude(${Uri.encode("Masil")})"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri)).apply {
                            setPackage("com.google.android.apps.maps")
                        }
                        context.startActivity(intent)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.diamond_turn),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
                Text("Antigua Guatemala")
                Text("12:00PM-10:00PM")
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    FilledTonalButton(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            Toast.makeText(
                                context,
                                ("Andres Pineda"),
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Text("Iniciar",
                            color = Color.White)
                    }
                    TextButton(
                        colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
                        modifier = Modifier.weight(1f),
                        onClick = {
                            Toast.makeText(
                                context,
                                ("Tipo de comida: Koreana " +
                                        "\n Costo: QQQ"),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    ) {
                        Text("Detalles",
                        color = MaterialTheme.colorScheme.tertiary)
                    }
                }
            }
            
        }
    }
}

@PreviewLightDark
@Composable
fun GreetingPreview() {
    Laboratorio5Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Programa(
                modifier = Modifier.padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background)
            )
        }
    }
}
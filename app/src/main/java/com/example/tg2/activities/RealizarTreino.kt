package com.example.tg2.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tg2.ViewModel.TreinoViewModel
import com.example.tg2.ui.theme.AppBlue
import com.example.tg2.ui.theme.GreenButton
import kotlinx.coroutines.delay

class RealizarTreino : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val treinoViewModel: TreinoViewModel = viewModel()
            Scaffold(
            ) { innerPadding ->
                RealizarTreinoContent(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    treinoViewModel = treinoViewModel
                )
            }
        }
    }
}

@Composable
fun RealizarTreinoContent(
    modifier: Modifier = Modifier,
    navController: androidx.navigation.NavController,
    treinoViewModel: TreinoViewModel
) {
    var isRunning by remember { mutableStateOf(false) }
    var elapsedTime by remember { mutableStateOf(0L) }
    var started by remember { mutableStateOf(false) }
    var finished by remember { mutableStateOf(false) }
    var totalPiscinas by remember { mutableStateOf(0) }

    val hours = (elapsedTime / 3600000).toInt()
    val minutes = ((elapsedTime % 3600000) / 60000).toInt()
    val seconds = ((elapsedTime % 60000) / 1000).toInt()
    val milliseconds = ((elapsedTime % 1000) / 10).toInt()

    val mainTime = String.format("%02d:%02d:%02d", hours, minutes, seconds)
    val milliText = String.format("%02d", milliseconds)

    val lapTimes = remember { mutableStateListOf<Long>() }


    LaunchedEffect(isRunning) {
        if (isRunning) {
            val startTime = System.currentTimeMillis() - elapsedTime
            while (isRunning) {
                elapsedTime = System.currentTimeMillis() - startTime
                delay(10)
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CATARINA NUNES",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .padding(start = 20.dp, end = 20.dp)
            ){
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = mainTime,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                    Text(
                        text = ".$milliText",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(start = 2.dp, bottom = 8.dp)
                    )
                }
            }
            Text(
                text = "Tempo Total",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 30.dp),
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total de Piscinas",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = totalPiscinas.toString(),
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Distância",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "${totalPiscinas * 50} metros",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ritmo/100m",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = if (totalPiscinas > 0 && elapsedTime > 0) {
                        val metros = totalPiscinas * 50
                        val pacePer100m = elapsedTime.toDouble() / metros * 100
                        val paceMinutes = (pacePer100m / 60000).toInt()
                        val paceSeconds = ((pacePer100m % 60000) / 1000).toInt()
                        String.format("%d'%02d''", paceMinutes, paceSeconds)
                    } else {
                        "0'00''"
                    },
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Média p/ Volta",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = if (totalPiscinas > 0) {
                        val avgPerLap = elapsedTime / totalPiscinas
                        val min = (avgPerLap / 60000).toInt()
                        val sec = ((avgPerLap % 60000) / 1000).toInt()
                        String.format("%d'%02d''", min, sec)
                    } else {
                        "0'00''"
                    },
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    if (!started) {
                        started = true
                        isRunning = true
                    } else if (started && !finished) {
                        isRunning = false
                        finished = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (started) Color.Red else GreenButton,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .height(100.dp)
                    .padding(16.dp),
                enabled = !finished
            ) {
                Text(
                    if (started) "Finalizar Treino" else "Iniciar Treino",
                    fontSize = 22.sp
                )
            }

            treinoViewModel.setLapTimes(lapTimes)

            if (finished) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Treino Finalizado!",
                        color = AppBlue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Button(
                        onClick = { navController.navigate("detalhestreino") },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = AppBlue,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(top = 16.dp)
                    ) {
                        Text("Mostrar Tempos Parciais")
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                if (isRunning) {
                    totalPiscinas++
                    lapTimes.add(elapsedTime)
                }
            },
            containerColor = AppBlue,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .size(100.dp)
        ) {
            Text(
                text = "Botão\n da \nPiscina",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
package com.example.tg2.activities.historicotreinos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tg2.ViewModel.TreinoViewModel



class DetalhesTreino : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val treinoViewModel: TreinoViewModel = viewModel()
            Scaffold(
            ) { innerPadding ->
                DetalhesTreinoContent(
                    modifier = Modifier.padding(innerPadding),
                    treinoViewModel = treinoViewModel
                )
            }
        }
    }
}

@Composable
fun DetalhesTreinoContent(
    modifier: Modifier = Modifier,
    treinoViewModel: TreinoViewModel
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detalhes do Treino",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(text = "Tempos Parciais",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Column {
                treinoViewModel.lapTimes.forEachIndexed { index, time ->

                    //a seguinte linha calcula o tempo da volta atual
                    val lapTime = if (index == 0) time else time - treinoViewModel.lapTimes[index - 1]

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                    ) {
                        Text(
                            text = "Volta ${index + 1}:",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 10.dp, horizontal = 16.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "${lapTime / 60000}'${((lapTime % 60000) / 1000).toString().padStart(2, '0')}''",
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 10.dp, horizontal = 16.dp)

                        )
                    }
                }
            }

        }
    }
}
package com.example.tg2.activities.historicotreinos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tg2.ui.theme.AppBlue

@Composable
fun VerTreinoContent(
    modifier: Modifier = Modifier,
    navController: NavController) {
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
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .padding(start = 40.dp, end = 40.dp)
            ) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "00:15:20",
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
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
                    text = "15",
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
                    text = "375 metros",
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
                    text = "3'40''",
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
                    text = "0'40''",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column {
                Button(
                    onClick = { navController.navigate("detalhes") },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = AppBlue,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Ver Tempos Parciais",
                    )
                }
            }
        }
    }
}
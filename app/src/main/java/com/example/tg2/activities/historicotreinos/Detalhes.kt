package com.example.tg2.activities.historicotreinos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetalhesContent(modifier: Modifier = Modifier,
                    navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Tempos Parciais",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp, top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )

            val lapTimes = listOf(
                "0'38''", "0'41''", "0'39''", "0'40''", "0'42''", "0'37''", "0'40''",
                "0'38''", "0'41''", "0'39''", "0'40''", "0'42''", "0'37''", "0'40''",
                "0'38''"
            )

            lapTimes.forEachIndexed { index, lapTime ->
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
                        text = lapTime,
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
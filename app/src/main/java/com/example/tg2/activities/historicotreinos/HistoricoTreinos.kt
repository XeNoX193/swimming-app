package com.example.tg2.activities.historicotreinos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.tg2.principal.AppHeader
import com.example.tg2.ui.theme.AppBlue


class HistoricoTreinos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column {
                AppHeader(
                    onBackClick = {
                        if (navController.currentBackStackEntry?.destination?.route == "paginainicial") {
                            finish()
                        } else {
                            navController.popBackStack()
                        }
                    },
                    onLogoClick = { navController.navigate("paginainicial") },
                    navController = navController
                )
                HistoricoTreinosContent(navController = navController)
            }
        }
    }
}

@Composable
fun HistoricoTreinosContent(
    modifier: Modifier = Modifier,
    navController: androidx.navigation.NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Histórico de Treinos",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            val treinos = listOf(
                Triple("Total de Piscinas: 15", "Tempo Total: 00:15:20", "25/04"),
                Triple("Total de Piscinas: 17", "Tempo Total: 00:20:02", "11/04"),
                Triple("Total de Piscinas: 10", "Tempo Total: 00:10:21", "10/04"),
                Triple("Total de Piscinas: 12", "Tempo Total: 00:13:33", "04/04"),
                Triple("Total de Piscinas: 8", "Tempo Total: 00:10:23", "01/04"),
                Triple("Total de Piscinas: 7", "Tempo Total: 00:08:11", "21/03")
            )
            treinos.forEach { (piscinas, tempo, data) ->
                Button(
                    onClick = { navController.navigate("vertreino") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = AppBlue,
                        contentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(piscinas, fontWeight = FontWeight.Bold)
                            Text(tempo, color = Color.LightGray)
                        }
                        Text("$data >", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}


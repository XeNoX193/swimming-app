package com.example.tg2.activities.historicotreinos

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
import androidx.navigation.NavController
import com.example.tg2.ui.theme.AppBlue

@Composable
fun EscolherAtletaContent(
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
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("historicotreinos") },
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
                        Text("Ângelo Teresa",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Idade: 21",
                            color = Color.LightGray
                        )
                    }
                    Text(" Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { navController.navigate("historicotreinos") },
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
                        Text("Denis Cicau",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Idade: 22",
                            color = Color.LightGray
                        )
                    }
                    Text(" Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { navController.navigate("historicotreinos")  },
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
                        Text("Carlos Freitas",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Idade: 33",
                            color = Color.LightGray
                        )
                    }
                    Text(" Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { navController.navigate("historicotreinos")  },
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
                        Text("Catarina Cunha",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Idade: 16",
                            color = Color.LightGray
                        )
                    }
                    Text(" Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { navController.navigate("historicotreinos")  },
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
                        Text("João Andrade",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Idade: 44",
                            color = Color.LightGray
                        )
                    }
                    Text(" Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Button(
                onClick = { navController.navigate("historicotreinos")  },
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
                        Text(
                            "Vinicius Junior",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Idade: 25",
                            color = Color.LightGray
                        )
                    }
                    Text(
                        " Ver Treinos >",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        }
}
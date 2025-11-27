package com.example.tg2.activities.treinoatletas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tg2.activities.historicotreinos.HistoricoTreinosContent
import com.example.tg2.principal.AppHeader
import com.example.tg2.ui.theme.AppBlue

class TreinoAtletas : ComponentActivity() {
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
fun TreinoAtletasContent(modifier: Modifier = Modifier,
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

                    Text(
                        text = "CLUBES",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = { navController.navigate("escolheratletas") },
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
                                    Text("CN BEJA",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text("Ver Atletas >",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Button(
                            onClick = { navController.navigate("escolheratletas")},
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
                                    Text("CN ALJUSTREL",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text("Ver Atletas >",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Button(
                            onClick = { navController.navigate("escolheratletas") },
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
                                    Text("CN MOURA",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text("Ver Atletas >",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Button(
                            onClick = { navController.navigate("escolheratletas") },
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
                                    Text("CN SERPA",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text("Ver Atletas >",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
             }
        }
    }
}
package com.example.tg2.principal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tg2.activities.CriarClubeContent
import com.example.tg2.activities.DadosPessoaisContent
import com.example.tg2.activities.historicotreinos.HistoricoTreinosContent
import com.example.tg2.R
import com.example.tg2.activities.historicotreinos.DetalhesTreinoContent
import com.example.tg2.activities.RealizarTreinoContent
import com.example.tg2.activities.treinoatletas.TreinoAtletasContent
import com.example.tg2.ViewModel.TreinoViewModel
import com.example.tg2.activities.LoginContent
import com.example.tg2.activities.historicotreinos.DetalhesContent
import com.example.tg2.activities.historicotreinos.EscolherAtletaContent
import com.example.tg2.activities.historicotreinos.VerTreinoContent
import com.example.tg2.ui.theme.AppBlue
import com.example.tg2.ui.theme.TG2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TG2Theme {
                val navController = rememberNavController()
                val currentBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry.value?.destination?.route

                Scaffold(
                    topBar = {
                        AppHeader(
                            onBackClick = {
                                if (navController.currentBackStackEntry?.destination?.route == "paginainicial") {
                                    finish()
                                } else {
                                    navController.popBackStack()
                                }
                            },
                            onLogoClick = { navController.navigate("paginainicial") },
                            navController = navController,
                            showActions = currentRoute != "login" // Hide actions on login
                        )
                    }
                ) { innerPadding ->
                    val treinoViewModel: TreinoViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = "paginainicial",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("paginainicial") {
                            PaginaInicialContent(
                                modifier = Modifier,
                                navController = navController
                            )
                        }
                        composable("realizartreino") {
                            RealizarTreinoContent(
                                modifier = Modifier,
                                navController = navController,
                                treinoViewModel = treinoViewModel
                            )
                        }
                        composable("historicotreinos") {
                            HistoricoTreinosContent(navController = navController)
                        }
                        composable("criarclube") {
                            CriarClubeContent()
                        }
                        composable("treinoatletas") {
                            TreinoAtletasContent(navController = navController)
                        }
                        composable("dadospessoais") {
                            DadosPessoaisContent()
                        }
                        composable("login") {
                            LoginContent()
                        }
                        composable("detalhestreino") {
                            DetalhesTreinoContent(
                                modifier = Modifier,
                                treinoViewModel = treinoViewModel
                            )
                        }
                        composable("vertreino") {
                            VerTreinoContent(navController = navController)
                        }
                        composable("detalhes") {
                            DetalhesContent(navController = navController)
                        }
                        composable("escolheratletas") {
                            EscolherAtletaContent(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

data class GridItem(val imageRes: Int, val route: String)

@Composable
fun PaginaInicialContent(
    modifier: Modifier = Modifier,
    navController: androidx.navigation.NavController
) {
    val items = listOf(
        GridItem(R.drawable.novotreino, "realizartreino"),
        GridItem(R.drawable.historicotreinos, "historicotreinos"),
        GridItem(R.drawable.criarclube, "criarclube"),
        GridItem(R.drawable.treinoatletas, "treinoatletas"),
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 150.dp, horizontal = 25.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { navController.navigate(item.route) }
                ) {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.White)
                            .border(width = 1.dp, color = AppBlue)
                    ) {
                        Image(
                            painter = painterResource(id = item.imageRes),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

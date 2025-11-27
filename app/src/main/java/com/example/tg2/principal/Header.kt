package com.example.tg2.principal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tg2.R
import com.example.tg2.ui.theme.AppBlue

@Composable
fun AppHeader(
    onBackClick: () -> Unit,
    onLogoClick: () -> Unit,
    navController: androidx.navigation.NavController,
    showActions: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, end = 8.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            if (showActions && currentRoute != "paginainicial") {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .height(35.dp)
                        .padding(horizontal = 4.dp),
                    border = BorderStroke(1.dp, AppBlue),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = AppBlue,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                    Text(
                        text = "Back",
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
        if (showActions) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val showDadosPessoaisButton = currentRoute != "dadospessoais"
            val buttonWidth = Modifier
                .height(35.dp)
                .padding(horizontal = 4.dp)
                .sizeIn(minWidth = 140.dp) // adjust as needed for your button

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showDadosPessoaisButton) {
                    OutlinedButton(
                        onClick = { navController.navigate("dadospessoais") },
                        modifier = buttonWidth,
                        border = BorderStroke(1.dp, AppBlue),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = AppBlue,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Dados Pessoais")
                    }
                } else {
                    Spacer(modifier = buttonWidth)
                }
                Spacer(modifier = Modifier.weight(1f))
                val imagePainter = painterResource(id = R.drawable.applogo)
                Image(
                    painter = imagePainter,
                    contentDescription = "AppLogo",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(horizontal = 4.dp)
                        .clickable(onClick = onLogoClick)
                )
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = { navController.navigate("login") },
                    modifier = buttonWidth,
                    border = BorderStroke(1.dp, AppBlue),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = AppBlue,
                        contentColor = Color.White
                    )
                ) {
                    Text("Terminar Sessão")
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val imagePainter = painterResource(id = R.drawable.applogo)
                Image(
                    painter = imagePainter,
                    contentDescription = "AppLogo",
                    modifier = Modifier.size(100.dp)
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Color.Black,
            thickness = 1.dp
        )
    }
}


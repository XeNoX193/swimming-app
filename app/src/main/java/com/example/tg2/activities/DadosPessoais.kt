package com.example.tg2.activities

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
import com.example.tg2.ui.theme.AppBlue
import com.example.tg2.ui.theme.GreenButton


class DadosPessoais : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
            ) { innerPadding ->
                DadosPessoaisContent(Modifier.padding(innerPadding))
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DadosPessoaisContent(modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val sexoOptions = listOf("Masculino", "Feminino")
    var sexo by remember { mutableStateOf("") }

    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    var showMessage by remember { mutableStateOf(false) }

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
                text = "Dados Pessoais",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = idade,
                    onValueChange = { idade = it },
                    label = { Text("Idade") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ){
                    OutlinedTextField(
                        value = sexo,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Sexo") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                        modifier = Modifier.menuAnchor().fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.heightIn(max = 100.dp)
                    ) {
                        sexoOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option) },
                                onClick = {
                                    sexo = option
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = peso,
                    onValueChange = { peso = it },
                    label = { Text("Peso (Kg)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = altura,
                    onValueChange = { altura = it },
                    label = { Text("Altura (cm)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {

                        showMessage = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenButton,
                        contentColor = Color.White
                    )
                ) {
                    Text("GUARDAR")
                }

                if (showMessage) {
                    Text(
                        text = "Dados Guardados!",
                        color = AppBlue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }
}
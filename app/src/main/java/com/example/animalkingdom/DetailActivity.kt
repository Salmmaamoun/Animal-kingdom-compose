package com.example.animalkingdom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve intent data in onCreate
        val animalName = intent.getStringExtra("ANIMAL_NAME") ?: "Unknown"
        val animalImageResId = intent.getIntExtra("ANIMAL_IMAGE", -1)

        setContent {
            // Pass the retrieved data to the composable
            DetailScreen(animalName, animalImageResId)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(animalName: String, animalImageResId: Int) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animal Details") },
                navigationIcon = {
                    IconButton(onClick = {  val intent = Intent(context , MainActivity::class.java)
                        context.startActivity(intent)}) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (animalImageResId != -1) {
                Image(
                    painter = painterResource(id = animalImageResId),
                    contentDescription = animalName,
                    modifier = Modifier.size(250.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = animalName,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDetailPreview() {
    // Preview with dummy data
    DetailScreen(animalName = "Lion", animalImageResId = R.drawable.lion)
}

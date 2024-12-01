package com.example.animalkingdom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.animalkingdom.data.AnimalData
import com.example.animalkingdom.model.Animal
import com.example.animalkingdom.ui.theme.AnimalKingdomTheme
import com.example.animalkingdom.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalKingdomTheme {
                // Pass the list of animals to the composable
                AnimalListScreen(animals = AnimalData.getAnimals()) // Ensure this returns List<Animal>
            }
        }
    }
}

@Composable
fun AnimalListScreen(animals: List<Animal>) {
    val context = LocalContext.current // Get the context in a composable

    // LazyColumn for displaying the list of animals
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Use 'items' to display the list of animals
        items(animals) { animal ->
            AnimalListItem(animal = animal) {
                // Handle the item click, navigate to DetailActivity
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("ANIMAL_NAME", animal.description)
                    putExtra("ANIMAL_IMAGE", animal.imageResId)
                }
                context.startActivity(intent)
            }
        }
    }
}

@Composable
fun AnimalListItem(animal: Animal, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = animal.imageResId),
                contentDescription = animal.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = animal.name,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimalKingdomTheme {
        // Preview the screen with animals
        AnimalListScreen(animals = AnimalData.getAnimals()) // Ensure this returns List<Animal>
    }
}

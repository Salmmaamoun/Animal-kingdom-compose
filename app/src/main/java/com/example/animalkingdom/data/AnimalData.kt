package com.example.animalkingdom.data

import com.example.animalkingdom.R
import com.example.animalkingdom.model.Animal

object AnimalData {
    fun getAnimals(): List<Animal> {
        return listOf(
            Animal("Lion", R.drawable.lion, "The lion is a species of big cat"),
            Animal("Elephant", R.drawable.elephant, "Elephants are large mammals"),
            Animal("Cat", R.drawable.cat, "Cats are domesticated carnivores"),
            Animal("Bear", R.drawable.bear, "Bears are large carnivorous mammals"),
            Animal("Cow", R.drawable.cow, "Cows are domesticated herbivores"),
            Animal("Dog", R.drawable.dog, "Dogs are loyal domesticated animals"),
            Animal("Crab", R.drawable.crab, "Crabs are marine crustaceans"),
            Animal("Frog", R.drawable.frog, "Frogs are amphibians"),
            Animal("Giraffe", R.drawable.giraffe, "Giraffes are the tallest mammals on Earth"),
            Animal("Whale", R.drawable.whale, "Whales are large marine mammals"),
            Animal("Horse", R.drawable.horse, "Horses are domesticated herbivores"),
            Animal("Monkey", R.drawable.monkey, "Monkeys are intelligent primates"),
            Animal("Snake", R.drawable.snake, "Snakes are elongated reptiles"),
            Animal("Mouse", R.drawable.mouse, "Mice are small rodents")
        )
    }
}

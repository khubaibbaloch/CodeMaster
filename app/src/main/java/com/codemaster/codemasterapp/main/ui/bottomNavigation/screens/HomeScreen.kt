package com.codemaster.codemasterapp.main.ui.bottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codemaster.codemasterapp.R
import com.codemaster.codemasterapp.main.ui.components.LanguageCardDesign
import com.codemaster.codemasterapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            /*TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "CodeMaster",
                            color = Color(0xFFE5E5C2),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(Modifier.weight(1f))
                        IconButton(onClick = { /* Navigate to Profile Screen */ }) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Profile",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2F3E4C),
                ),
            )*/
            HomeScreenCustomTopBar()
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF7F9FC)) // Soft background color for the main area
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Title + Search Icon
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Popular courses:",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF2F3E4C)
                        )
                        IconButton(onClick = { /* Handle search */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color(0xFF2F3E4C),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(16.dp))

                    // First Row of Language Cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        LanguageCardDesign(
                            languageName = "Python",
                            difficulty = "Beginner",
                            lessonCount = 40,
                            completedLessonCount = 30,
                            gradientColors = listOf(bluishPython, greenishPython),
                            languageImage = painterResource(id = R.drawable.pythonlogo),
                            onClick = { /* Navigate to Python course */ },
                            modifier = Modifier.weight(1f)
                        )

                        LanguageCardDesign(
                            languageName = "Java",
                            difficulty = "Medium",
                            lessonCount = 40,
                            completedLessonCount = 3,
                            gradientColors = listOf(yellowishJava, bluishJava),
                            languageImage = painterResource(id = R.drawable.java),
                            onClick = { /* Navigate to Java course */ },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // Second Row of Language Cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        LanguageCardDesign(
                            languageName = "Kotlin",
                            difficulty = "Beginner",
                            lessonCount = 40,
                            completedLessonCount = 20,
                            gradientColors = listOf(purpleKt, yellowishKt),
                            languageImage = painterResource(id = R.drawable.kotlin),
                            onClick = { /* Navigate to Kotlin course */ },
                            modifier = Modifier.weight(1f)
                        )

                        LanguageCardDesign(
                            languageName = "C++",
                            difficulty = "Expert",
                            lessonCount = 40,
                            completedLessonCount = 30,
                            gradientColors = listOf(purpleCpp, magentaCpp),
                            languageImage = painterResource(id = R.drawable.cpp),
                            onClick = { /* Navigate to C++ course */ },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    )
}


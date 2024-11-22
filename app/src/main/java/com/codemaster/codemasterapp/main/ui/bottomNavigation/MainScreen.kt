package com.codemaster.codemasterapp.main.ui.bottomNavigation;

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.codemaster.codemasterapp.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codemaster.codemasterapp.main.ui.bottomNavigation.navgraph.RootNavHost
import com.codemaster.codemasterapp.main.ui.bottomNavigation.navgraph.routes.BottomNavRoutes
import javax.annotation.meta.When
import kotlin.random.Random


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen() {
    val navController = rememberNavController()
    val selectedIndex = remember { mutableStateOf(0) }

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBar =
        currentRoute == BottomNavRoutes.HomeScreen.route || currentRoute == BottomNavRoutes.AchievementsScreen.route

    Scaffold(
        bottomBar = {
            if (showBar) {
                //BottomNavBar(navController)

                CustomBottomBar(
                    items = listOf(
                        BottomBarItem("Home", R.drawable.stud),
                        BottomBarItem("Search", R.drawable.com),
                        BottomBarItem("Profile", R.drawable.achivments)
                    ),
                    selectedItemIndex = selectedIndex.value,
                    onItemSelected = { index ->
                        selectedIndex.value = index
                        // Navigate or perform actions based on index
                        when (index) {
                            0 -> navController.navigate(BottomNavRoutes.HomeScreen.route)
                            1 -> {
//                                navController.navigate(BottomNavRoutes.ExtraScreen.route)
                            }

                            2 -> navController.navigate(BottomNavRoutes.AchievementsScreen.route)
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        val darkGradient = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF2C5364), // Charcoal
                Color(0xFF203A43), // Dark Teal Blue
                Color(0xFF0F2027), // Deep Blackish Teal

            )
        )

        val blueTechGradient = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF344759),  // Steel Blue
                Color(0xFF202833), // Slightly Lighter Blue Gray
                Color(0xFF1A1D23), // Dark Charcoal Blue
            )
        )

        val purpleAccentGradient = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF1E0630), // Dark Purple
                Color(0xFF2A104B), // Deep Violet
                Color(0xFF3E2068)  // Muted Purple
            )
        )

        TechBackground(navController)

    }
}

val blueTechGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF344759),  // Steel Blue
        Color(0xFF202833), // Slightly Lighter Blue Gray
        Color(0xFF1A1D23), // Dark Charcoal Blue
    )
)

val screenBackgroundGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF101820), // Very Dark Blue
        Color(0xFF0F263D), // Slightly Brighter Blue
        Color(0xFF15476E)  // Cool Medium Blue
    )
)

@Composable
fun TechBackground(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = screenBackgroundGradient)

    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Binary numbers
            for (i in 0..30) {
                drawContext.canvas.nativeCanvas.drawText(
                    if (Random.nextBoolean()) "1010 0101" else "1100 1110",
                    Random.nextFloat() * width,
                    Random.nextFloat() * height,
                    android.graphics.Paint().apply {
                        color = android.graphics.Color.WHITE
                        alpha = 40
                        textSize = 20f
                        isAntiAlias = true
                    }
                )
            }

            // Circular paths
            for (i in 1..5) {
                val centerX = Random.nextFloat() * width
                val centerY = Random.nextFloat() * height
                drawCircle(
                    color = Color.White.copy(alpha = 0.05f),
                    radius = 50f * i,
                    center = Offset(centerX, centerY),
                    style = Stroke(width = 1.5f)
                )
            }

            // Curved coding brackets
            for (i in 0..2) {
                val bracketPath = Path().apply {
                    moveTo(Random.nextFloat() * width, Random.nextFloat() * height)
                    cubicTo(
                        Random.nextFloat() * width, Random.nextFloat() * height,
                        Random.nextFloat() * width, Random.nextFloat() * height,
                        Random.nextFloat() * width, Random.nextFloat() * height
                    )
                }
                drawPath(
                    path = bracketPath,
                    color = Color.White.copy(alpha = 0.1f),
                    style = Stroke(width = 2f)
                )
            }

            // Coding symbols ("</>")
            for (i in 0..15) {
                drawContext.canvas.nativeCanvas.drawText(
                    "</>",
                    Random.nextFloat() * width,
                    Random.nextFloat() * height,
                    android.graphics.Paint().apply {
                        color = android.graphics.Color.WHITE
                        alpha = 40 // Slightly more visible
                        textSize = 25f
                        isAntiAlias = true
                    }
                )
            }

            // Circuit lines
            for (i in 0..10) {
                val startX = Random.nextFloat() * width
                val startY = Random.nextFloat() * height
                val endX = startX + (Random.nextFloat() * 100f - 50f)
                val endY = startY + (Random.nextFloat() * 100f - 50f)
                drawLine(
                    color = Color.White.copy(alpha = 0.2f),
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = 1.5f
                )
            }
        }

        val screenBackgroundGradient2 = Brush.verticalGradient(
            colors = listOf(
                Color(0x99101820), // Very Dark Blue
                Color(0x990F263D), // Slightly Brighter Blue
                Color(0x9915476E)  // Cool Medium Blue
            )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(screenBackgroundGradient2)
        ) {

        }

        // Navigation host
        RootNavHost(navController = navController)
    }
}


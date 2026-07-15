package com.anees.signuppage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.shadow.Shadow

@Composable
fun ScreenA(name: String, email: String, gender: String, hobbies: String,navController: NavHostController,) {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 70.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Page",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xffFF7686)
        )
        Spacer(modifier = Modifier.height(90.dp))

        Text(text = "My Name is, $name!", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(13.dp))

        Text(text = "Email: $email", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(13.dp))
        HorizontalDivider(Modifier, DividerDefaults.Thickness, color = Color.Red)
        Spacer(modifier = Modifier.height(13.dp))

        Text(text = "My Gender is : $gender", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(13.dp))

        Text(text = "My Hobbies are: $hobbies", fontSize = 16.sp, color = Color.DarkGray)

        Spacer(modifier = Modifier.height(320.dp))
        CalculatorButton(navController = navController)
        Spacer(modifier = Modifier.height(25.dp))
        NavigationButton(navController = navController)
    }
}

@Composable
fun CalculatorButton(
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .width(343.dp)
            .height(40.dp)
            .dropShadow(
                shape = RoundedCornerShape(30.dp),
                shadow = Shadow(
                    color = Color(0xffFF7686).copy(alpha = 0.5f),
                    offset = DpOffset(6.dp, 8.dp),
                    radius = 6.dp
                )
            )
            .background(Color.White, shape = RoundedCornerShape(30.dp))
            .clickable {
                navController.navigate("calculator_page")
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Calculator", color = Color.Black, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun NavigationButton(
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .width(343.dp)
            .height(40.dp)
            .dropShadow(
                shape = RoundedCornerShape(30.dp),
                shadow = Shadow(
                    color = Color(0xffFF7686).copy(alpha = 0.5f),
                    offset = DpOffset(6.dp, 8.dp),
                    radius = 6.dp
                )
            )
            .background(Color.White, shape = RoundedCornerShape(30.dp))
            .clickable {
                navController.navigate("mainn_screen")
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Move Next!", color = Color.Black, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold)
    }
}


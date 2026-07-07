package com.anees.signuppage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenA(name: String, email: String, gender: String, hobbies: String) {
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
    }
}
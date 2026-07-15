package com.anees.signuppage

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.clip(shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffFF7787),
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                ),
                title = { Text("DASHBOARD", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.padding(25.dp)) {
                var text by remember { mutableStateOf("") }
                var selectedTag by remember { mutableStateOf("Most Viewed") }

                Text(text = "Hi, Anees", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "Explore the World", fontSize = 19.sp, fontWeight = FontWeight.Medium, color = Color.Gray)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = text,
                    onValueChange = {text = it},
                    placeholder = { Text("Search Places") },

                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.width(374.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(

                        focusedBorderColor = Color(0xFFFF7686),
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,

                        focusedLabelColor = Color(0xFFFF7686),
                        focusedTrailingIconColor = Color(0xffFF7686),
                    )
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text= "Popular Places", color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                    Text(text = "View all", color = Color.Gray, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    tags(
                        title = "Most Viewed",
                        isSelected = selectedTag == "Most Viewed",
                        onClick = { selectedTag = "Most Viewed" }
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    tags(
                        title = "Nearby",
                        isSelected = selectedTag == "Nearby",
                        onClick = { selectedTag = "Nearby" }
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    tags(
                        title = "Latest",
                        isSelected = selectedTag == "Latest",
                        onClick = { selectedTag = "Latest" }
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    tags(
                        title = "Beautiful",
                        isSelected = selectedTag == "Beautiful",
                        onClick = { selectedTag = "Beautiful" }
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    CustomCard("Calculator",
                        imageRes = R.drawable.banner1,
                        onClick = {
                        navController.navigate("calculator_page")
                    } )
                    Spacer(modifier = Modifier.width(15.dp))
                    CustomCard("Form Page",
                        imageRes = R.drawable.banner2,
                        onClick = {
                        navController.navigate("main_screen")
                    } )
                    Spacer(modifier = Modifier.width(15.dp))
                    CustomCard("Expenses",
                        imageRes = R.drawable.banner3,
                        onClick = {
                            navController.navigate("mainn_screen")
                        } )


                }
            }
        }
    }
}




@Composable
fun CustomCard(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    imageRes: Int
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .height(405.dp)
            .width(270.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .background(Color.Gray)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$text background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .height(38.dp)
                .width(230.dp)
                .clip(shape = RoundedCornerShape(18.dp))
                .background(Color(0xffFF7787))
                .clickable(onClick = {onClick()})
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun tags(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) Color(0xffFF7787) else Color.LightGray,
        label = "BoxColorAnimation"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(54.dp)
            .width(136.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(animatedColor)
            .clickable(onClick = onClick)
    ) {
        Text(text = title, color = Color.White, fontWeight = FontWeight.Medium, fontSize = 16.sp)
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview(){
    val dummyNavController = rememberNavController()
    Dashboard(navController = dummyNavController)
}
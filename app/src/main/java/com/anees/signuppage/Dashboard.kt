package com.anees.signuppage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
                Text(text = "Hi, Anees", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "Explore the World", fontSize = 19.sp, fontWeight = FontWeight.Medium, color = Color.Gray)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = text,
                    onValueChange = {text = it},
                    label = {Text("Search places")},
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.width(374.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color(0xFFFF7686),
                        focusedTrailingIconColor = Color(0xffFF7686),
                        focusedContainerColor = Color(0xFFF3F3F3),
                        unfocusedContainerColor = Color(0xFFF3F3F3),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
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




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview(){
    val dummyNavController = rememberNavController()
    Dashboard(navController = dummyNavController)
}
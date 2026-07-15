package com.anees.signuppage

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AirplaneTicket
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import components.DataComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffFF7787),
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                ),
                title = { Text("Summer Travel", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.fillMaxSize().background(color = Color(0xffFF7787))
            ) {
                Column(
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically                        ){
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(64.dp)
                                    .background(
                                        color = Color(0xFFE86877),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {
                                Icon(imageVector = Icons.AutoMirrored.Filled.AirplaneTicket,
                                    contentDescription = "Arrow",
                                    tint = Color.White,
                                    modifier = Modifier.size(34.dp)
                                    )
                            }
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(text = "$1,283", fontSize = 60.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .width(263.5.dp)
                            .height(12.dp)
                            .background(
                                color = Color(0xffFFCCD2),
                                shape = RoundedCornerShape(50.dp)
                                )
                        ) {}
                        Box(modifier = Modifier
                            .width(46.5.dp)
                            .height(12.dp)
                            .background(
                                color = Color(0xffF06F7D),
                                shape = RoundedCornerShape(50.dp)
                            )
                        ) {}
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 42.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "3 weeks left", color = Color(0xffC0ECD5), fontSize = 14.sp)
                        Text(text = "$ 1,500", color = Color(0xffC0ECD5), fontSize = 14.sp)

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .background(color = Color.White,
                                shape = RoundedCornerShape(topStart = 34.dp, topEnd = 34.dp)
                                )
                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState()),
                            ) {
                            DataComponent("Pending Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Pending Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                            DataComponent("Save")
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}
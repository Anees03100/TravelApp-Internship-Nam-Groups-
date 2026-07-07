package com.anees.signuppage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider

import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.anees.signuppage.ui.theme.SignupPageTheme

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignupPageTheme {
                Nav()
            }
        }
    }
}


@Composable
fun Main(navController: NavHostController) {
    var nameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Male") }
    val checkList = remember {
        mutableStateListOf(
            CheckableItem(id = 1, text = "Cricket", isChecked = false),
            CheckableItem(id = 2, text = "Foot-Ball", isChecked = false),
            CheckableItem(id = 3, text = "Badminton", isChecked = false),
            CheckableItem(id = 4, text = "Hockey", isChecked = false),
            CheckableItem(id = 5, text = "Gaming", isChecked = false),
            CheckableItem(id = 6, text = "Other", isChecked = false)
        )
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            MyPicture()
            Spacer(modifier = Modifier.height(25.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create Your Account", fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(25.dp))
                NameTextFieldd(value = nameText, onValueChange = { nameText = it })
                Spacer(modifier = Modifier.height(25.dp))
                EmailTextFieldd(
                    value = emailText,
                    onValueChange = { emailText = it }
                )
                Spacer(modifier = Modifier.height(25.dp))
                PasswordTextFieldd()
                Spacer(modifier = Modifier.height(25.dp))
                ConfirmPasswordTextFieldd()
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Gender: ", modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                RadioButtons(
                    selectedOption = selectedGender,
                    onOptionSelected = { selectedGender = it })
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color(0xffFF7686)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Hobbies: ", modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                CheckBoxParagraphView(checkList = checkList)
            }
            Spacer(modifier = Modifier.height(10.dp))
            ContinueButton()
            Spacer(modifier = Modifier.height(10.dp))
            SignUpButton(
                navController = navController,
                name = nameText,
                email = emailText,
                gender = selectedGender,
                checkList = checkList
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}


@Composable
fun NameTextFieldd(value: String, onValueChange: (String) -> Unit) {

    TextField(

        value = value,
        onValueChange = onValueChange,
        label = { Text("Name") },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp)
            .height(height = 50.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Valid Email",
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
}


@Composable
fun EmailTextFieldd(value: String, onValueChange: (String) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Email") },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp)
            .height(height = 50.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Valid Email",
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTrailingIconColor = Color(0xffFF7686),
            focusedLabelColor = Color(0xFFFF7686),
            focusedContainerColor = Color(0xFFF3F3F3),
            unfocusedContainerColor = Color(0xFFF3F3F3),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            )
    )
}

@Composable
fun PasswordTextFieldd() {
    var email by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Password") },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp)
            .height(height = 50.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Password,
                contentDescription = "Valid Email",
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTrailingIconColor = Color(0xffFF7686),
            focusedLabelColor = Color(0xFFFF7686),
            focusedContainerColor = Color(0xFFF3F3F3),
            unfocusedContainerColor = Color(0xFFF3F3F3),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun ConfirmPasswordTextFieldd() {
    var email by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Confirm Password") },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp)
            .height(height = 50.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Password,
                contentDescription = "Valid Email",
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTrailingIconColor = Color(0xffFF7686),
            focusedLabelColor = Color(0xFFFF7686),
            focusedContainerColor = Color(0xFFF3F3F3),
            unfocusedContainerColor = Color(0xFFF3F3F3),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            )
    )
}

@Composable
fun MyPicture() {
    val context = LocalContext.current
    Box() {
        Box(
            modifier = Modifier
                .offset(x = (-20).dp, y = 10.dp)
                .width(25.dp)
                .height(25.dp)
                .clip(RoundedCornerShape(size = 50.dp))
                .background(color = Color.Red)
                .clickable {
                    Toast.makeText(
                        context, "Close", Toast.LENGTH_SHORT
                    ).show()
                }, contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                imageVector = Icons.Filled.Close, contentDescription = "Close ",
                tint = Color.White
            )
        }
        Image(
            alignment = Alignment.Center,
            painter = painterResource(R.drawable.logo1),
            contentDescription = "Description of the object",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 282.dp, height = 264.dp)
        )
    }

}

@Composable
fun RadioButtons(selectedOption: String, onOptionSelected: (String) -> Unit) {
    val radioOptions = listOf("Male", "Female")
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    .padding(horizontal = 8.dp)
            ) {
                RadioButton(
                    colors = RadioButtonColors(
                        selectedColor = Color(0xffFF7686),
                        unselectedColor = Color.Gray,
                        disabledSelectedColor = Color.Transparent,
                        disabledUnselectedColor = Color.Transparent

                    ),
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ContinueButton() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .border(width = 2.dp, color = Color(0xffFF7686), shape = RoundedCornerShape(16.dp))
            .width(width = 350.dp)
            .height(height = 40.dp)
            .clickable {
                Toast.makeText(
                    context, "Guest Account Created", Toast.LENGTH_SHORT
                ).show()
            }
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(size = 16.dp),
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Continue as a guest",
            color = Color(0xffFF7686),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}


@Composable
fun SignUpButton(
    navController: NavHostController,
    name: String,
    email: String,
    gender: String,
    checkList: List<CheckableItem>
) {
    Box(
        modifier = Modifier
            .width(width = 350.dp)
            .height(height = 40.dp)
            .clickable {
                val cleanName = name.ifBlank { "User" }
                val cleanEmail = email.ifBlank { "NoEmail" }
                val selectedHobbies = checkList.filter { it.isChecked }.map { it.text }
                val hobbiesString =
                    if (selectedHobbies.isEmpty()) "None" else selectedHobbies.joinToString(", ")
                navController.navigate("screen_a/$cleanName/$cleanEmail/$gender/$hobbiesString")

            }
            .background(
                color = Color(0xffFF7686), shape = RoundedCornerShape(size = 16.dp)
            ), contentAlignment = Alignment.Center) {
        Text(text = "SignUp", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}


data class CheckableItem(
    val id: Int,
    val text: String,
    var isChecked: Boolean
)

@Suppress("DEPRECATION")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CheckBoxParagraphView(checkList: androidx.compose.runtime.snapshots.SnapshotStateList<CheckableItem>) {

    ContextualFlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        itemCount = checkList.size,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) { index ->
        val item = checkList[index]

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xffFF7686),
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                ),
                checked = item.isChecked,
                onCheckedChange = { isCheckedNow ->
                    checkList[index] = item.copy(isChecked = isCheckedNow)
                }
            )
            Text(text = item.text, fontSize = 16.sp)
        }
    }
}


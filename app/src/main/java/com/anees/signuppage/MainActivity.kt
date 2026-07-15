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
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.anees.signuppage.ui.theme.SignupPageTheme

class MainActivity : ComponentActivity() {
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
    var nameError by remember { mutableStateOf<String?>(null) }

    var emailText by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }

    var passwordText by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf<String?>(null) }

    var confirmText by remember { mutableStateOf("") }
    var confirmError by remember { mutableStateOf<String?>(null) }

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
    var hobbyError by remember { mutableStateOf<String?>(null) }


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
                NameTextFieldd(
                    value = nameText, error = nameError,
                    onValueChange = {
                        nameText = it
                        nameError = null
                    })
                Spacer(modifier = Modifier.height(25.dp))
                EmailTextFieldd(
                    value = emailText,
                    error = emailError,
                    onValueChange = {
                        emailText = it
                        emailError = null
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
                PasswordTextFieldd(
                    value = passwordText,
                    error = passwordError,
                    onValueChange = {
                        passwordText = it
                        passwordError = null
                    })
                Spacer(modifier = Modifier.height(25.dp))
                ConfirmPasswordTextFieldd(
                    value = confirmText,
                    error = confirmError,
                    onValueChange = { confirmText = it
                    confirmError = null
                    })
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
                HorizontalDivider(Modifier, DividerDefaults.Thickness, color = Color(0xffFF7686))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Hobbies: ", modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                CheckBoxParagraphView(checkList = checkList, onCheckedChange = {hobbyError = null})
                if(hobbyError != null){
                    Text(
                        text = hobbyError!!,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 16.dp, top = 4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            ContinueButton()
            Spacer(modifier = Modifier.height(10.dp))
            SignUpButton(
                navController = navController,
                name = nameText,
                email = emailText,
                gender = selectedGender,
                checkList = checkList,
                onValidateEmail = {
                    val emailPattern = android.util.Patterns.EMAIL_ADDRESS

                    if (emailText.isBlank()) {
                        emailError = "Email cannot be empty"
                        false
                    } else if (!emailPattern.matcher(emailText).matches()) {
                        emailError = "Please Enter a valid Email Address"
                        false
                    } else {
                        emailError = null
                        true
                    }
                },
                onValidatePassword = {
                    val hasUpperCase = passwordText.any{it.isUpperCase()}
                    val hasSpecialChar = passwordText.any {
                        !it.isLetterOrDigit()
                    }
                    val hasNumber = passwordText.any{
                        it.isDigit()
                    }
                    if (passwordText.isBlank()) {
                        passwordError = "Password cannot be empty"
                        false
                    }else if (passwordText.length < 6) {
                        passwordError = "Password must be at least 6 characters"
                        false
                    } else if (!hasUpperCase) {
                        passwordError = "Password must contain one UpperCase letter"
                        false
                    }else if(!hasSpecialChar){
                        passwordError = "Password must contain one special character"
                        false
                    } else if(!hasNumber){
                        passwordError = "Password must contain Digit"
                        false
                    }else{
                        passwordError = null
                        true
                    }
                },
                onValidateConfirm = {
                    if(confirmText.isBlank()){
                        confirmError = "Please re-enter your password"
                        false
                    }else if(confirmText != passwordText){
                        confirmError = "Passwords do not match"
                        false
                    }else{
                        confirmError = null
                        true
                    }
                },
                onValidateHobbies = {
                    val isAnyChecked = checkList.any { it.isChecked }

                    if (!isAnyChecked) {
                        hobbyError = "Please select at least one hobby"
                        false
                    } else {
                        hobbyError = null
                        true
                    }
                },
                onValidateName = {
                    if (nameText.isBlank()) {
                        nameError = "Name cannot be empty"
                        false
                    } else if (nameText.length < 3) {
                        nameError = "Name must be atleast 3 Character"
                        false
                    } else {
                        nameError = null
                        true
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}


@Composable
fun NameTextFieldd(value: String, onValueChange: (String) -> Unit, error: String?) {

    TextField(

        value = value,
        onValueChange = onValueChange,
        label = { Text("Name") },
        singleLine = true,
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = error, color = Color.Red)
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp),
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

            errorContainerColor = Color(0xFFFDF2F2),
            errorLabelColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            errorIndicatorColor = Color.Transparent,
            )
    )
}

@Composable
fun EmailTextFieldd(value: String, error: String?, onValueChange: (String) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Email") },
        singleLine = true,
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = error, color = Color.Red)
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp),
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

            errorContainerColor = Color(0xFFFDF2F2),
            errorLabelColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            errorIndicatorColor = Color.Transparent

        )
    )
}

@Composable
fun PasswordTextFieldd(value: String, error: String?, onValueChange: (String) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Password") },
        singleLine = true,
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = error, color = Color.Red)
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Password,
                contentDescription = "Valid Password",
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

            errorContainerColor = Color(0xFFFDF2F2),
            errorLabelColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            errorIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ConfirmPasswordTextFieldd(value: String, error: String?,onValueChange: (String) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Confirm Password") },
        singleLine = true,
        isError = error !=null,
        supportingText = {
            if(error != null){
                Text(text = error, color = Color.Red)
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(width = 336.dp),
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

            errorContainerColor = Color(0xFFFDF2F2),
            errorLabelColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            errorIndicatorColor = Color.Transparent,

            )
    )
}

@Composable
fun MyPicture() {
    val context = LocalContext.current
    Box {
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
    checkList: List<CheckableItem>,
    onValidateName: () -> Boolean,
    onValidateEmail: () -> Boolean,
    onValidatePassword: () -> Boolean,
    onValidateConfirm: () -> Boolean,
    onValidateHobbies: () -> Boolean
) {
    Box(
        modifier = Modifier
            .width(width = 350.dp)
            .height(height = 40.dp)
            .clickable {
                val isNameValid = onValidateName()
                val isErrorValid = onValidateEmail()
                val isPasswordValid = onValidatePassword()
                val isConfirmPasswordValid = onValidateConfirm()
                val isHobbiesValid = onValidateHobbies()
                if (isNameValid && isErrorValid && isPasswordValid && isConfirmPasswordValid && isHobbiesValid) {
                    val cleanName = name.ifBlank { "User" }
                    val cleanEmail = email.ifBlank { "NoEmail" }
                    val selectedHobbies = checkList.filter { it.isChecked }.map { it.text }
                    val hobbiesString =
                        if (selectedHobbies.isEmpty()) "None" else selectedHobbies.joinToString(", ")
                    navController.navigate("screen_a/$cleanName/$cleanEmail/$gender/$hobbiesString")

                }

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
fun CheckBoxParagraphView(checkList: androidx.compose.runtime.snapshots.SnapshotStateList<CheckableItem>, onCheckedChange: () -> Unit) {

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
                    onCheckedChange()
                }
            )
            Text(text = item.text, fontSize = 16.sp)
        }
    }
}


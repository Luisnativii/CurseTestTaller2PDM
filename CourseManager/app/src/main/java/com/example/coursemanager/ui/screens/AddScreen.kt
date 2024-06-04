package com.example.coursemanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coursemanager.MainViewModel
import com.example.coursemanager.data.database.entity.Course
import com.example.coursemanager.data.database.entity.Topic
import com.example.coursemanager.data.topicList
import com.example.coursemanager.ui.component.TopBar

@Composable
fun AddScreen(

    viewModel: MainViewModel,
    navController: NavController
) {


    // estado que almacena la informacion del curso

    var coursedata by remember { mutableStateOf(Course()) }

    // estado que almacena el tema

    var topictitle by remember {
        mutableStateOf("")
    }

    val keyBoardController = LocalSoftwareKeyboardController.current



    Scaffold (


        topBar = {
            TopBar(
                title = "Add Course",
                navControler = navController
            )
        },
    ) {paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = coursedata.code,
                onValueChange = { updatedString ->
                                coursedata = coursedata.copy(code = updatedString)

                },
                label = { Text(text = "Code")},
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = coursedata.title,
                onValueChange = { updatedString ->
                    coursedata = coursedata.copy(title = updatedString)

                },
                label = { Text(text = "Title")},
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(128.dp),
                value = coursedata.description,
                onValueChange = { updatedString ->
                    coursedata = coursedata.copy(description = updatedString)

                },
                label = { Text(text = "Description")},
                singleLine = false,
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = coursedata.category,
                onValueChange = { updatedString ->
                    coursedata = coursedata.copy(category = updatedString)

                },
                label = { Text(text = "Category")},
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(8.dp),
                //VerticalAlignmentLine = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .weight(0.7f),
                    value = topictitle,
                    onValueChange = { updatedString ->
                        topictitle = updatedString
                    },
                    label = { Text(text = "Topic")},
                )

                Button(
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(12.dp),
                    onClick = {
                        keyBoardController?.hide()
                        topicList.add(

                            Topic(title =  topictitle)
                        )

                        topictitle = ""

                    },
                    enabled = if(topictitle.isEmpty()) false else true
                )

                {
                    Text(text = "Add")
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(LightGray),
            ) {
                items(topicList){ topic ->

                    Text(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        text = topic.title


                    )
                    Divider(thickness = 1.dp, color = Color.Gray)
                }
            }
        }
    }

}



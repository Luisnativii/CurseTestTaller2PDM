package com.example.coursemanager.ui.screens

import android.app.LauncherActivity
import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coursemanager.MainViewModel
import com.example.coursemanager.data.curseList
import com.example.coursemanager.data.database.entity.Course
import com.example.coursemanager.ui.component.ListItem
import com.example.coursemanager.ui.component.TopBar
import com.example.coursemanager.ui.navigation.ScreenRoute

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    navController: NavController

) {

    Scaffold (

        topBar = {
            TopBar(
                title = "Edit Course",
                navControler = navController
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(ScreenRoute.Add.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }

    ) {paddingValues ->
        LazyColumn(

            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()

        ) {

            items(curseList){ course ->
                ListItem(

                    course,
                    onItemClick = { selectedCourse ->
                        navController.navigate(ScreenRoute.Edit.route)}
                )

                Divider(thickness = 1.dp)
            }

        }


    }
}


package com.example.artspaceapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.data.ImageDatabase

val database: ImageDatabase = ImageDatabase()

@Composable
fun SpaceArtDisplay() {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            SpaceArtDisplayLandscape()
        }
        else -> {
            SpaceArtDisplayPortrait()
        }
    }
}

@Composable
fun SpaceArtDisplayLandscape() {
    var displayImage by remember {
        mutableStateOf(0)
    }
    Row(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .border(width = 2.dp, color = Color.DarkGray)
                .align(alignment = Alignment.CenterVertically),
            elevation = 10.dp
        ) {
            Image(
                painter = painterResource(
                    id = database.allImages[displayImage].imageResource
                ),
                contentDescription = stringResource(
                    id = database.allImages[displayImage].description
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .height(100.dp)
                    .align(alignment = Alignment.Top)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(
                        database.allImages[displayImage].description
                    ),
                    fontSize = 20.sp,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(
                        database.allImages[displayImage].author
                    )
                        .plus("(")
                        .plus(
                            stringResource(database.allImages[displayImage].date)
                                .plus(")")
                        ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterVertically
                )
                .padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (displayImage != 0) {
                        displayImage -= 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if (displayImage < 3) {
                    displayImage += 1
                }
            }, modifier = Modifier.width(120.dp)) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun SpaceArtDisplayPortrait() {
    var displayImage by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .border(width = 2.dp, color = Color.DarkGray)
                .align(alignment = Alignment.CenterHorizontally),
            elevation = 10.dp
        ) {
            Image(
                painter = painterResource(
                    id = database.allImages[displayImage].imageResource
                ),
                contentDescription = stringResource(
                    id = database.allImages[displayImage].description
                ),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(
                        database.allImages[displayImage].description
                    ),
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(
                        database.allImages[displayImage].author
                    )
                        .plus("(")
                        .plus(
                            stringResource(database.allImages[displayImage].date)
                                .plus(")")
                        ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterHorizontally
                )
                .padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (displayImage != 0) {
                        displayImage -= 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if (displayImage < 3) {
                    displayImage += 1
                }
            }, modifier = Modifier.width(120.dp)) {
                Text(text = "Next")
            }
        }
    }
}
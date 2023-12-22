package com.reus.gmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.reus.gmail.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar (scaffoldState: ScaffoldState, scope: CoroutineScope,
                openDialog:MutableState<Boolean>){
    Box(modifier = Modifier.padding(10.dp)){
        Card (modifier = Modifier.requiredHeight(50.dp), shape = RoundedCornerShape(10.dp), elevation = 6.dp){

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp) ){
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }

            }) {

                Icon(Icons.Default.Menu, contentDescription = "menu")
            }
            Text("Search for Gmail", Modifier.weight(2.0f))
            Image(painter = painterResource(id = R.drawable.tutorials) , contentDescription ="DRES",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
                    .clickable { openDialog.value = true })

                   if(openDialog.value){
                       AccountsDialog(openDialog = openDialog)
                   }


                }
        }
    }
}
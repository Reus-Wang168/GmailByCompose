package com.reus.gmail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reus.gmail.components.GmailDrawerMenu
import com.reus.gmail.components.GmailFab
import com.reus.gmail.components.HomeAppBar
import com.reus.gmail.components.HomeBottomMenu
import com.reus.gmail.components.MailList
import com.reus.gmail.ui.theme.ComposeMaterialDesignSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterialDesignSamplesTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailApp(){
    val scaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()

    val scrollState = rememberScrollState()


    val  openDialog = remember {
        mutableStateOf(false)
    }

    Scaffold(scaffoldState= scaffoldState,
        topBar = { HomeAppBar(scaffoldState,coroutineScope,openDialog)},
        drawerContent = {GmailDrawerMenu(8.dp,scrollState)},
        bottomBar = { HomeBottomMenu()},
        floatingActionButton = { GmailFab(scrollState = scrollState)}

    ) {

        MailList(it, scrollState = scrollState)
    }



}}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

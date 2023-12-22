package com.reus.gmail.components


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reus.gmail.model.MailData
import com.reus.gmail.model.mailList


@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            items(mailList) { mailData ->
                MailItem(mailData = mailData)
            }
        }
    }
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.Gray)
        ) {
            Text(text = mailData.userName[0].toString(), textAlign = TextAlign.Center,modifier= Modifier.padding(8.dp))

        }
        
        Column(modifier=Modifier.weight(2.0f)) {
            Text(
                text = mailData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mailData.body,
                fontSize = 14.sp
            )
        }
        Column {
            Text(text = mailData.timeStamp)
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                .size(50.dp)
                .padding(top = 16.dp)) {
                Icon(imageVector = Icons.Outlined.StarOutline,"") }

        }
        }

    }



@Preview
@Composable
fun MailListPreview() {
    MailItem(
        mailData = MailData(
            mailId = 4,
            userName = "Angelo",
            subject = "Email regarding job opportunity",
            body = "This is regarding a job opportunity for the profile or android developer in our organisation.",
            timeStamp = "21:10"
        )
    )
}

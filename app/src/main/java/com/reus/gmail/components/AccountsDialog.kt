package com.reus.gmail.components


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.reus.gmail.R
import com.reus.gmail.model.Account
import com.reus.gmail.model.accountList


@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false }) {
        AccountsDialogUI(openDialog=openDialog)
    }
}

@Composable
fun AccountsDialogUI(modifier: Modifier= Modifier, openDialog: MutableState<Boolean>) {
    Card {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = ""
                    )
                }
                //Todo 12: add a weight of 2.0 to make the Image fill the available space
                Image(
                    painter = painterResource(id = R.drawable.google), contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .weight(2.0f)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                //Todo 16:Add an Image with a size of 40dp, a clip with circle shape and background Gray color
                Image(
                    painter = painterResource(id = R.drawable.tutorials),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
                //Todo 17: Add a Column with weight 2.0 to fill the larger part of the parent with padding start and bottom 16dp
                Column(
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)
                ) {
                    //Todo 18: Add 2 Text to show the Username and email
                    Text(text = "Tutorials Eu", fontWeight = FontWeight.SemiBold)
                    Text(text = "tutorials@eu.com")
                }
                //Todo 19: Add a Text to show email count with a padding end of 16dp
                Text(text = "99+", modifier = Modifier.padding(end = 16.dp))
            }
            /**Todo 20: Add a Row to fill max width and
             * A Card with 150dp width, rounded corner shape and Border stroke of 1dp with gray color
             * Now we add the Text to show the Google Account, add 8dp padding and align text to center
             */
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement =
                Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
//Todo 21: Add a Spacer to help the Card stay at the required position
                Spacer(modifier = Modifier.width(10.dp))
            }
            //Todo 22: Add a line using the Divider element with a padding top of 16dp
            Divider(modifier = Modifier.padding(top = 16.dp))
            Column {
                AccountItem(account = accountList[0])
                AccountItem(account = accountList[1])
            }

            AddAccount(icon = Icons.Default.PersonAddAlt, title = "Add Another Account")
            AddAccount(
                icon = Icons.Outlined.ManageAccounts,
                title = "Manage Accounts On This Device"
            )
            //Todo 8: Add a line using a Divider
            Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
            //Todo 9: Add a Row with two Text and a Card that creates a Dot
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(3.dp),
                    shape = CircleShape,
                    backgroundColor = Color.Black
                ) {

                }
                Text(text = "Terms Of Service")
            }


        }


    }

}

@Composable
fun AddAccount(icon: ImageVector, title: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Text(text = title,fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 8.dp,start = 8.dp))
    }
}

@Composable
fun AccountItem(account: Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        if (account.icon != null) {
            Image(
                painter = painterResource(id = account.icon), contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        Color.Gray
                    )
            ) {
                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, top = 16.dp)
        ) {
            Text(text = account.userName, fontWeight = FontWeight.SemiBold)
            Text(text = account.email)
        }

        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp))


    }


}


//Todo 11 : Add a preview function for the dialog ui
@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountsDialogUiPreview() {
    AccountsDialogUI(openDialog = mutableStateOf(false))
}



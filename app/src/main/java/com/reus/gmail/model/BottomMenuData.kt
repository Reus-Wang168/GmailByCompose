package com.reus.gmail.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector? = null,
    val title: String? = null


) {
    object Mail : BottomMenuData(icon = Icons.Outlined.Mail, "Mail")
    object Meet : BottomMenuData(icon = Icons.Outlined.VideoCall, "Meet")
}

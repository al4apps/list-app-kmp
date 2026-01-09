package com.al4apps.kmp_wizard.root_list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.al4apps.kmp_wizard.root_list.RootListComponent
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun RootListScreen(component: RootListComponent) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("RootList screen", style = LAppTheme.typography.h2)
    }
}
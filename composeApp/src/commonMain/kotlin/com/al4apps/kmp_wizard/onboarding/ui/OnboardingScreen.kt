package com.al4apps.kmp_wizard.onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.onboarding.OnboardingComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun OnboardingScreen(component: OnboardingComponent) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text("ONBOARDING", style = LAppTheme.typography.h2)
            }

            ElevatedButton(
                onClick = { component.onSkipClick() },
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text("Skip")
            }
        }
    }
}

@Composable
private fun Content() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text("ONBOARDING", style = LAppTheme.typography.h2)
            }

            ElevatedButton(onClick = { }, modifier = Modifier.padding(bottom = 24.dp)) {
                Text("Skip")
            }
        }
    }
}

@Composable
@Preview
fun OnbPreview() {
    Content()
}
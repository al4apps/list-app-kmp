package com.al4apps.kmp_wizard.design_system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import org.jetbrains.compose.resources.painterResource
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LAppTopBar(
    state: TopBarUiState,
    onBackClick: () -> Unit,
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(state.title, style = LAppTheme.typography.h2) },
        navigationIcon = {
            state.navIcon?.let {
                Icon(
                    painter = painterResource(state.navIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = true,
                            onClick = { onBackClick() }
                        )
                )
            }
        },
        actions = {
            state.actionIcon?.let {
                Icon(
                    painter = painterResource(state.actionIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = true,
                            onClick = { onActionClick() }
                        )
                )
            }
        }
    )
}
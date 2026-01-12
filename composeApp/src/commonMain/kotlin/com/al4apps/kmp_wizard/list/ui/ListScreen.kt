package com.al4apps.kmp_wizard.list.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.al4apps.kmp_wizard.design_system.LAppTopBar
import com.al4apps.kmp_wizard.list.ChildListComponent
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_arrow_back
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun ListScreen(component: ChildListComponent) {

    val uiState by component.uiState.subscribeAsState()

    val topBarState = TopBarUiState(
        title = uiState.rootListTitle,
        navIcon = Res.drawable.ic_arrow_back,
        selectableWidgetState = if (uiState.isInSelectionMode) {
            SelectableWidgetState(isSelected = uiState.isAllSelected)
        } else null,
        actionIcon = null,
        isActionClickable = uiState.isInSelectionMode
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LAppTopBar(
                state = topBarState,
                onBackClick = { component.onBackClicked() },
                onActionClick = { component.onSelectAllClicked() }
            )
        }
    ) {

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("List screen", style = LAppTheme.typography.h2)
    }
}
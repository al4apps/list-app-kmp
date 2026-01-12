package com.al4apps.kmp_wizard.design_system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_arrow_back
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LAppTopBar(
    state: TopBarUiState,
    onBackClick: () -> Unit,
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                state.title,
                style = LAppTheme.typography.h2,
                color = LAppTheme.colors.text.primary
            )
        },
        navigationIcon = {
            state.navIcon?.let {
                Icon(
                    painter = painterResource(state.navIcon),
                    contentDescription = null,
                    tint = LAppTheme.colors.icon.black,
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
            Box(
                modifier = Modifier.padding(end = 16.dp).clickable(
                    interactionSource = null,
                    enabled = state.isActionClickable,
                    onClick = onActionClick,
                    indication = null
                )
            ) {
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
                state.selectableWidgetState?.let {
                    SelectableWidget(
                        isSelected = it.isSelected,
                        iconRes = it.icon
                    )
                }
            }
        }
    )
}

@Composable
@Preview
fun LAppTopBarPreview() {
    LAppTopBar(
        TopBarUiState.INITIAL.copy(
            navIcon = Res.drawable.ic_arrow_back,
            selectableWidgetState = SelectableWidgetState.INITIAL
        ),
        onBackClick = {})
}
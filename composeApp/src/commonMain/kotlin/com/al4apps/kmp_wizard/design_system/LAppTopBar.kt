package com.al4apps.kmp_wizard.design_system

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Card(
                    modifier = Modifier.size(36.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors().copy(
                        containerColor = Color.Transparent
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                enabled = true,
                                onClick = { onBackClick() }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(state.navIcon),
                            contentDescription = null,
                            tint = LAppTheme.colors.icon.black,
                            modifier = Modifier.size(24.dp).background(Color.Transparent)
                        )

                    }
                }
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
package com.al4apps.kmp_wizard.list.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.design_system.IconWidget
import com.al4apps.kmp_wizard.design_system.LAppTopBar
import com.al4apps.kmp_wizard.design_system.SelectableWidget
import com.al4apps.kmp_wizard.design_system.button.SimpleFAB
import com.al4apps.kmp_wizard.list.ChildListComponent
import com.al4apps.kmp_wizard.list.model.ChildListItemUi
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_arrow_back
import kmpwizardproject.composeapp.generated.resources.ic_check
import kmpwizardproject.composeapp.generated.resources.ic_favorite_selected
import kmpwizardproject.composeapp.generated.resources.ic_play
import kmpwizardproject.composeapp.generated.resources.ic_plus
import org.jetbrains.compose.ui.tooling.preview.Preview
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
        Box(modifier = Modifier.padding(it).fillMaxSize()) {

            AnimatedVisibility(
                visible = !uiState.isInSelectionMode,
                modifier = Modifier.align(Alignment.BottomEnd),
                enter = slideInVertically(tween(260), initialOffsetY = { y -> y })
                        + fadeIn(tween(200)),
                exit = slideOutVertically(tween(220), targetOffsetY = { y -> y })
                        + fadeOut(tween(160))
            ) {
                SimpleFAB(
                    vectorRes = Res.drawable.ic_plus,
                    modifier = Modifier
                        .padding(end = 24.dp, bottom = 24.dp)
                        .size(48.dp)
                ) { }
            }
        }
    }
}

@Composable
fun ChildListGrid(
    items: List<ChildListItemUi>,
    isInSelectionMode: Boolean,
    addNumbers: Boolean,
    onItemClicked: (Long) -> Unit,
    onItemLongClicked: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
    ) {
        items(items.size) { index ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(8.dp))
            }
            ChildListItemCard(
                item = items[index],
                position = if (addNumbers) index + 1 else null,
                isInSelectionMode = isInSelectionMode,
                onClick = onItemClicked,
                onLongClick = onItemLongClicked
            )
            if (index == items.lastIndex) {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun ChildListItemCard(
    item: ChildListItemUi,
    position: Int? = null,
    isInSelectionMode: Boolean,
    onClick: (Long) -> Unit,
    onLongClick: (Long) -> Unit = {}
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onClick(item.id) },
                onLongClick = { onLongClick(item.id) }
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            position?.let {
                Card(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .width(IntrinsicSize.Min)
                        .widthIn(min = 24.dp)
                        .heightIn(min = 24.dp),
                    shape = CircleShape,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = position.toString(), style = LAppTheme.typography.caption)
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.title, style = LAppTheme.typography.body1)
                item.comment?.let {
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = item.comment,
                        style = LAppTheme.typography.caption,
                        color = LAppTheme.colors.text.tertiary
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                if (isInSelectionMode) {
//                    SelectableWidget(item.isSelected, modifier = Modifier.size(30.dp))
                } else {
                    Box(
                        modifier = Modifier.fillMaxHeight().width(IntrinsicSize.Max),
                        contentAlignment = Alignment.Center
                    ) {
                        Card(modifier = Modifier.fillMaxHeight().fillMaxWidth().widthIn(min = 60.dp)) {}
                        Row(
                            modifier = Modifier.align(Alignment.Center).padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            item.value?.let {
                                Text(it, style = LAppTheme.typography.subtitle)
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            if (item.value != null && item.markIcon != null) {
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            item.markIcon?.let {
                                IconWidget(
                                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                                    iconRes = it,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ListScreenPreview() {
    ChildListItemCard(
        ChildListItemUi.INITIAL.copy(
            comment = "Comment sss",
            value = "+1212",
            isSelected = false,
            markIcon = Res.drawable.ic_check
//            markIcon = null
        ),
        position = 1,
        isInSelectionMode = false,
        {},
        {})
}
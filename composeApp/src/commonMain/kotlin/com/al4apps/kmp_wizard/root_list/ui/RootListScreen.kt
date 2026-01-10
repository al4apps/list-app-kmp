package com.al4apps.kmp_wizard.root_list.ui

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.design_system.LAppTopBar
import com.al4apps.kmp_wizard.design_system.SelectableWidget
import com.al4apps.kmp_wizard.design_system.button.SimpleFAB
import com.al4apps.kmp_wizard.root_list.PreviewRootListComponent
import com.al4apps.kmp_wizard.root_list.RootListComponent
import com.al4apps.kmp_wizard.root_list.model.RootListItemUiModel
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.empty_list
import kmpwizardproject.composeapp.generated.resources.ic_plus
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun RootListScreen(component: RootListComponent) {

    val uiState by component.uiState.subscribeAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LAppTopBar(
                state = uiState.topBarUiState,
                onBackClick = {},
                onActionClick = { component.onSelectAllClicked() }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 8.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (uiState.list.isEmpty() && !uiState.isLoading) {
                    EmptyRootListView()
                } else {
                    RootListGrid(
                        list = uiState.list,
                        isInSelectionMode = uiState.isInSelectionMode,
                        onClick = { id -> component.onItemClick(id) },
                        onLongClick = { id -> component.onItemLongClick(id) }
                    )
                }
            }
            SimpleFAB(
                vectorRes = Res.drawable.ic_plus,
                modifier = Modifier
                    .padding(end = 24.dp, bottom = 32.dp)
                    .size(48.dp)
            ) { }
        }
    }
}

@Composable
fun RootListGrid(
    list: List<RootListItemUiModel>,
    isInSelectionMode: Boolean,
    onClick: (Int) -> Unit,
    onLongClick: (Int) -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
    ) {
        items(list.size) { index ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(8.dp))
            }
            RootListItemCard(
                item = list[index],
                isInSelectionMode = isInSelectionMode,
                onClick = onClick,
                onLongClick = onLongClick
            )
            if (index == list.lastIndex) {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

@Composable
fun EmptyRootListView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(Res.string.empty_list),
            style = LAppTheme.typography.h2,
            color = LAppTheme.colors.text.tertiary
        )
    }
}

@Composable
fun RootListItemCard(
    item: RootListItemUiModel,
    isInSelectionMode: Boolean,
    onClick: (Int) -> Unit,
    onLongClick: (Int) -> Unit = {}
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
                .height(80.dp)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.title, style = LAppTheme.typography.subtitle)
                Spacer(Modifier.height(12.dp))
                Text(
                    text = item.date,
                    style = LAppTheme.typography.caption,
                    color = LAppTheme.colors.text.default
                )
            }

            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                if (isInSelectionMode) {
                    SelectableWidget(item.isSelected)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RootListItemCardPreview() {
    RootListScreen(PreviewRootListComponent())
}

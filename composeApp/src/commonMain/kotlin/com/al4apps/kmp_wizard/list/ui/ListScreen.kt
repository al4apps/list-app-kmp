package com.al4apps.kmp_wizard.list.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.al4apps.kmp_wizard.design_system.IconWidget
import com.al4apps.kmp_wizard.design_system.LAppTopBar
import com.al4apps.kmp_wizard.design_system.SelectableWidget
import com.al4apps.kmp_wizard.design_system.button.SimpleFAB
import com.al4apps.kmp_wizard.list.ChildListComponent
import com.al4apps.kmp_wizard.list.PreviewChildListComponent
import com.al4apps.kmp_wizard.list.model.ChildListItemUi
import com.al4apps.kmp_wizard.list.model.ExpandableFields
import com.al4apps.kmp_wizard.list.model.IconValue
import com.al4apps.kmp_wizard.list.model.ItemValue
import com.al4apps.kmp_wizard.list.model.NumberValue
import com.al4apps.kmp_wizard.list.model.TextValue
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_arrow_back
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

            ChildListGrid(
                items = uiState.items,
                isInSelectionMode = uiState.isInSelectionMode,
                addNumbers = true,
                onItemClicked = component::onItemClicked,
                onItemValueClicked = component::onItemValueClicked,
                onItemFieldClicked = component::onItemFieldClicked,
                onItemLongClicked = component::onItemLongClicked
            )

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
    onItemValueClicked: (Long) -> Unit,
    onItemFieldClicked: (Long, String) -> Unit,
    onItemLongClicked: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
    ) {
        items(items.size) { index ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(4.dp))
            }
            ChildListItemCard(
                item = items[index],
                position = if (addNumbers) index + 1 else null,
                isInSelectionMode = isInSelectionMode,
                onClick = onItemClicked,
                onValueClick = onItemValueClicked,
                onFieldClick = onItemFieldClicked,
                onLongClick = onItemLongClicked
            )
            if (index == items.lastIndex) {
                Spacer(modifier = Modifier.height(80.dp))
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
    onValueClick: (Long) -> Unit,
    onFieldClick: (Long, String) -> Unit,
    onLongClick: (Long) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val showExpandedFields =
            item.isExpandedBottom && item.expandableInfo is ExpandableFields && item.fields.isNotEmpty()

        ChildListMainCard(
            item = item,
            position = position,
            isInSelectionMode = isInSelectionMode,
            onClick = onClick,
            onValueClick = onValueClick,
            onLongClick = onLongClick
        )

        AnimatedVisibility(
            visible = showExpandedFields,
            enter = slideInVertically(tween(220), initialOffsetY = { y -> y + y}) + fadeIn(tween(200)),
            exit = slideOutVertically(tween(180), targetOffsetY = { y -> y + y }) + fadeOut(tween(140))
        ) {
            ExpandableFieldsContainer(
                item = item,
                onFieldClick = onFieldClick
            )
        }
    }
}

@Composable
private fun ChildListMainCard(
    item: ChildListItemUi,
    position: Int?,
    isInSelectionMode: Boolean,
    onClick: (Long) -> Unit,
    onValueClick: (Long) -> Unit,
    onLongClick: (Long) -> Unit
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth().zIndex(1f),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = { onClick(item.id) },
                    onLongClick = { onLongClick(item.id) },
                    indication = ripple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                )
                .height(54.dp)
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
                        modifier = Modifier.fillMaxSize().padding(6.dp),
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
                    Spacer(Modifier.height(4.dp))
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
                    SelectableWidget(item.isSelected, modifier = Modifier.size(30.dp))
                } else {
                    ItemValueBox(
                        item = item,
                        onValueClick = onValueClick
                    )
                }
            }
        }
    }
}

@Composable
private fun ItemValueBox(
    item: ChildListItemUi,
    onValueClick: (Long) -> Unit
) {
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(IntrinsicSize.Max)
            .clip(shape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                onClick = { onValueClick(item.id) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().widthIn(min = 60.dp),
            shape = shape
        ) {}
        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (item.value) {
                is TextValue -> {
                    Text(
                        item.value.text,
                        style = LAppTheme.typography.subtitle,
                        color = LAppTheme.colors.text.primary
                    )
                }

                is NumberValue -> {
                    Text(
                        item.value.getNumberString(),
                        style = LAppTheme.typography.subtitle,
                        color = LAppTheme.colors.text.primary
                    )
                }

                is IconValue -> {
                    IconWidget(
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        iconRes = item.value.icon.drawableRes,
                    )
                }
            }
        }
    }
}

@Composable
private fun ExpandableFieldsContainer(
    item: ChildListItemUi,
    onFieldClick: (Long, String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-12).dp)
            .zIndex(0f),
        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 6.dp)
        ) {
            item.fields.forEachIndexed { index, field ->
                if (index == 0) {
                    Spacer(modifier = Modifier.height(6.dp))
                }
                FieldRow(
                    itemId = item.id,
                    title = field.title,
                    value = field.value,
                    onClick = onFieldClick
                )
                if (index != item.fields.lastIndex) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(LAppTheme.colors.text.tertiary.copy(alpha = 0.2f))
                    )
                }
            }
        }
    }
}

@Composable
private fun FieldRow(
    itemId: Long,
    title: String,
    value: ItemValue,
    onClick: (Long, String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = LAppTheme.typography.body1,
                color = LAppTheme.colors.text.tertiary,
                modifier = Modifier.weight(1f)
            )
            when (value) {
                is TextValue -> {
                    Text(
                        text = value.text,
                        style = LAppTheme.typography.subtitle,
                        color = LAppTheme.colors.text.primary
                    )
                }

                is NumberValue -> {
                    Text(
                        text = value.getNumberString(),
                        style = LAppTheme.typography.subtitle,
                        color = LAppTheme.colors.text.primary
                    )
                }

                is IconValue -> {
                    IconWidget(
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        iconRes = value.icon.drawableRes,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.7f)
                .align(Alignment.CenterStart)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            LAppTheme.colors.text.tertiary.copy(alpha = 0.12f),
                            LAppTheme.colors.text.tertiary.copy(alpha = 0.0f)
                        )
                    )
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(bounded = true),
                    onClick = { onClick(itemId, title) }
                )
        )

    }
}

@Composable
@Preview
fun ListScreenPreview() {

    ListScreen(PreviewChildListComponent())
}

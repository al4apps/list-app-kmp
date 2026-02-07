package com.al4apps.kmp_wizard.list

import com.al4apps.kmp_wizard.list.model.ChildListItemUi
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.al4apps.kmp_wizard.list.model.ExpandableFields
import com.al4apps.kmp_wizard.utils.childListItemsSampleNumbers
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.collections.immutable.toImmutableList

class PreviewChildListComponent : ChildListComponent {
    override val uiState: Value<ChildListUiState> = MutableValue(
        ChildListUiState.INITIAL.copy(items = childListItemsSampleNumbers.map { item ->
            ChildListItemUi(
                id = item.id,
                title = item.title,
                value = item.mValue,
                fields = item.fields,
                isSelected = item.isSelected,
                isExpandedBottom = item.isExpandedValues,
                expandableInfo = if (item.fields.isNotEmpty()) ExpandableFields else null
            )
        }.toImmutableList())
    )

    override fun onBackClicked() {}

    override fun onSelectAllClicked() {}
    override fun onItemClicked(id: Long) {}
    override fun onItemLongClicked(id: Long) {}
    override fun onItemValueClicked(id: Long) {}
    override fun onItemFieldClicked(id: Long, fieldTitle: String) {}
}

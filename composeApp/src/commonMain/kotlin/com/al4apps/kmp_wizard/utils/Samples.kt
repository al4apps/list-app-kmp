package com.al4apps.kmp_wizard.utils

import com.al4apps.kmp_wizard.list.model.ChildListItem
import com.al4apps.kmp_wizard.list.model.IconValue
import com.al4apps.kmp_wizard.list.model.ItemMark
import com.al4apps.kmp_wizard.list.model.NumberValue
import com.al4apps.kmp_wizard.root_list.model.RootListItem
import com.al4apps.kmp_wizard.root_list.model.RootListVmState

val rootListVmStateSample = RootListVmState(
    listOf(
        RootListItem(
            11, "List 1", isSelected = false, "01.01.2026"
        ),
        RootListItem(
            1, "List 10", isSelected = false, "02.01.2026"
        ),
        RootListItem(
            2, "List 2", isSelected = false, "03.01.2026"
        ),
        RootListItem(
            3, "List 3", isSelected = false, "04.01.2026"
        ),
        RootListItem(
            4, "List 4", isSelected = false, "04.01.2026"
        ),
        RootListItem(
            5, "List 14", isSelected = false, "05.01.2026"
        ),
        RootListItem(
            6, "List 121", isSelected = false, "06.01.2026"
        ),
        RootListItem(
            7, "List 13", isSelected = false, "07.01.2026"
        ),
        RootListItem(
            8, "List 12", isSelected = false, "07.01.2026"
        ),
        RootListItem(
            9, "List 11", isSelected = false, "08.01.2026"
        ),

    ),
)

val childListItemsSampleNumbers = listOf(
    ChildListItem(0, "Item 1", isSelected = false, mValue = NumberValue(12L), comment = "Comment 1"),
    ChildListItem(1, "Item 2", isSelected = false, mValue = NumberValue(120L)),
    ChildListItem(2, "Item 3", isSelected = false, mValue = NumberValue(1200L)),
    ChildListItem(3, "Item 4", isSelected = false, mValue = NumberValue(12000L)),
    ChildListItem(4, "Item 5", isSelected = false, mValue = NumberValue(120000L)),
    ChildListItem(5, "Item 6", isSelected = false, mValue = NumberValue(1200000L)),
    ChildListItem(6, "Item 7", isSelected = false, mValue = NumberValue(12000000L)),
    ChildListItem(7, "Item 8", isSelected = false, mValue = NumberValue(120000000L)),
    ChildListItem(8, "Item 9", isSelected = false, mValue = NumberValue(1200000000L)),
    ChildListItem(9, "Item 10", isSelected = false, mValue = NumberValue(12000000000L)),
    ChildListItem(10, "Item 11", isSelected = false, mValue = NumberValue(120000000000L)),
)

val cListSampleIcons = listOf(
    ChildListItem(0, "Item 1", isSelected = false, mValue = IconValue(ItemMark.LIKE), comment = "Comment 1"),
    ChildListItem(1, "Item 2", isSelected = false, mValue = IconValue(ItemMark.BRICK)),
    ChildListItem(2, "Item 3", isSelected = false, mValue = IconValue(ItemMark.CHECKED)),
    ChildListItem(3, "Item 4", isSelected = false, mValue = IconValue(ItemMark.LIKE)),
    ChildListItem(4, "Item 5", isSelected = false, mValue = IconValue(ItemMark.LIKE)),
    ChildListItem(5, "Item 6", isSelected = false, mValue = IconValue(ItemMark.CHECKED)),
    ChildListItem(6, "Item 7", isSelected = false, mValue = IconValue(ItemMark.NONE)),
    ChildListItem(7, "Item 8", isSelected = false, mValue = IconValue(ItemMark.CHECKED)),
    ChildListItem(8, "Item 9", isSelected = false, mValue = IconValue(ItemMark.LIKE)),
    ChildListItem(9, "Item 10", isSelected = false, mValue = IconValue(ItemMark.STAR)),
    ChildListItem(10, "Item 11", isSelected = false, mValue = IconValue(ItemMark.CHECKED)),
)
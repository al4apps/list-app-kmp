package com.al4apps.kmp_wizard.utils

import com.al4apps.kmp_wizard.list.model.ChildListItem
import com.al4apps.kmp_wizard.list.model.ItemValue
import com.al4apps.kmp_wizard.list.model.NumberValue
import com.al4apps.kmp_wizard.root_list.model.RootListItem
import com.al4apps.kmp_wizard.root_list.model.RootListVmState

val rootListVmStateSample = RootListVmState(
    listOf(
        RootListItem(
            11, "List 1", isSelected = true, "01.01.2026"
        ),
        RootListItem(
            1, "List 10", isSelected = false, "02.01.2026"
        ),
        RootListItem(
            2, "List 2", isSelected = false, "03.01.2026"
        ),
        RootListItem(
            3, "List 3", isSelected = true, "04.01.2026"
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

val childListItemsSample = listOf(
    ChildListItem(0, "Item 1", isSelected = false, value = NumberValue(12.0), comment = "Comment 1"),
    ChildListItem(1, "Item 2", isSelected = false, value = NumberValue(120.0)),
    ChildListItem(2, "Item 3", isSelected = false, value = NumberValue(1200.0)),
    ChildListItem(3, "Item 4", isSelected = false, value = NumberValue(12000.0)),
    ChildListItem(4, "Item 5", isSelected = false, value = NumberValue(120000.0)),
    ChildListItem(5, "Item 6", isSelected = false, value = NumberValue(1200000.0)),
    ChildListItem(6, "Item 7", isSelected = false, value = NumberValue(12000000.0)),
    ChildListItem(7, "Item 8", isSelected = false, value = NumberValue(120000000.0)),
    ChildListItem(8, "Item 9", isSelected = false, value = NumberValue(1200000000.0)),
    ChildListItem(9, "Item 10", isSelected = false, value = NumberValue(12000000000.0)),
    ChildListItem(10, "Item 11", isSelected = false, value = NumberValue(120000000000.0)),
)
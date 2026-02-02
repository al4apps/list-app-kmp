package com.al4apps.kmp_wizard.root_list.model

import com.al4apps.kmp_wizard.utils.rootListVmStateSample
import kotlinx.serialization.Serializable

@Serializable
data class RootListVmState(
    val list: List<RootListItem>,
    val isInSelectionMode: Boolean
) {

    companion object {
        val INITIAL = RootListVmState(
            list = emptyList(),
            isInSelectionMode = false
        )
        val SAMPLE = rootListVmStateSample
    }
}

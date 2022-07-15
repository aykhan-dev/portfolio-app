package ev.aykhn.portfolio.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import ev.aykhn.portfolio.presentation.sections.KeepInTouchSection

@Composable
fun SectionalScreen(content: LazyListScope.() -> Unit) {
    LazyColumn {
        content()
        item { KeepInTouchSection() }
    }
}
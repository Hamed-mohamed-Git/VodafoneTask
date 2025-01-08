package com.vodafone.task.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vodafone.task.core.designSystem.theme.VodafoneTaskTheme
import com.vodafone.task.core.designSystem.theme.applyScreenSpaces


@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .applyScreenSpaces()
        .verticalScroll(rememberScrollState())
) = Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    CircularProgressIndicator()
}

@Preview
@Composable
private fun Preview() {
    VodafoneTaskTheme {
        LoadingScreen()
    }
}
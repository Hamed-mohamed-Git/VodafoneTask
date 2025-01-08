package com.vodafone.task.core.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vodafone.task.core.designSystem.components.buttons.VTButton
import com.vodafone.task.core.designSystem.theme.VodafoneTaskTheme
import com.vodafone.task.core.designSystem.theme.applyScreenSpaces
import com.vodafone.task.core.ui.R

@Composable
@SuppressLint("ModifierParameter")
fun ErrorScreen(
    text: String,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .applyScreenSpaces()
        .verticalScroll(rememberScrollState()),
    onRetryClick: () -> Unit
) = Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.background,
        style = MaterialTheme.typography.bodyLarge
    )

    Spacer(modifier = Modifier.height(40.dp))

    VTButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onRetryClick
    ) {
        Text(stringResource(R.string.core_ui_action_retry))
    }
}

@Preview
@Composable
private fun Preview() {
    VodafoneTaskTheme {
        ErrorScreen(
            text = "Unexpected error occurred please try again later",
            onRetryClick = {}
        )
    }
}
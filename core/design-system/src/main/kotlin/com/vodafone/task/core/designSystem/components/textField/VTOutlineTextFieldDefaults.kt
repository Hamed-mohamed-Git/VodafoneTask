package com.vodafone.task.core.designSystem.components.textField

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import com.vodafone.task.core.designSystem.theme.LocalCornerRadius
import com.vodafone.task.core.designSystem.theme.LocalSmallSpaces
import com.vodafone.task.core.designSystem.theme.Error600
import com.vodafone.task.core.designSystem.theme.Gray700
import com.vodafone.task.core.designSystem.theme.LocalSizes

object OFOutlinedTextFieldDefaults {
    private var cachedColors: TextFieldColors? = null

    val shape: Shape
        @Composable get() = RoundedCornerShape(0)

    val defaultMinHeight
        @Composable get() = LocalSizes.current.large

    val defaultSpaceBy
        @SuppressLint("VisibleForTests") @Composable get() = LocalSmallSpaces.current.small

    val defaultHorizontalPadding
        @SuppressLint("VisibleForTests") @Composable get() = LocalSmallSpaces.current.medium

    val textStyle
        @Composable get() = MaterialTheme.typography.labelMedium.merge(fontWeight = FontWeight.W500)

    val labelTextStyle
        @Composable get() = MaterialTheme.typography.bodyMedium.merge(fontWeight = FontWeight.W500)


    @Composable
    fun colors(
        focusedTextColor: Color = Color.Unspecified,
        unfocusedTextColor: Color = Color.Unspecified,
        disabledTextColor: Color = Color.Unspecified,
        errorTextColor: Color = Color.Unspecified,
        focusedContainerColor: Color = Color.Unspecified,
        unfocusedContainerColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        errorContainerColor: Color = Color.Unspecified,
        cursorColor: Color = LocalContentColor.current,
        errorCursorColor: Color = Color.Unspecified,
        selectionColors: TextSelectionColors? = null,
        focusedBorderColor: Color = Color.Unspecified,
        unfocusedBorderColor: Color = Color.Unspecified,
        disabledBorderColor: Color = Color.Unspecified,
        errorBorderColor: Color = Color.Unspecified,
        focusedLeadingIconColor: Color = Color.Unspecified,
        unfocusedLeadingIconColor: Color = Color.Unspecified,
        disabledLeadingIconColor: Color = Color.Unspecified,
        errorLeadingIconColor: Color = Color.Unspecified,
        focusedTrailingIconColor: Color = Color.Unspecified,
        unfocusedTrailingIconColor: Color = Color.Unspecified,
        disabledTrailingIconColor: Color = Color.Unspecified,
        errorTrailingIconColor: Color = Color.Red,
        focusedLabelColor: Color = Color.Unspecified,
        unfocusedLabelColor: Color = Color.Unspecified,
        disabledLabelColor: Color = Color.Unspecified,
        errorLabelColor: Color = Color.Unspecified,
        focusedPlaceholderColor: Color = Color.Unspecified,
        unfocusedPlaceholderColor: Color = Color.Unspecified,
        disabledPlaceholderColor: Color = Color.Unspecified,
        errorPlaceholderColor: Color = Color.Unspecified,
        focusedSupportingTextColor: Color = Color.Unspecified,
        unfocusedSupportingTextColor: Color = Color.Unspecified,
        disabledSupportingTextColor: Color = Color.Unspecified,
        errorSupportingTextColor: Color = Color.Unspecified,
        focusedPrefixColor: Color = Color.Unspecified,
        unfocusedPrefixColor: Color = Color.Unspecified,
        disabledPrefixColor: Color = Color.Unspecified,
        errorPrefixColor: Color = Color.Unspecified,
        focusedSuffixColor: Color = Color.Unspecified,
        unfocusedSuffixColor: Color = Color.Unspecified,
        disabledSuffixColor: Color = Color.Unspecified,
        errorSuffixColor: Color = Color.Unspecified,
    ) = defaultColors.copy(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        textSelectionColors = selectionColors,
        focusedIndicatorColor = focusedBorderColor,
        unfocusedIndicatorColor = unfocusedBorderColor,
        disabledIndicatorColor = disabledBorderColor,
        errorIndicatorColor = errorBorderColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor
    )

    @Composable
    fun colors() = defaultColors

    private val defaultColors
        @Composable
        get() = cachedColors ?: OutlinedTextFieldDefaults.colors(
            focusedTextColor = Gray700,
            unfocusedTextColor = Gray700,
            disabledTextColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface,
            cursorColor = MaterialTheme.colorScheme.primary,
            errorTrailingIconColor =  MaterialTheme.colorScheme.error,
            focusedLabelColor = Gray700,
            disabledLabelColor = MaterialTheme.colorScheme.onSurface,
            errorSupportingTextColor = Error600,
            errorTextColor = Gray700,
            errorBorderColor = MaterialTheme.colorScheme.error,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
        ).also { cachedColors = it }
}
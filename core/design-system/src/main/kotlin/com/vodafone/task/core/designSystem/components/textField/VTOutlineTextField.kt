package com.vodafone.task.core.designSystem.components.textField

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vodafone.task.core.designSystem.theme.VodafoneTaskTheme

enum class OFFieldStatus { ERROR, NONE, VALID }

@Composable
fun VTOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    fieldStatus: OFFieldStatus = OFFieldStatus.NONE,
    textStyle: TextStyle = OFOutlinedTextFieldDefaults.textStyle,
    labelTextStyle: TextStyle = OFOutlinedTextFieldDefaults.labelTextStyle,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = fieldStatus == OFFieldStatus.ERROR,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    spaceBy: Dp = OFOutlinedTextFieldDefaults.defaultSpaceBy,
    shape: Shape = OFOutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OFOutlinedTextFieldDefaults.colors(),
) {

    val focused by interactionSource.collectIsFocusedAsState()


    val labelContentColor = when {
        !enabled -> colors.disabledLabelColor
        else -> colors.focusedLabelColor
    }


    val valueTextColor =
        textStyle.color.takeOrElse {
            when {
                !enabled -> colors.disabledTextColor
                isError -> colors.errorTextColor
                focused -> colors.focusedTextColor
                else -> colors.unfocusedTextColor
            }
        }

    val valueTextStyle = textStyle.merge(color = valueTextColor)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spaceBy)
    ) {

        LabelDecoration(
            labelContentColor = labelContentColor,
            textStyle = labelTextStyle,
            label = label
        )

        CompositionLocalProvider(LocalTextSelectionColors provides colors.textSelectionColors) {
            BasicTextField(
                value = value,
                modifier = modifier
                    .defaultMinSize(
                        minWidth = OutlinedTextFieldDefaults.MinWidth,
                        minHeight = OFOutlinedTextFieldDefaults.defaultMinHeight
                    ),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                textStyle = valueTextStyle,
                cursorBrush = SolidColor(if (isError) colors.errorCursorColor else colors.cursorColor),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                decorationBox = @Composable { innerTextField ->
                    CompositionLocalProvider(LocalTextStyle provides textStyle) {
                        OFDecorationBox(
                            value = value,
                            modifier = modifier,
                            enabled = enabled,
                            isError = isError,
                            focused = focused,
                            innerTextField = innerTextField,
                            placeholder = placeholder,
                            leadingIcon = leadingIcon,
                            trailingIcon = trailingIcon,
                            prefix = prefix,
                            suffix = suffix,
                            valueTextColor = valueTextColor,
                            shape = shape,
                            colors = colors
                        )
                    }
                }
            )
        }

        SupportingTextDecoration(
            supportingText = supportingText,
            enabled = enabled,
            fieldStatus = fieldStatus,
            colors = colors,
            textStyle = textStyle
        )
    }
}

@Composable
private fun LabelDecoration(
    labelContentColor: Color,
    textStyle: TextStyle,
    label: @Composable (() -> Unit)? = null
) = label?.let {
    CompositionLocalProvider(
        LocalContentColor provides labelContentColor,
        LocalTextStyle provides textStyle
    ) { it() }
}

@Composable
private fun OFDecorationBox(
    value: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    focused: Boolean = false,
    innerTextField: @Composable () -> Unit = {},
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    valueTextColor: Color = Color.Unspecified,
    shape: Shape = OFOutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OFOutlinedTextFieldDefaults.colors()
) {
    val placeholderContentColor = when {
        !enabled -> colors.disabledPlaceholderColor
        isError -> colors.errorPlaceholderColor
        focused -> colors.focusedPlaceholderColor
        else -> colors.unfocusedPlaceholderColor
    }

    val prefixContentColor = when {
        !enabled -> colors.disabledPrefixColor
        isError -> colors.errorPrefixColor
        focused -> colors.focusedPrefixColor
        else -> colors.unfocusedPrefixColor
    }

    val suffixContentColor = when {
        !enabled -> colors.disabledSuffixColor
        isError -> colors.errorSuffixColor
        focused -> colors.focusedSuffixColor
        else -> colors.unfocusedSuffixColor
    }

    val leadingIconColor = when {
        !enabled -> colors.disabledLeadingIconColor
        isError -> colors.errorLeadingIconColor
        focused -> colors.focusedLeadingIconColor
        else -> colors.unfocusedLeadingIconColor
    }

    val trailingIconColor = when {
        !enabled -> colors.disabledTrailingIconColor
        isError -> colors.errorTrailingIconColor
        focused -> colors.focusedTrailingIconColor
        else -> colors.unfocusedTrailingIconColor
    }

    val borderColor = when {
        isError -> colors.errorIndicatorColor
        focused -> colors.focusedIndicatorColor
        else -> colors.unfocusedIndicatorColor
    }


    Row(
        modifier = Modifier
            .border(1.dp, borderColor, shape)
            .defaultMinSize(
                minWidth = OutlinedTextFieldDefaults.MinWidth,
                minHeight = OFOutlinedTextFieldDefaults.defaultMinHeight
            )
            .fillMaxWidth()
            .padding(horizontal = OFOutlinedTextFieldDefaults.defaultHorizontalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(LocalContentColor provides leadingIconColor) {
            leadingIcon?.invoke()
        }

        CompositionLocalProvider(LocalContentColor provides prefixContentColor) {
            prefix?.invoke()
        }

        Box(modifier.weight(1f)) {
            if (value.isEmpty())
                placeholder?.let {
                    CompositionLocalProvider(LocalContentColor provides placeholderContentColor) {
                        it()
                    }
                }


            CompositionLocalProvider(LocalContentColor provides valueTextColor) {
                innerTextField()
            }
        }
        CompositionLocalProvider(LocalContentColor provides suffixContentColor) {
            suffix?.invoke()
        }

        CompositionLocalProvider(LocalContentColor provides trailingIconColor) {
            trailingIcon?.invoke()
        }
    }
}

@Composable
fun SupportingTextDecoration(
    supportingText: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    fieldStatus: OFFieldStatus = OFFieldStatus.NONE,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    textStyle: TextStyle = OFOutlinedTextFieldDefaults.textStyle,
) {
    if (enabled)
        supportingText?.let {

            val contentColor = when (fieldStatus) {
                OFFieldStatus.ERROR -> colors.errorSupportingTextColor
                OFFieldStatus.NONE -> colors.disabledLabelColor
                else -> colors.unfocusedSupportingTextColor
            }

            CompositionLocalProvider(
                LocalTextStyle provides textStyle,
                LocalContentColor provides contentColor
            ) { it() }
        }
}

@Preview(showBackground = true)
@Composable
fun VTOutlineTextFieldPreview() {
    VodafoneTaskTheme {
        var value by remember{ mutableStateOf("01143166888") }
        VTOutlineTextField(
            enabled = true,
            modifier = Modifier.padding(),
            value = value,
            onValueChange = { value = it },
            fieldStatus = OFFieldStatus.ERROR,
            label = { Text(text = "Enter your City")},
            placeholder = { Text("Enter Your city") },
            supportingText = { Text(text = "Error") },
        )
    }
}
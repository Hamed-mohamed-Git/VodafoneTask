package com.vodafone.task.core.designSystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.vodafone.task.core.designSystem.R
import org.jetbrains.annotations.VisibleForTesting

//For Loading GMS Fonts provider
private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

//Create Inter Font Family
private val fontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        fontProvider = provider,
    )
)

// FontFamily Display
private val DisplayLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 72.sp,
    lineHeight = 90.sp
)

private val DisplayMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 45.sp,
    lineHeight = 52.sp,
    letterSpacing = 0.sp
)

private val DisplaySmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 36.sp,
    lineHeight = 44.sp,
    letterSpacing = 0.sp
)

// FontFamily Headline
private val HeadlineLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 32.sp,
    lineHeight = 40.sp
)

private val HeadlineMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.sp
)

private val HeadlineSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.sp
)

// FontFamily Title
private val TitleLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 22.sp,
    lineHeight = 32.sp
)

private val TitleMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

private val TitleSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

// FontFamily Body
private val BodyLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

private val BodyMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.sp
)

private val BodySmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.sp
)

// FontFamily Body
private val LabelLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

private val LabelMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    letterSpacing = 0.sp
)

private val LabelSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.sp
)

@VisibleForTesting
internal val VTTypography = Typography(
    // Display Styles
    displayLarge = DisplayLarge, // Used for largest display text
    displayMedium = DisplayMedium, // Used for secondary display text
    displaySmall = DisplaySmall, // Used for smallest display text

    // Headline Styles
    headlineLarge = HeadlineLarge, // Used for largest headlines, typically important text
    headlineMedium = HeadlineMedium, // Used for medium-sized headlines
    headlineSmall = HeadlineSmall, // Used for smallest headlines

    // Title Styles
    titleLarge = TitleLarge, // Used for large titles, medium-emphasis text
    titleMedium = TitleMedium, // Used for medium titles
    titleSmall = TitleSmall, // Used for small titles

    // Body Styles
    bodyLarge = BodyLarge, // Used for large body text in long-form writing
    bodyMedium = BodyMedium, // Used for medium body text
    bodySmall = BodySmall, // Used for small body text

    // Label Styles
    labelLarge = LabelLarge, // Used for call-to-action buttons and tabs
    labelMedium = LabelMedium, // Used for medium labels, annotations
    labelSmall = LabelSmall // Used for small labels, annotations
)

package com.csis4175.bookcycles.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.csis4175.bookcycles.R


val Kanit = FontFamily(
    Font(R.font.kanit_regular, FontWeight.Normal),
    Font(R.font.kanit_light, FontWeight.Light),
    Font(R.font.kanit_light, FontWeight.Thin),
    Font(R.font.kanit_extra_light, FontWeight.ExtraLight),
    Font(R.font.kanit_semi_bold, FontWeight.SemiBold),
//    Font(R.font.kanit_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle( // Login Screen -> Main Title
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle( // BookListItem -> Title Text, BookPreview -> Title Text
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
    ),
    headlineSmall = TextStyle( // BookListItem -> Author Text, BookPreview -> Author Text, VisitorItem -> Name
        fontFamily = Kanit,
        fontWeight = FontWeight.Thin,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
    ),
    titleLarge = TextStyle( // TopAppBar -> Title Text
        fontFamily = Kanit,
        fontWeight = FontWeight.Light,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle( // Visitors Screen -> Scheduled Visitors Label
        fontFamily = Kanit,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
    ),
    bodyLarge = TextStyle( // GetThisBook -> Availability Text
        fontFamily = Kanit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp
    ),
    bodyMedium = TextStyle( // InputText->Inner Text
        fontFamily = Kanit,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle( // BookPreview -> Description, VisitorItem -> Telephone, VisitAt
        fontFamily = Kanit,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle( // InputButton->Inner Text
        fontFamily = Kanit,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),
    labelSmall = TextStyle( // InputText->Label Text
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),


    /* Other default text styles to override
        titleLarge = TextStyle(
            fontFamily = Kanit,
            fontWeight = FontWeight.Light,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        labelSmall = TextStyle(
            fontFamily = Kanit,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    */
)
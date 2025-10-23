package io.vallab.movies.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Blue01 = Color(0xFF5180FF)
val Blue01_A30 = Color(0x4D5180FF)
val Blue02 = Color(0xFF215BF6)

val Purple01 = Color(0xFFB469FF)
val Purple01_A30 = Color(0x4DB469FF)

val White = Color(0xFFFFFFFF)
val PaleGray = Color(0xFFF9F9F9)
val LightGray = Color(0xFFDCDCDC)
val DarkGray = Color(0xFF5E5E5E)
val DustGray = Color(0xFF868686)
val Gray_4D = Color(0xFF4D4D4D)
val NeutralGray = Color(0xFFF1F1F1)
val Black = Color(0xFF000000)
val Graphite = Color(0xFF292929)

/**
 * DroidKnights Color Scheme 참고
 * 앱의 특성에 따라 각 요소들을 추가 및 제거 하여 사용
 * https://github.com/droidknights/DroidKnightsApp/blob/2025%2Fcompose-multiplatform/core/designsystem/src/commonMain/kotlin/com/droidknights/app/core/designsystem/theme/Color.kt
 *
 * primary              앱의 주요 브랜드 색상, 강조 컬러
 * onPrimary            primary 위에 올 텍스트/아이콘 색상
 * background           전체 화면 기본 배경색
 * onBackground         background 위의 텍스트 색상
 * surface              카드, 다이얼로그, 바텀시트 등의 표면색
 * onSurface            surface 위의 텍스트/아이콘 색상
 * primarySurface       주 테마 요소가 올라가는 표면
 * onPrimarySurface     primarySurface 위의 텍스트
 * secondarySurface     보조적인 컨텐츠용 배경
 * onSecondarySurface   secondarySurface 위 텍스트
 * accentSurface        포인트가 되는 액션용 배경
 * onAccentSurface      accentSurface 위 텍스트
 * neutralSurface       중립적인 배경색
 * onNeutralSurface     neutralSurface 위 텍스트
 * borderColor          테두리 색상
 * selectedIconColor    선택된 아이콘 색
 * unselectedIconColor  비선택 아이콘 색
 * darkSurface          어두운 테마용 표면색
 * onDarkSurface        darkSurface 위 텍스트
 * lightSurface         밝은 테마용 표면색
 * onLightSurface       lightSurface 위 텍스트
 * iconBackground       아이콘이 올라가는 배경색
 * placeholderColor     입력창 등의 플레이스홀더 텍스트 색
 * trailingIconColor    입력창 오른쪽 아이콘 색
 * editButtonColor      편집용 버튼 색
 * selectedCardColor    선택된 카드나 항목 색
 */
@Immutable
data class VallabColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val primarySurface: Color,
    val onPrimarySurface: Color,
    val secondarySurface: Color,
    val onSecondarySurface: Color,
    val accentSurface: Color,
    val onAccentSurface: Color,
    val neutralSurface: Color,
    val onNeutralSurface: Color,
    val borderColor: Color,
    val selectedIconColor: Color,
    val unselectedIconColor: Color,
    val darkSurface: Color = Graphite,
    val onDarkSurface: Color = White,
    val lightSurface: Color = White,
    val onLightSurface: Color = Black,
    val iconBackground: Color,
    val placeholderColor: Color,
    val trailingIconColor: Color,
    val editButtonColor: Color,
    val selectedCardColor: Color,
) {
    companion object {
        val lightColorScheme = VallabColorScheme(
            primary = Blue02,
            onPrimary = White,
            background = PaleGray,
            onBackground = Black,
            surface = White,
            onSurface = Black,
            primarySurface = Blue02,
            onPrimarySurface = White,
            secondarySurface = Blue01_A30,
            onSecondarySurface = Blue01,
            accentSurface = Purple01_A30,
            onAccentSurface = Purple01,
            neutralSurface = DarkGray,
            onNeutralSurface = LightGray,
            borderColor = LightGray,
            selectedIconColor = Blue02,
            unselectedIconColor = LightGray,
            iconBackground = NeutralGray,
            placeholderColor = LightGray,
            trailingIconColor = DarkGray,
            editButtonColor = DustGray,
            selectedCardColor = LightGray,
        )

        val darkColorScheme = VallabColorScheme(
            primary = Blue01,
            onPrimary = White,
            background = Black,
            onBackground = White,
            surface = Graphite,
            onSurface = White,
            primarySurface = Blue02,
            onPrimarySurface = White,
            secondarySurface = Blue01_A30,
            onSecondarySurface = White,
            accentSurface = Purple01_A30,
            onAccentSurface = Purple01,
            neutralSurface = DarkGray,
            onNeutralSurface = LightGray,
            borderColor = DarkGray,
            selectedIconColor = Blue01,
            unselectedIconColor = DarkGray,
            iconBackground = Graphite,
            placeholderColor = DarkGray,
            trailingIconColor = White,
            editButtonColor = White,
            selectedCardColor = Gray_4D,
        )
    }
}


val LocalColorScheme = staticCompositionLocalOf { VallabColorScheme.lightColorScheme }

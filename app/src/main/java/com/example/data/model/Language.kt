package com.example.data.model

import java.util.Locale

enum class Language(
    val code: String,
    val isoTag: String,
    val displayNameUz: String,
    val displayNameRu: String,
    val displayNameEn: String,
    val displayNameZh: String,
    val flag: String,
    val locale: Locale
) {
    UZ(
        code = "uz",
        isoTag = "UZ",
        displayNameUz = "O'zbek",
        displayNameRu = "Узбекский",
        displayNameEn = "Uzbek",
        displayNameZh = "乌兹别克语",
        flag = "UZ",
        locale = Locale.forLanguageTag("uz")
    ),
    RU(
        code = "ru",
        isoTag = "RU",
        displayNameUz = "Rus",
        displayNameRu = "Русский",
        displayNameEn = "Russian",
        displayNameZh = "俄语",
        flag = "RU",
        locale = Locale.forLanguageTag("ru-RU")
    ),
    EN(
        code = "en",
        isoTag = "EN",
        displayNameUz = "Ingliz",
        displayNameRu = "Английский",
        displayNameEn = "English",
        displayNameZh = "英语",
        flag = "EN",
        locale = Locale.US
    ),
    ZH(
        code = "zh",
        isoTag = "ZH",
        displayNameUz = "Xitoy (中文)",
        displayNameRu = "Китайский (中文)",
        displayNameEn = "Chinese",
        displayNameZh = "中文",
        flag = "ZH",
        locale = Locale.SIMPLIFIED_CHINESE
    );

    fun getDisplayName(targetLocaleCode: String = "uz"): String {
        return when (targetLocaleCode.lowercase()) {
            "ru" -> displayNameRu
            "en" -> displayNameEn
            "zh" -> displayNameZh
            else -> displayNameUz
        }
    }

    companion object {
        fun fromCode(code: String): Language {
            return entries.find { it.code.equals(code, ignoreCase = true) } ?: EN
        }
    }
}

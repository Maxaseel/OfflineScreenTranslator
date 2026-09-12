package com.example.data.manager

import android.content.Context
import com.example.data.model.Language
import com.example.engine.OfflineVocabulary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

enum class ModelDownloadStatus { NOT_DOWNLOADED, DOWNLOADING, DOWNLOADED, FAILED }

data class OfflineModelInfo(
    val language: Language,
    val title: String,
    val description: String,
    val version: String,
    val totalSizeBytes: Long,
    val sizeFormatted: String,
    val status: ModelDownloadStatus,
    val progress: Float = 1f,
    val downloadedBytes: Long = totalSizeBytes,
    val localFilePath: String? = "APK-bundled"
)

/**
 * There are no network downloads in the zero-cost edition.
 * The translation dictionary/rules are bundled with the application.
 * ML Kit OCR models are handled by the on-device ML Kit runtime.
 */
class OfflineModelDownloadManager private constructor(context: Context) {
    private val _modelsState = MutableStateFlow(
        Language.entries.associateWith { lang ->
            OfflineModelInfo(
                language = lang,
                title = "${lang.name} offline language pack",
                description = "Bundled dictionary, phrase rules and morphology engine",
                version = "1.0-bundled",
                totalSizeBytes = 0L,
                sizeFormatted = "APK ichida",
                status = ModelDownloadStatus.DOWNLOADED,
                progress = 1f,
                downloadedBytes = 0L,
                localFilePath = "APK-bundled"
            )
        }
    )
    val modelsState: StateFlow<Map<Language, OfflineModelInfo>> = _modelsState.asStateFlow()

    fun startDownload(language: Language) {
        // Intentionally a no-op: nothing is downloaded.
        _modelsState.value = _modelsState.value.toMutableMap().apply {
            this[language] = this[language]!!.copy(status = ModelDownloadStatus.DOWNLOADED, progress = 1f)
        }
    }

    fun cancelDownload(language: Language) = startDownload(language)
    fun deleteModel(language: Language) = startDownload(language)
    fun isModelReady(language: Language) = true
    fun getTotalStorageUsedFormatted(): String = "APK ichida"

    companion object {
        @Volatile private var instance: OfflineModelDownloadManager? = null
        fun getInstance(context: Context): OfflineModelDownloadManager =
            instance ?: synchronized(this) {
                instance ?: OfflineModelDownloadManager(context.applicationContext).also { instance = it }
            }
    }
}

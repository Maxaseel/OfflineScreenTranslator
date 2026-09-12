# APK chiqarish — GitHub Actions

1. GitHub'da yangi repository yarating.
2. ZIP ichidagi barcha fayllarni repository root'iga yuklang.
3. `.github/workflows/android-apk.yml` fayli saqlanganini tekshiring.
4. GitHub: **Actions → Build Android APK → Run workflow**.
5. Build tugagach: **Artifacts → OfflineScreenTranslator-APKs**.

`OfflineScreenTranslator-debug.apk` — test uchun.
`OfflineScreenTranslator-release-unsigned.apk` — release build, signing kerak.

Workflow Android SDK 36, Build Tools 36.0.0 va JDK 17ni GitHub runner'ida o'rnatadi. Tarjima loyihasi cloud/API-key talab qilmaydi.

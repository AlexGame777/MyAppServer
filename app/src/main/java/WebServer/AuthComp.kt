package WebServer

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

object authComp {
    val url = "http://10.0.2.2:3000/auth-comp" // Адрес вашего сервера
    private val client = OkHttpClient()
    fun authc(comp_e: String, comp_p: String): Response {
        val json = """
            {
                "comp_e": "$comp_e",
                "password_comp": "$comp_p"
            }
        """.trimIndent()

        val requestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        return client.newCall(request).execute()

    }
}
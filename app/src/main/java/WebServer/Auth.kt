package WebServer

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

object Auth {
    val url = "http://10.0.2.2:3000/auth" // Адрес вашего сервера
    private val client = OkHttpClient()
    fun auth(login: String, pas: String): Response {
        val json = """
            {
                "login": "$login",
                "pas": "$pas"
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

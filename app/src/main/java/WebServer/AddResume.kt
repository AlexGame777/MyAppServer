package WebServer

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

object AddResume {
    val url = "http://10.0.2.2:3000/add-Resume" // Адрес вашего сервера
    private val client = OkHttpClient()
    fun sendData(name: String, position: String, exp: String, onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val json = """
            {
                "name": "$name",
                "position": "$position",
                "exp": "$exp"
            }
        """.trimIndent()

        val requestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val responseData = response.body?.string()
                onSuccess(responseData?: "")
            }
        })
    }
}
package WebServer

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

object RegC {
    val url = "http://10.0.2.2:3000/add-data-comp" // Адрес вашего сервера
    private val client = OkHttpClient()
    fun sendData(comp_t: String, comp_n: String, comp_e: String, comp_pers: String, comp_pas: String, onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val json = """
            {
                "comp_t": "$comp_t",
                "comp_n": "$comp_n",
                "comp_e": "$comp_e",
                "comp_pers": "$comp_pers",
                "comp_pas": "$comp_pas"
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
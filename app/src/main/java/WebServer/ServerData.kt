package WebServer
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Callback
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

object ServerData {
    val url = "http://10.0.2.2:3000/add-data" // Адрес вашего сервера
    private val client = OkHttpClient()
    fun sendData(f_name: String, l_name: String, login: String, pas:String, onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val json = """
            {
                "f_name": "$f_name",
                "l_name": "$l_name",
                "login": "$login",
                "pas": "$pas"
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
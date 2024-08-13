package WebServer

import com.example.myappserver.models.Vacancy
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.lang.reflect.Type

object VacanciesApi {
    private const val BASE_URL = "http://localhost:3000"

    private val client = OkHttpClient()
    private val gson = Gson()

    fun fetchVacancies(): List<Vacancy> {
        val request = Request.Builder()
            .url("http://10.0.2.2:3000/vacancies")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val json = response.body!!.string()
            val listType: Type = object : TypeToken<List<Vacancy>>() {}.type
            return gson.fromJson(json, listType)
        }
    }
}
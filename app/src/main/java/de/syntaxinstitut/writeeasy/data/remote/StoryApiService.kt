package de.syntaxinstitut.writeeasy.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntaxinstitut.writeeasy.data.model.Story
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://public.syntax-institut.de/apps/batch2/JenkmanShahin/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StoryApiService{

    @GET("data.json")
    suspend fun getStories(): List<Story>
}

object StoryApi {
    val retrofitService: StoryApiService by lazy { retrofit.create(StoryApiService::class.java) }
}

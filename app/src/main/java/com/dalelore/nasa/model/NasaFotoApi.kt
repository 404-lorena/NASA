package com.dalelore.nasa.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NasaFotoApi {
    val copyright: String = "",
    val date: String,
    val explanation: String,
    @SerialName("hdurl"),
    val imageUrl: String,
    val media_type: String,
    @SerialName("service_version")
    val serviceVersion: String,
    val url: String,
}
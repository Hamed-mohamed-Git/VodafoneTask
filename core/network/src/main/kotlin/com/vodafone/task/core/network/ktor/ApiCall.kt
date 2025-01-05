package com.vodafone.task.core.network.ktor

import com.vodafone.task.core.common.Resource
import com.vodafone.task.core.model.VodafoneTaskException
import com.vodafone.task.core.network.model.VodafoneTaskErrorResponse
import com.vodafone.task.core.network.model.asExternalModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

internal suspend inline fun <reified D> HttpClient.apiCall(block: HttpClient.() -> HttpResponse): Resource<D, VodafoneTaskException> =
    try {
        val response = block()
        when {
            response.status.isSuccess() -> Resource.success(response.body<D>())
            else -> Resource.expectedFailure(response.body<VodafoneTaskErrorResponse>().asExternalModel)
        }
    } catch (e: Throwable) {
        Resource.unexpectedFailure(e)
    }

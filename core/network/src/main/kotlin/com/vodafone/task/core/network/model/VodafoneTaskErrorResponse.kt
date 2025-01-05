package com.vodafone.task.core.network.model

import com.vodafone.task.core.model.VodafoneTaskException
import kotlinx.serialization.Serializable

@Serializable
internal class VodafoneTaskErrorResponse(
    val code: Long? = null,
    val message: String? = null,
)

internal val VodafoneTaskErrorResponse.asExternalModel get() = VodafoneTaskException(message, null)
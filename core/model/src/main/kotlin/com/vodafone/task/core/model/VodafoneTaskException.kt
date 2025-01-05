package com.vodafone.task.core.model

data class VodafoneTaskException(
    override val message: String?,
    override val cause: Throwable?
) : Throwable(message, cause)
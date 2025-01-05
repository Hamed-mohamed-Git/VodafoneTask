package com.vodafone.task.core.common

import com.vodafone.task.core.common.Resource.Failure
import com.vodafone.task.core.common.Resource.Failure.Expected
import com.vodafone.task.core.common.Resource.Failure.Unexpected
import com.vodafone.task.core.common.Resource.Success

sealed interface Resource<out D, out E : Throwable> {
    companion object {
        fun <D, E : Throwable> success(data: D): Resource<D, E> = Success(data)
        fun <D, E : Throwable> expectedFailure(cause: E): Resource<D, E> = Expected(cause)
        fun <D, E : Throwable> unexpectedFailure(cause: Throwable): Resource<D, E> =
            Unexpected(cause)
    }

    data class Success<D>(val data: D) : Resource<D, Nothing>

    sealed interface Failure<E : Throwable> : Resource<Nothing, E> {
        data class Expected<E : Throwable>(val cause: E) : Failure<E>
        data class Unexpected(val cause: Throwable) : Failure<Nothing>
    }
}

fun <D, E : Throwable> Resource<D, E>.getOrNull() = (this as? Success)?.data

fun <D, E : Throwable> Resource<D, E>.getOrThrow() =
    (expectedCauseOrNull() ?: unexpectedCauseOrNull())?.let { throw it } ?: (this as Success).data


fun <D, E : Throwable> Resource<D, E>.expectedCauseOrNull() = (this as? Expected<E>)?.cause
fun <D, E : Throwable> Resource<D, E>.unexpectedCauseOrNull() = (this as? Unexpected)?.cause

inline fun <D, E : Throwable> Resource<D, E>.onSuccess(block: (D) -> Unit): Resource<D, E> {
    if (this is Success)
        block(data)
    return this
}

inline fun <D, E : Throwable> Resource<D, E>.onFailure(block: (E?, Throwable?) -> Unit): Resource<D, E> {
    if (this is Failure)
        block((this as? Expected)?.cause, (this as? Unexpected)?.cause)
    return this
}

inline fun <D, E : Throwable> Resource<D, E>.onFailure(block: (Throwable) -> Unit): Resource<D, E> {
    if (this is Failure)
        block((this as? Expected)?.cause ?: (this as Unexpected).cause)
    return this
}

inline fun <D, E : Throwable> Resource<D, E>.onFailure(
    onExpected: (E) -> Unit,
    onUnexpected: (Throwable) -> Unit
): Resource<D, E> {
    if (this is Expected)
        onExpected(cause)

    if (this is Unexpected)
        onUnexpected(cause)

    return this
}

inline fun <D, E : Throwable> Resource<D, E>.onExpectedFailure(block: (E) -> Unit): Resource<D, E> {
    if (this is Expected)
        block(cause)
    return this
}

inline fun <D, E : Throwable> Resource<D, E>.onUnexpectedFailure(block: (Throwable) -> Unit): Resource<D, E> {
    if (this is Unexpected)
        block(cause)
    return this
}

inline fun <D, E : Throwable> Resource<D, E>.handle(
    onSuccess: (D) -> Unit,
    onUnexpectedFailure: (Throwable) -> Unit,
    onExpectedFailure: (E) -> Unit,
): Resource<D, E> {
    when (this) {
        is Expected -> onExpectedFailure(cause)
        is Unexpected -> onUnexpectedFailure(cause)
        is Success -> onSuccess(data)
    }
    return this
}

inline fun <I, O, E : Throwable> Resource<I, E>.map(transformer: (I) -> O): Resource<O, E> =
    when (this) {
        is Success ->
            try {
                Resource.success(transformer(data))
            } catch (e: Throwable) {
                Resource.unexpectedFailure(e)
            }

        is Expected -> Resource.expectedFailure(cause)
        is Unexpected -> Resource.unexpectedFailure(cause)
    }

inline fun <ID, OD, IE : Throwable, OE : Throwable> Resource<ID, IE>.flatmap(transformer: (ID) -> Resource<OD, OE>): Resource<OD, OE> =
    when (this) {
        is Success ->
            try {
                transformer(data)
            } catch (e: Throwable) {
                Resource.unexpectedFailure(e)
            }

        is Expected -> Resource.unexpectedFailure(cause)
        is Unexpected -> Resource.unexpectedFailure(cause)
    }

inline fun <I1, I2, O, E1 : Throwable, E2 : Throwable> Resource<I1, E1>.combine(
    resource: Resource<I2, E2>,
    transformer: (I1, I2) -> O
): Resource<O, E2> = resource.map { transformer(getOrThrow(), it) }

inline fun <D, reified E : Throwable> runCatching(block: () -> D): Resource<D, E> =
    try {
        Success(block())
    } catch (e: Throwable) {
        if (e is E)
            Expected(e)
        else Unexpected(e)
    }

inline fun <D, E : Throwable> Resource<D?, E>.onNotNullSuccess(block: (D) -> Unit): Resource<D?, E> =
    onSuccess { it?.let(block) }

inline fun <D, E : Throwable> Resource<D, E>.onNullSuccess(block: () -> Unit): Resource<D, E> =
    onSuccess { if (it == null) block() }

inline fun <D, E : Throwable> Resource<D, E>.onNullOrFailure(block: (E?, Throwable?) -> Unit): Resource<D, E> {
    if (this !is Success || this.data == null) block(expectedCauseOrNull(), unexpectedCauseOrNull())
    return this
}
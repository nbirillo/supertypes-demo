import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

interface ContinuationInterceptorInterface : ContinuationInterceptor {
    fun myFoo()
}

interface MyContinuationInterceptorInterfaceDirectCall : ContinuationInterceptorInterface {

    override fun releaseInterceptedContinuation(continuation: Continuation<*>) {
        super.releaseInterceptedContinuation(continuation)
    }
}

interface MyContinuationInterceptorInterfaceNotDirectCall : ContinuationInterceptorInterface {

    fun myFoo(continuation: Continuation<*>) {
        super.releaseInterceptedContinuation(continuation)
    }
}

interface MyContinuationInterceptorInterfaceWrong : ContinuationInterceptorInterface {

    override fun myFoo() {
        TODO("Not yet implemented")
    }
}

class MyContinuationInterceptorClass(override val key: CoroutineContext.Key<*>) : ContinuationInterceptorInterface {
    override fun myFoo() {
        TODO("Not yet implemented")
    }

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        TODO("Not yet implemented")
    }

    override fun releaseInterceptedContinuation(continuation: Continuation<*>) {
        super.releaseInterceptedContinuation(continuation)
    }
}

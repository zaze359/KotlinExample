package com.zaze.kotlin.example

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

object ThreadPlugin {

    val testExecutorStub by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ThreadExecutorStub(
            ThreadPoolExecutor(
                0,
                2,
                60L,
                TimeUnit.SECONDS,
                LinkedBlockingQueue(),
                DefaultFactory("launcher_request")
            )
        )
    }
}
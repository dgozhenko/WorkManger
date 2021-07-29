package com.raywenderlich.android.workmanager

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.work.testing.TestListenableWorkerBuilder
import com.raywenderlich.android.workmanager.workers.ImageDownloadWorker
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class ImageDownloadWorkerTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var workerManagerTestRule = WorkManagerTestRule()

    @Test
    fun testDownloadWork() {
        val work = TestListenableWorkerBuilder<ImageDownloadWorker>(workerManagerTestRule.targetContext).build()
        runBlocking {
            val result = work.doWork()
            assertNotNull(result)
        }
    }
}
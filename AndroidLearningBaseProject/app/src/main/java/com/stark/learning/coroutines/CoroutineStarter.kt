package com.stark.learning.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stark.learning.R
import kotlinx.android.synthetic.main.activity_coroutine_starter.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

class CoroutineStarter : AppCompatActivity(R.layout.activity_coroutine_starter) {
    private  val TAG = "CoroutineStarter"
    private val RESULT_1 = "Result #1"
    private val RESULT_2 = "Result #2"

    private val JOB_TIMEOUT = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn1.setOnClickListener {

            CoroutineScope(IO).launch {
              //textView1.text = fakeAPIRequest()
               // fakeAPIRequest()
                fakeAPIRequest2()
            }
        }
    }



    private suspend fun fakeAPIRequest() : String {
        val result = getResultFromAPI()
       setTextFromMainThread( result )

        val result2 = getResultFromAPI2(result)
        setTextFromMainThread(result2)

      return result
    }

    private suspend fun fakeAPIRequest2(){
        withContext(IO){
            val job1 = withTimeoutOrNull(JOB_TIMEOUT + 300L){

                val result1= getResultFromAPI()
                setTextFromMainThread(result1)

                val result2 = getResultFromAPI2()
                 setTextFromMainThread(result2)
            }

            if(job1 == null){
                val cancelMessage = "Cancelling job... Job took longer than we expected."
                Log.d(TAG, "fakeAPIRequest2: $cancelMessage")
                setTextFromMainThread(cancelMessage)
            }
        }
    }



    private fun setNewText(input : String){
        textView1.text = textView1.text.toString()+ "\n $input"
    }

    private suspend fun setTextFromMainThread(input: String){
        withContext(Main){
            setNewText(input)
        }
    }

    private suspend fun getResultFromAPI2(result: String = "") : String {
        logThread("getResultFromAPI2")
        delay(1000)
        return RESULT_2 + result
    }

    private suspend fun getResultFromAPI() : String{
        logThread("getResultFromAPI")
        delay(1000)
        return RESULT_1
    }

    private  fun logThread( name : String ){

        Log.d(TAG, "Method Name : $name : Thread Name  :  ${Thread.currentThread().name}")
    }
}
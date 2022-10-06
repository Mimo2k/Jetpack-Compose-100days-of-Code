package com.example.playground

import java.io.IOException

fun main(){
    /* Generics */
    val myList = listOf<String>("Mimo", "Sompa", "Rina", "Samaresh") //List of String
    val numberList = listOf<Int>(1, 2, 3, 4, 5) //List of Int
    val finder = Finder(list = myList)// String
    val finderInt = Finder(list = numberList)
    finder.findItem("Mimo"){
        println("Found $it")
    }
    finderInt.findItem(1){
        println("found $it")
    }

    /* Enum class
    val input = Result.ERROR
    getResult(result = input)
     */
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())

    Repository.finishedFetch()
    getResult(result = Repository.getCurrentState())

    Repository.anotherCustomFailure()
    getResult(result = Repository.getCurrentState())

    Repository.customFailure()
    getResult(result = Repository.getCurrentState())




}
/* Generics T is used to specify any type */
class Finder<T>(private val list: List<T>){
    fun findItem(element: T, foundItem: (element: T?) -> Unit){
       val itemFoundList = list.filter {
           it == element
       }
        if(itemFoundList.isNullOrEmpty())
        {
            foundItem(null)
        } else{
            foundItem(itemFoundList.first())
        }
    }
}
fun getResult(result: Result){
    return when(result){
       is Error ->{
           println(result.exception.toString())
       }
        is Success ->{
            println(result.dataFetched?: "Ensure you start Fetch function First")
        }
        is Loading->{
            println("Loading...")
        }
        is NotLoading->{
            println("Idle")
        }
        is Failure.AnotherCustomFailure -> println(result.anotherCustomFailure.toString())
        is Failure.CustomFailure -> println(result.customFailure.toString())
    }
}
object Repository {   //singleton
    private var loadState: Result  = NotLoading
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Loading
        dataFetched = "data"
    }
    fun finishedFetch(){
        loadState = Success(dataFetched)
        dataFetched = null
    }
    fun error(){
        loadState = Error(exception = Exception("Exception"))
    }
    fun getCurrentState(): Result{
        return loadState
    }

    fun customFailure(){
        loadState = Failure.AnotherCustomFailure(anotherCustomFailure = NullPointerException("Something Went Wrong"))
    }

    fun anotherCustomFailure(){
        loadState = Failure.CustomFailure(customFailure = IOException("Custom Failure"))
    }
}
/* Enum Class
enum class Result{
    SUCCESS,
    ERROR,
    IDLE,
    LOADING
}
*/

sealed class Result
data class Success(val dataFetched: String?): Result()
data class Error(val exception: Exception?): Result()
object NotLoading: Result()
object Loading: Result()


// Sealed class

sealed class Failure: Result(){
    data class CustomFailure(val customFailure: IOException): Failure()
    data class AnotherCustomFailure(val anotherCustomFailure: NullPointerException): Failure()
}
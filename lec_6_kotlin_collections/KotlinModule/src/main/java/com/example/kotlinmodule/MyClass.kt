package com.example.kotlinmodule

fun main(){
    /* list */
    myList() //lecture: 1 -> list and iteration
    myMutableList() //lecture: 2 -> mutable list
    invokingFunctionOnList() //lecture: 3 -> invoking method on list
    /* Set  */
    mySet() //lecture:4 -> Set
    /* Map */
    myMap() //lecture:5 -> Map
    emptyCollection() //lecture:6 -> Empty Collection

    collectionFilter() //lecture:7 -> Filter


}


//LECTURE 1:
private fun myList() {
    val myListNames = listOf<String>("Mimo", "Sompa", "Rina", "Samaresh") //list
    for (i in myListNames) {
        print("$i ")
    }
    println()
    myListNames.forEach {
        print("$it ")
    }
    println()
}

//LECTURE 2:
private fun myMutableList() {
    val myMutableList = mutableListOf<String>("Mimo", "Vivek")
    myMutableList.add("Rahul") //add rahul string to end
    println("last string of list ${myMutableList[2]}")
    myMutableList.remove("Rahul") // remove rahul string by searching in list
    myMutableList.removeAt(0) // remove mimo which is in index 0
    myMutableList.forEach {
        print("after removing list: $it")
    }
    println()
}

//LECTURE 3:
private fun invokingFunctionOnList() {
    val myMutableList = mutableListOf<Int>(1, 2, 5, 4, 3, 6)
    print("Size of mutable list: ${myMutableList.size} \n")
    print("Element at second index: ${myMutableList.get(2)} \n")
    print("Index of 3 is: ${myMutableList.indexOf(3)}")
    println()
}

//LECTURE 4:
private fun mySet() {
    val mySet = setOf<Int>(1, 2, 3, 4, 5, 2) //set
    println("my set: $mySet ")
    /* 2nd copy of 2 was automatically removed
       as set only stores unique and distinct elements
     */
    val mutableSet = mutableSetOf<Int>(1, 3, 5, 7)
    mutableSet.add(11)
    println("Mutable set after adding 11 : $mutableSet")
}

//LECTURE 5:
private fun myMap() {
    val myMap = mapOf<String, Int>("up" to 1, "Down" to 2)
    println("my Map: $myMap")
    println("all keys: ${myMap.keys}") //print all keys
    if ("up" in myMap) {          // check certain key
        println("Up is present in myMap")
    }

    val myMutableMap = mutableMapOf<Int, String>(
        1 to "Mimo",
        2 to "Sompa", 3 to "Rina"
    ) //mutable map
    myMutableMap.put(4, "Samaresh") // add element with key
    println("my Mutable Map: $myMutableMap")
}

//LECTURE 6:
private fun emptyCollection() {
    val myEmptyList = emptyList<Int>()
    val myEmptySet = emptySet<Int>()
    val myEmptyMap = emptyMap<Int, String>()
}

//LECTURE 7:
private fun collectionFilter() {
    emptyCollection() //lecture:6 ->Empty Collection
    val myListOfNumbers = listOf<Int>(1, 2, 3, 4, 5)
    val found = myListOfNumbers.filter {  //if found a new list found will be initialized with it
        it == 1
    }
    println("Filter Equals: $found")

    val myNameList = listOf<String>("Mimo", "patra", "Samaresh", "RIna")
    val got = myNameList.filter {
        it.contains('i', ignoreCase = true)
    }
    println("Filter Contains: $got")
}



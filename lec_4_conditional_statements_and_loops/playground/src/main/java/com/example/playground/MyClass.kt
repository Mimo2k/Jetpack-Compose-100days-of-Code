package com.example.playground

fun main(){
    var check:Boolean = false // Boolean data type can be initialized with true or false

    commentKotlin() //Lecture 1
    ifElse() //Lecture 2
    canGiveVote() //Lecture 3
    gradeCheck() //Lecture 4 When Statement
    evenNumberInRange() //Lecture 5 for Loop

}

// LECTURE: 1
private fun commentKotlin() {
    /*
    this is a multiline comment
     */

    // this is a single line comment
}
//Lecture: 2
private fun ifElse() {
    /*
     if age equals 18 fresh voter, else unpredictable
     */
    //  ==    <- Equality Operator
    val age = 18
    if (age == 18) {
        print("fresh voter \n")
    } else {
        print("unpredictable \n")
    }
}
// LECTURE: 3
private fun canGiveVote() {
    var age = 19
    if (age >= 18) {
        print("Can Give Vote \n")
    } else {
        print("Can't Give Vote \n")
    }
}
// LECTURE: 4
private fun gradeCheck() {
    var marks = 80
    when (marks) {
        100 -> print("full marks") //equality check in when
        in 90..99 -> print("Grade A+") // range check in when
        in 80..89 -> print("Grade A")
        in 70..79 -> print("Grade B+")
        in 60..69 -> print("Grade B")
        !in 60..100 -> print("you can improve") // not in a range check in when
        else -> {  // else condition in check
            print("Wrong Entry")
        }
    }
    print("\n")
}

// LECTURE: 5
private fun evenNumberInRange() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            print("$i: is Even\n")
        }
    }
}
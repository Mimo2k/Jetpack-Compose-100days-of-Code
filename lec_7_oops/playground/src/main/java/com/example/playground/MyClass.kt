package com.example.playground

fun main(){
    /* Classes and Object  <- Lecture 1 */

    val car = Car("Red", "Verna")  // car is a object of class Car
    val newCar = Car("Yellow","lamborgini Urus") // newCar is a object of class Car
    car.drive()
    car.speed(80)  //passing argument
    newCar.drive()
    newCar.speed(150)

    /* Inheritance <- Lecture 2 */

    val truck = Truck("Blue","Mahindra")
    truck.drive()
    truck.speed(42)

    /*  Interface <- Lecture 3 */

    val button = Button(label = "button")
    button.onClick(message = "this is a button")

    /*  Extension Function <- Lecture 4 */

    println("hello World".append("!"))
    println("This is Fun".removeFirstAndLastChar())

    /*  Data Class <- Lecture 5 */
    val mimo = Person(
        firstName = "Mimo",
        lastName = "Patra",
        age = 22
    )
    val sompa = Person(
        firstName = "Sompa",
        lastName = "Patra",
        age = 19
    )
    val person = listOf<Person>(mimo, sompa)
    person.forEach { item->
    println(item.age)
    }
}
/* Inheritance */
class Truck(private var color: String, private var model: String): Car(color, model) {
    override fun speed(speed: Int) {
        println("Driving a Truck at speed $speed km/h")
    }
}
open class Car(private var color: String, private var model: String) { //primary Constructor
    init {  //initialize starting value  to the class
        if(color == "Red") {
            color = "Black"   //override the color value to black
        }
    }
    fun drive(){
        print("Driving $color color $model \n")
    }
    open fun speed(speed: Int){  //class method with parameters
        println("Current Speed of Car is $speed km/h")
    }
}
class Button(val label: String): ClickEvent{                  //Importing Interface
    override fun onClick(message: String) {
        println("Clicked by $label and here is a message $message")
    }

}
interface ClickEvent{                 //Interface
    fun onClick(message: String)
}

fun String.append(toAppend: String): String{          //Extension Function
    return this.plus(toAppend)
}

fun String.removeFirstAndLastChar(): String{     //Extension Function
    return this.substring(1,this.length-1)
}

/* Data Class */
data class Person(val firstName:String,val lastName:String, val age:Int)
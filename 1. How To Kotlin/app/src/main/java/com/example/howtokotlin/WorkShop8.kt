package com.example.howtokotlin

// workshop #8 - const, companion object, extension func*

/*
 * Сокращаем телефон до максимально докустимой длины maxLength
 * и пишем функцию экстеншен на лист, которая заменяет каждый i-й элемент номером телефона
 */


// TODO 1: make maxLength const that is visible only inside the Person class

// TODO 2: make companionConstant part of companion object
val companionConstant = 12

class Person(phoneCode: String) {
    val code = if (phoneCode.length > maxLengthDone) phoneCode.subSequence(0, maxLengthDone) else phoneCode

    companion object {
        private const val maxLengthDone = 12
    }

    // * * * Bonus task * * * (work on home)

    //TODO 3: make this fun as extension to a list outside the Person class
    private fun replacePlacesWithThePhoneCode(list: List<Any>, placeNum: Int = 3): List<Any> {
        return list.mapIndexed { index, any -> if (index % placeNum == 0) code else any}
    }
}

fun main() {
    val list = mutableListOf("1", 3, 4, "Patrick", 3.4, "123-59")

    val p = Person("45-45-45")

    //TODO *: uncomment after doing function
    fun List<Any>.replacePlacesWithThePhoneCode(person: Person, placeNum: Int = 3): List<Any> {
        return this.mapIndexed { index, any -> if (index % placeNum == 0) person.code else any }
    }
}
package com.example.howtokotlin

// workshop #9 - generics
/*
 * Класс программиста, который может учить и забывать концепты на определенном языке.
 */

fun main() {
    val p = Programmer<Kotlin>()

    //TODO: uncomment all
    p.learn(Kotlin("basics"))

    p.learn(Kotlin("generics"))
    p.learn(Kotlin("coroutines"))

    println(p.howManyConceptsDoIKnow())
    // should be equal to 3

    println(p.lastConcept())
    //should be Kotlin(element=coroutines)

    p.forget(Kotlin("generics"))
    println(p.howManyConceptsDoIKnow())
    // should be equal to 2
}

interface Language{
    val element: String
}

class Programmer<T: Language> {
    private val concepts = mutableListOf<T>()
    fun howManyConceptsDoIKnow(): Int = concepts.size

    // TODO: add "learn" function with new concept
    fun learn(concept: T) {
        concepts.add(concept)
    }

    //TODO: add "forget" function with one concept to forget
    fun forget(concept: T) {
        concepts.remove(concept)
    }

    fun lastConcept(): T = concepts.last()
}


data class JavaLanguage(override val element: String) : Language
data class Kotlin(override val element: String): Language
data class Swift(override val element: String): Language
data class C_Sharp(override val element: String): Language
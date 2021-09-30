package com.example.retokmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun greetingHome(): String {
        return "Comics Fragment"
    }

    fun greetingCharacter(): String {
        return "Character Fragment"
    }

    fun greetingSearch(): String {
        return "Search Fragment"
    }

    fun greetingAccount(): String {
        return "Account Fragment"
    }
}
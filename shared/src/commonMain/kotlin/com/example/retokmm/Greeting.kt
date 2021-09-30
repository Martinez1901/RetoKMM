package com.example.retokmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun greetingHome(): String {
        return "Home Fragment"
    }

    fun greetingSearch(): String {
        return "Search Fragment"
    }

    fun greetingAccount(): String {
        return "Account Fragment"
    }
}
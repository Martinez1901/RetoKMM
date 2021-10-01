package com.example.retokmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
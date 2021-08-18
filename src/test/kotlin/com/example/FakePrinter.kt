package com.example

class FakePrinter : Printer {
    lateinit var message: String
    override fun print(text: String) {
        message = text
    }
}

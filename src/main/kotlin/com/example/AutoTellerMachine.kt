package com.example

class AutoTellerMachine(private val printer: Printer, val bankService: BankingService) {

    fun withdraw(amount: Int) {
        // WRITE CODE HERE.
        try {
            bankService.withdraw(amount)
            printer.print("$amount withdrawn")
        } catch (e: Exception) {
            printer.print(e.message!!)
        }
    }
}

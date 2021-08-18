package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AutoTellerMachineTest : StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        val printer = FakePrinter()
        val bankService = FakeBankingService(true)
        val atm = AutoTellerMachine(printer, bankService)
        atm.withdraw(12)
        printer.message shouldBe "12 withdrawn"
    }

    "should throw exception if banking service throws an exception" {
        val printer = FakePrinter()
        val bankService = FakeBankingService(false)
        val atm = AutoTellerMachine(printer, bankService)
        atm.withdraw(200)
        printer.message shouldBe "bank server are not responding"
    }

    "should throw an exception when amount is less than or equal to zero" {
        val printer = FakePrinter()
        val bankService = FakeBankingService(true)
        val atm = AutoTellerMachine(printer, bankService)
        atm.withdraw(0)
        printer.message shouldBe "no a valid amount"
    }
})

package com.example.mockTest

import com.example.AutoTellerMachine
import com.example.BankingService
import com.example.Printer
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class AutoTellerMachineTest : StringSpec({
    // creating the mocks of required classes
    val printService = mockk<Printer>()
    val bankService = mockk<BankingService>()

    val atm = AutoTellerMachine(printService, bankService)

    "should print a receipt if money is withdrawn successfully" {
        // stubbing them based on the need and nature of test
        every { bankService.withdraw(100) } returns Unit
        every { printService.print("100 withdrawn") } returns Unit

        atm.withdraw(100)

        // verifying it
        verify { printService.print("100 withdrawn") }
    }

    "should throw an exception" {
        // stubbing them based on the need and nature of test
        every { bankService.withdraw(100) }.throws(Exception("bank server is not responding"))
        every { printService.print("bank server is not responding") } returns Unit
        atm.withdraw(100)
        // verifying it
        verify { printService.print("bank server is not responding") }
    }
})

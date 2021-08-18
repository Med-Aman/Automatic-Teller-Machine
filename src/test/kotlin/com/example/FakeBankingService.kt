package com.example

class FakeBankingService(val validTransaction: Boolean) : BankingService {

    override fun withdraw(amount: Int) {
        if (!validTransaction) throw error("bank server are not responding")
        if (amount <= 0) throw error("not a valid amount")
    }
}

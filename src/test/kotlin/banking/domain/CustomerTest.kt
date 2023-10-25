package banking.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.currentStackTrace

class CustomerTest{

    @Test
    fun `should update all BankAccount connected Addresses`() {
        val customer = Customer("Nelly Bly", listOf(BankAccount(Address("Berlin", "Einsteinstr 4"))))

        val updateAddress = customer.updateAddress(Address("Mumbai", "somewhere"))

        assertEquals("Mumbai", updateAddress.bankAccounts.get(0).address.city)
    }
}
package banking.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class CustomerTest{

    @Test
    fun `should update all BankAccount connected Addresses`() {
        val customer = Customer("Nelly Bly", listOf(BankAccount(UUID.randomUUID(),Address("Berlin", "Einsteinstr 4"))))

        val updateAddress = customer.updateAddressOfAllBankAccounts(Address("Mumbai", "somewhere"))

        assertEquals("Mumbai", updateAddress.bankAccounts.get(0).address.city)
    }
}
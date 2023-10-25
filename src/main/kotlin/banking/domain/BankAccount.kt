package banking.domain

import java.util.UUID

data class BankAccount(val uuid: UUID, val address: Address) {

    fun updateAddress(address: Address): Address{
        this.address.update(address)
        return address
    }

}

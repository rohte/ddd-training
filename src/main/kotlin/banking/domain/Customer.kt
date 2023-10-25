package banking.domain

data class Customer(val name: String, val bankAccounts: List<BankAccount>) {

    fun updateAddress(address: Address): Customer{
        return Customer(name, bankAccounts.map{ it.copy(address = address) } )
    }
}

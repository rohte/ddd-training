package banking.domain

data class Address(var city: String, var street: String) {

    fun update(address: Address) {
        city = address.city
        street = address.street
    }
}

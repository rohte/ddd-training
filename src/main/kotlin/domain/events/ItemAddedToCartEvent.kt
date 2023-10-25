package domain.events

import domain.Item

data class ItemAddedToCartEvent(val item: Item): DomainEvent

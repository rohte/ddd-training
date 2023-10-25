package domain.events

import domain.Item

data class ItemRemovedFromCartEvent(val item: Item): DomainEvent

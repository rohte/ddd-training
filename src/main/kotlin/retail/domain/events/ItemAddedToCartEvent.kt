package retail.domain.events

import retail.domain.Item

data class ItemAddedToCartEvent(val item: Item): DomainEvent

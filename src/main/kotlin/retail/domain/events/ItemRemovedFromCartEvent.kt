package retail.domain.events

import retail.domain.Item

data class ItemRemovedFromCartEvent(val item: Item): DomainEvent

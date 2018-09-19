package blue.sparse.kmc.api.type.item

import blue.sparse.kmc.api.type.variations.ItemVariation

//data class ItemStack<T: ItemType<V>, V: ItemVariation>(var item: Item<T, V>, var amount: Int = 1)
data class ItemStack(var item: Item<*, *>, var amount: Int)
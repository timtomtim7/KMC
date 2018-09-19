package blue.sparse.kmc.api.type.item

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
inline class ItemDisplay(val item: Item<*, *>) {
	var name: String?
		get() = item.properties[ItemProperties.DisplayName]
		set(value) = item.properties.set(ItemProperties.DisplayName, value)

	var lore: List<String>?
		get() = item.properties[ItemProperties.DisplayLore]
		set(value) = item.properties.set(ItemProperties.DisplayLore, value)
}
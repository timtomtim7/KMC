package blue.sparse.kmc.api.chat

import blue.sparse.kmc.api.plugin.Plugin

@Deprecated("Might be removed or drastically changed")
abstract class ChatText {

	var color: Color? = null
	var extra: ChatText? = null
	val effects: MutableSet<Effect> = HashSet()

	class Raw(var text: String): ChatText()
	class VanillaTranslate(val key: String, vararg with: String): ChatText()

	class Localized(val plugin: Plugin, var key: String, var placeholders: Map<String, Any>): ChatText() {
		constructor(plugin: Plugin, key: String, vararg placeholders: Pair<String, Any>): this(plugin, key, placeholders.toMap())
	}

	override fun toString(): String {
		return "[$color, $effects] $extra"
	}

	enum class Effect {
		BOLD,
		ITALIC,
		UNDERLINED,
		STRIKETHROUGH,
		OBFUSCATED
	}

	enum class Color {
		BLACK,
		GREEN,
		BLUE,
		AQUA,
		RED,
		PURPLE,
		ORANGE,
		GRAY,
		DARK_GRAY,
		LIGHT_BLUE,
		LIME,
		CYAN,
		LIGHT_RED,
		PINK,
		YELLOW,
		WHITE,
	}

	companion object {
		operator fun invoke(vararg values: Any): ChatText {
			val text = ArrayList<ChatText>()
			var color: Color? = null
			var effects = HashSet<Effect>()

			for(v in values) {
				when (v) {
					is String -> {
						text.add(ChatText.Raw(v).apply {
							this.color = color
							this.effects.addAll(effects)
						})
						color = null
						effects = HashSet()
					}
					is Color -> color = v
					is Effect -> effects.add(v)
				}
			}

			return combine(text) ?: ChatText.Raw("")
		}

		fun combine(text: Collection<ChatText>): ChatText? {
			if(text.isEmpty())
				return null

			val iterator = text.iterator()

			var current = iterator.next()
			for(next in iterator) {
				current.extra = next
				current = next
			}

			return current
		}
	}

}
package blue.sparse.kmc.api.world

interface World : BlockAccess, EntityAccess {
	val name: String
}
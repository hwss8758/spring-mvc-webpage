package hello.itemservice.domain.item

import org.springframework.stereotype.Repository

@Repository
class ItemRepository {

    companion object {
        val store: MutableMap<Long, Item> = hashMapOf()
        var sequence = 0.toLong()
    }

    fun save(item: Item): Item {
        item.id = ++sequence
        store.put(item.id!!, item)
        return item
    }

    fun findById(id: Long): Item? = store[id]

    fun findAll(): List<Item> = store.values.toList()

    fun update(itemId: Long, updateParam: Item) {
        val findItem = findById(itemId)

        findItem?.itemName = updateParam.itemName
        findItem?.price = updateParam.price
        findItem?.quantity = updateParam.quantity
    }

    fun clearStore() {
        store.clear()
    }
}
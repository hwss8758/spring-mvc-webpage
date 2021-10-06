package hello.itemservice.domain.item

class Item(
    var itemName: String,
    var price: Int? = null,
    var quantity: Int? = null
) {
    var id: Long? = null

    override fun toString(): String {
        return "Item(itemName='$itemName', price=$price, quantity=$quantity, id=$id)"
    }
}

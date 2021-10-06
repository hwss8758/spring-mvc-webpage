package hello.itemservice.web.basic

import hello.itemservice.domain.item.Item
import hello.itemservice.domain.item.ItemRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.PostConstruct

@Controller
@RequestMapping("/basic/items")
class BasicItemController(private val itemRepository: ItemRepository) {

    @GetMapping
    fun items(model: Model): String {
        val items = itemRepository.findAll()
        model.addAttribute("items", items)
        return "basic/items"
    }

    @PostConstruct
    fun init() {
        itemRepository.save(Item("itemA", 10000, 10))
        itemRepository.save(Item("itemB", 20000, 20))
    }
}
package hello.itemservice.domain.item

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ItemRepositoryTest {
    private val itemRepository = ItemRepository()

    @AfterEach
    fun afterEach() {
        itemRepository.clearStore()
    }

    @Test
    fun save() {
        //given
        val item = Item("itemA", 10000, 10)

        //when
        val savedItem = itemRepository.save(item)

        //then
        val findItem = itemRepository.findById(1L)

        assertThat(findItem).isEqualTo(savedItem)
    }
}
package concentric_circles.clean_architecture.service

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class InventoryService {

    @Autowired
    lateinit var inventoryRepository: InventoryRepository

    @Autowired
    lateinit var productService: ProductService

    fun addProductToInventory(productDTO: ProductDTO, amount: Int = 1) {
        val product = productService.getProductById(productDTO.productId ?: UUID.randomUUID())

        val inventory = productDTO.productId?.let { inventoryRepository.findInventoryByProductId(it) }

        if (inventory != null) {
            inventory.productQuantity += amount
        } else {
            inventoryRepository.save(Inventory(inventoryId = UUID.randomUUID(), productId = productDTO.productId, productQuantity = amount))
        }
    }

    // i initially named the function removeFromInventory but i think decreaseProductStockFromInventory is more descriptive
    // plus, removeFromInventory will be used to remove the whole stock of a product from the inventory
    fun decreaseProductStockFromInventory(productDTO: ProductDTO, amount: Int = 1) {
        val product = productService.getProductById(productDTO.productId ?: UUID.randomUUID())

        val inventory = productDTO.productId?.let { inventoryRepository.findInventoryByProductId(it) }

        if (inventory != null) {
            inventory.productQuantity -= amount
        } else {
            // TODO: maybe throw a more descriptive exception?
            throw Exception("Product not found in inventory")
        }
    }

    fun checkIfProductIsInInventory(productID: UUID): Boolean {
        return inventoryRepository.searchByProductId(productID)
    }

    fun removeProductFromInventory(productDTO: ProductDTO): Boolean {
        val inventory = productDTO.productId?.let { inventoryRepository.findInventoryByProductId(it) }

        if (inventory != null) {
            inventoryRepository.delete(inventory)
            return true
        } else {
            // TODO: maybe throw a more descriptive exception?
            throw Exception("Product not found in inventory")
        }
    }

}
package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.service.InventoryService
import org.springframework.stereotype.Service

@Service
class RemoveProductFromInventory (private val inventoryService: InventoryService) {

    fun removeProductFromInventory(productDTO: ProductDTO): Boolean {
        return inventoryService.removeProductFromInventory(productDTO)
    }
    
}
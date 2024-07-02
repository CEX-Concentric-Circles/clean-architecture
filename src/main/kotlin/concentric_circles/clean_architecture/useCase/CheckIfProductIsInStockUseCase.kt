package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.service.InventoryService
import org.springframework.stereotype.Service

@Service
class CheckIfProductIsInStockUseCase (private val inventoryService: InventoryService) {

    fun checkIfProductIsInStock(productDTO: ProductDTO): Boolean? {
        return productDTO.productId?.let { inventoryService.checkIfProductIsInInventory(it) }
    }

}
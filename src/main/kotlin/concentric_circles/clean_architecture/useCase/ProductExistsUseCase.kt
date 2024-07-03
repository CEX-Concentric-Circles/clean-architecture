package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductExistsUseCase(private val productService: ProductService) {

    fun productexists(productId: UUID): Boolean {
        return productService.checkIfProductExists(productId)
    }

}
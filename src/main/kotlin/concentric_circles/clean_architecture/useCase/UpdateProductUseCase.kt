package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UpdateProductUseCase(private val productService: ProductService) {

    fun updateProduct(productDTO: ProductDTO): Product? {
        return productService.updateProduct(productDTO)
    }

}
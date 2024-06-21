package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase(private val productService: ProductService) {

    fun createProduct(productDTO: ProductDTO): Product {
        return productService.createProduct(productDTO)
    }

}
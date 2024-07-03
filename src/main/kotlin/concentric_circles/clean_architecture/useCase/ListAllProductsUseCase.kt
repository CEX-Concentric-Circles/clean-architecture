package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import org.springframework.stereotype.Service

@Service
class ListAllProductsUseCase(private val productService: ProductService) {

    fun listAllProducts(): List<Product> {
        return productService.listAllProducts()
    }

}
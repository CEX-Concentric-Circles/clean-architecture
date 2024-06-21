package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import java.util.UUID


class GetProductUseCase(private val productService: ProductService) {

    fun getProduct(productId: UUID): Product {
        return productService.getProductById(productId)
    }

}
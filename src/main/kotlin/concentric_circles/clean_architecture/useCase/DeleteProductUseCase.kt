package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import java.util.UUID


class DeleteProductUseCase(private val productService: ProductService) {

    fun deleteProduct(productId: UUID) {
        productService.deleteProduct(productId)
    }

}
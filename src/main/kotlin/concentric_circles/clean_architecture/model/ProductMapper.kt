package concentric_circles.clean_architecture.model

import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.model.entity.Product
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProductMapper {
    fun toDTO(product: Product): ProductDTO {
        return ProductDTO(
            productId = product.productId,
            name = product.name,
            price = product.price
        )
    }

    fun toEntity(productDTO: ProductDTO): Product {
        return Product(
            productId = productDTO.productId?: UUID.randomUUID(),
            name = productDTO.name,
            price = productDTO.price
        )
    }
}
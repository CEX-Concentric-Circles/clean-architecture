package concentric_circles.clean_architecture.model.dto

import java.util.UUID

data class ProductDTO(
    val productId: UUID? = null,
    val name: String,
    val price: Double
)
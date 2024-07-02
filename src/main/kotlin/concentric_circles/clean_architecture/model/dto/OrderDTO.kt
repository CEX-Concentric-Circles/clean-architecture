package concentric_circles.clean_architecture.model.dto

import concentric_circles.clean_architecture.model.entity.Product
import java.util.UUID

data class OrderDTO(
    val orderId: UUID? = null,
    // TODO change the type of listOfProducts from List<Product> to List<ProductDTO>.
    // TODO make sure the change is also reflected in the mapper
    val listOfProducts: List<Product> = mutableListOf()
)
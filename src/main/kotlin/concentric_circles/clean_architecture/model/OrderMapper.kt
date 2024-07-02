package concentric_circles.clean_architecture.model

import concentric_circles.clean_architecture.model.dto.OrderDTO
import concentric_circles.clean_architecture.model.entity.Order
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderMapper {
    fun toDTO(order: Order): OrderDTO {
        return OrderDTO(
            orderId = order.orderId,
            listOfProducts = order.listOfProducts.toMutableList()

        )
    }

    fun toEntity(orderDTO: OrderDTO): Order {
        return Order(
            orderId = orderDTO.orderId?: UUID.randomUUID(),
            listOfProducts = orderDTO.listOfProducts.toMutableList()
        )
    }
}
package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.service.OrderService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteOrderUseCase (private val orderService: OrderService) {

    fun deleteOrder(orderID: UUID): Boolean {
        return orderService.deleteOrder(orderID)
    }

}
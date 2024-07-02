package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.dto.OrderDTO
import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.service.OrderService
import org.springframework.stereotype.Service

@Service
class ProcessOrderUseCase (private val orderService: OrderService) {

    fun processOrder(orderDTO: OrderDTO): Order {
        return orderService.processOrder(orderDTO)
    }

}
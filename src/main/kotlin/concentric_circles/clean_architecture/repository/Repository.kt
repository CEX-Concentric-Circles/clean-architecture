package concentric_circles.clean_architecture.repository

import org.springframework.stereotype.Repository
import java.util.UUID

// not using this for now, might need it in the future
@Repository
interface Repository<T: Any, ID: UUID> {
    fun create(entity: T): T
    fun update(entity: T): T
    fun delete(id: ID): Boolean
    fun save(entity: T): T
    fun findById(id: ID): T?
    fun findAll(): List<T>
}
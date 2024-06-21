package concentric_circles.clean_architecture.service

import concentric_circles.clean_architecture.model.ProductMapper
import concentric_circles.clean_architecture.model.dto.ProductDTO
import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService {

    @Autowired
    lateinit var productMapper: ProductMapper

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var inventoryService: InventoryService

    @Autowired
    lateinit var orderService: OrderService

    fun createProduct(productDTO: ProductDTO): Product {
        // check if product already exists
        val existingProduct = productRepository.findProductByName(productDTO.name)

        if (existingProduct != null) {
            throw Exception("Product '${productDTO.name}' already exists. If you want to, you can modify the amount of the product in the inventory.")
        }

        val product = productMapper.toEntity(productDTO)

        productRepository.save(product)

        return product
    }

    fun deleteProduct(productID: UUID) {
        val product = productRepository.findById(productID).orElseThrow { Exception("Product not found") }

        productRepository.delete(product)
    }

    fun listAllProducts(): List<Product> {
        return productRepository.findAll().toList()
    }

    fun checkIfProductExists(productID: UUID): Boolean {
        return productRepository.existsById(productID)
    }
    
    fun updateProduct(productDTO: ProductDTO): Product? {
        val searchedProduct = productDTO.productId?.let { productRepository.findById(it).orElseThrow { Exception("Product not found") } }

        if (searchedProduct != null) {

            searchedProduct.name = productDTO.name
            searchedProduct.price = productDTO.price

            productRepository.save(searchedProduct)
        }

        return searchedProduct
    }

    fun getProductById(productID: UUID): Product {
        return productRepository.findById(productID).orElseThrow { Exception("Product not found") }
        }
}
package demo.multipledb.services;

import demo.multipledb.dtos.DepartmentResponseDto;
import demo.multipledb.dtos.ProductResponseDto;
import demo.multipledb.models.department.Department;
import demo.multipledb.models.employee.Products;
import demo.multipledb.repositories.department.DepartmentRepository;
import demo.multipledb.repositories.employee.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
    ProductsRepository productsRepository;
    DepartmentRepository departmentRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository, DepartmentRepository departmentRepository) {
        this.productsRepository = productsRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long productId) {
        Products products = productsRepository.findById(productId).orElseThrow(
                () -> new EntityNotFoundException("Product not found"));

        Department department = departmentRepository.findById(1L).orElseThrow(
                () -> new EntityNotFoundException("Department not found"));

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto().builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .departmentAddress(department.getDepartmentAddress())
                .departmentCode(department.getDepartmentCode())
                .build();

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .productId(products.getProductId())
                .productName(products.getProductName())
                .department(departmentResponseDto)
                .build();

        return productResponseDto;
    }
}

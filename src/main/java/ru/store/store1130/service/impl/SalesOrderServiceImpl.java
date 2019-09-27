package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.SalesOrderStatus;
import ru.store.store1130.db.repository.ProductInOrderRepository;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.db.repository.SalesOrderReposirory;
import ru.store.store1130.service.CommonException;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductDto;
import ru.store.store1130.service.dto.ProductInOrderDto;
import ru.store.store1130.service.dto.SalesOrderDto;

import java.time.LocalDateTime;
import java.util.List;

import static ru.store.store1130.db.model.SalesOrderStatus.INPROGRESS;
import static ru.store.store1130.db.model.SalesOrderStatus.SUBMITED;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    SalesOrderReposirory salesOrderReposirory;
    @Autowired
    ConverterDomainToDto converterDomainToDto;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductInOrderServiceImpl productInOrderService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public Page<SalesOrder> findAll(Pageable pageable) {
        return salesOrderReposirory.findAll(pageable);
    }

    @Override
    public SalesOrderDto getOne(Long id) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.getOne(id));
    }

    @Override
    public void create(SalesOrderDto salesOrderDto) {
        salesOrderReposirory.save(converterDomainToDto.convertToDomain(salesOrderDto));
    }

    @Override
    public SalesOrderDto update(SalesOrderDto salesOrderDto) {
        if (salesOrderDto.getStatus().getText().equals(INPROGRESS.getText()) || salesOrderDto.getStatus().getText().equals(SUBMITED.getText())) {
            SalesOrder salesOrder = converterDomainToDto.convertToDomain(salesOrderDto);
            return converterDomainToDto.convertToDto(salesOrderReposirory.save(salesOrder));
        } else return null; //тут что-то надо вернуть, свое исключение?
    }


    @Override
    public void delete(Long id) {
        SalesOrder salesOrder = salesOrderReposirory.findById(id).get();
        if (salesOrder == null) {
            return;
        }
        salesOrderReposirory.delete(salesOrder);
    }


    @Override
    public Page<SalesOrderDto> findByOrderCategory(Pageable pageable, OrderCategory orderCategory) {
        List<SalesOrder> salesOrderList = salesOrderReposirory.findByOrderCategory(pageable, orderCategory).getContent();
        List<SalesOrderDto> salesOrderDtos = converterDomainToDto.convertToDto(salesOrderList);
        return new PageImpl<>(salesOrderDtos);
    }

    @Override
    public Page<SalesOrderDto> findByStatus(Pageable pageable, SalesOrderStatus salesOrderStatus) {
        List<SalesOrder> salesOrderList = salesOrderReposirory.findByStatus(pageable, salesOrderStatus).getContent();
        List<SalesOrderDto> salesOrderDtos = converterDomainToDto.convertToDto(salesOrderList);
        return new PageImpl<>(salesOrderDtos);
    }

    //   @Override
    //   public Page<SalesOrderDto> findByProductId(Pageable pageable, Long productId) {
    //       List<SalesOrder> salesOrderList = salesOrderReposirory.findByProductId(pageable, productId).getContent();
    //       List<SalesOrderDto> salesOrderDtos = converterDomainToDto.convertToDto(salesOrderList);
    //       return new PageImpl<>(salesOrderDtos);
    //   }


    @Override
    public Page<SalesOrderDto> findByDate(Pageable pageable, LocalDateTime date) {
        List<SalesOrder> salesOrderList = salesOrderReposirory.findByDate(pageable, date).getContent();
        List<SalesOrderDto> salesOrderDtos = converterDomainToDto.convertToDto(salesOrderList);
        return new PageImpl<>(salesOrderDtos);
    }

    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @Override
    public void addToBucket(SalesOrderDto salesOrderDto, ProductDto productDto, int value) throws CommonException{
        ProductInOrderDto productInOrderDto = productInOrderService.findOne(salesOrderDto);

        if (productInOrderDto.getSalesOrder() == null) {
            productInOrderDto.setSalesOrder(converterDomainToDto.convertToDomain(salesOrderDto));
        }
        productInOrderDto.setProduct(converterDomainToDto.convertToDomain(productDto)).setQuantity(value);
        productInOrderService.saveOrUpdate(productInOrderDto);


            if (productDto.getCount() >= value) {
                productRepository.save(converterDomainToDto.convertToDomain(
                        productDto.setCount(productDto.getCount() - value)));

            }
        else
            new CommonException("Недостаточно товара на складе").getMessage();

        // иначе исключение, дописать (невозможно добавить в ордер товаров больше чем есть на складе...

    }

    @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @Override
    public void deleteFromBucket(SalesOrderDto salesOrderDto, ProductDto productDto, int value) throws Exception{
        ProductInOrderDto productInOrderDto = productInOrderService.findOne(salesOrderDto);
        productInOrderService.delete(productInOrderDto, value);

        if (productInOrderDto.getQuantity() >= value) {
            productInOrderRepository.save(converterDomainToDto.convertToDomain(
                    productInOrderDto.setQuantity(productInOrderDto.getQuantity() - value)));
        }

        // иначе исключение, нельзя удалить из корзины больше чем в ней есть...

        productRepository.save(converterDomainToDto.convertToDomain(
                productDto.setCount(productDto.getCount() + value)));

    }
}
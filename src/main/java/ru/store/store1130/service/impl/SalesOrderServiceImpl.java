package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.SalesOrderStatus;
import ru.store.store1130.db.repository.ProductInOrderRepository;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.db.repository.SalesOrderReposirory;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.SalesOrderDto;

import java.time.LocalDateTime;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    SalesOrderReposirory salesOrderReposirory;
    @Autowired
    ConverterDomainToDto converterDomainToDto;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public Page<SalesOrderDto> getAllOrder(Pageable pageable, String sortBy, String filter, String filterParam) {
        return null;
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
    public SalesOrderDto update(SalesOrderDto salesOrderDto, SalesOrderStatus salesOrderStatus) {
        SalesOrder salesOrder = converterDomainToDto.convertToDomain(salesOrderDto);
      return converterDomainToDto.convertToDto(salesOrderReposirory.save(salesOrder));
    }

    @Override
    public void delete(Long id) {
        SalesOrder salesOrder = salesOrderReposirory.findById(id).get();
        if (salesOrder == null){
            return;
        }
        salesOrderReposirory.delete(salesOrder);
    }


    @Override
    public Page<SalesOrderDto> findByOrderCategory(Pageable pageable, OrderCategory orderCategory) {
        return
                (Page<SalesOrderDto>) converterDomainToDto.convertToDto(salesOrderReposirory.findByOrderCategory(pageable, orderCategory).getContent());

    }

    @Override
    public Page<SalesOrderDto> findByStatus(Pageable pageable, SalesOrderStatus salesOrderStatus) {
        return (Page<SalesOrderDto>) converterDomainToDto.convertToDto(salesOrderReposirory.findByStatus(pageable, salesOrderStatus).getContent());
    }

    @Override
    public Page<SalesOrderDto> findByProduct(Long productStatusId) {
        //return converterDomainToDto.convertToDto(salesOrderReposirory.findByProduct(productStatusId));
        return null;
    }

    @Override
    public Page<SalesOrderDto> findByProductCategory(Long productCategoryId) {
        //return converterDomainToDto.convertToDto(salesOrderReposirory.findByProductCategory(productCategoryId));
        return null;
    }

    @Override
    public Page<SalesOrderDto> findByDate(Pageable pageable, LocalDateTime date) {
        return (Page<SalesOrderDto>) converterDomainToDto.convertToDto(salesOrderReposirory.findByDate(pageable, date).getContent());
    }

    @Override
    public SalesOrderDto addToBucket(SalesOrderDto salesOrderDto, Long productId, int value) {
      //  BucketDto bucketDto = new BucketDto();
        //bucketDto.setProduct(productRepository.findById(productId).orElse(new Product())).setValue(value);
        //bucketRepository.save(converterDomainToDto.convertToDomain(bucketDto));
        //return salesOrderDto.setBucket(converterDomainToDto.convertToDomain(bucketDto));
        return null;
    }

    @Override
    public SalesOrderDto deleteFromBucket(SalesOrderDto salesOrderDto, Long productId) {
  //      ProductDto productDto = converterDomainToDto.convertToDto(productRepository.findById(productId).orElse(new Product()));
    //    int count = 1;
       // int changedValue =
      //          Bucket bucket = bucketRepository.getOne(salesOrderDto.getBucket().getId());

      //         if (bucket.getValue() > 0) {
      //             bucketRepository.save(bucket);
      //         }
      //         else

      //  salesOrderDto.getSalesBucket().get(productDto.getId()) - count;
      //  if (changedValue > 0) {
      //      salesOrderDto.getSalesBucket().put(productId, changedValue);
     //   }
      //  else salesOrderDto.getSalesBucket().remove(productId);
        return salesOrderDto;
    }


}

package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    ProductInOrderRepository productInOrderRepository;

    @Override
    public Page<SalesOrder> findAll(Pageable pageable) {
        return salesOrderReposirory.findAll(pageable);
    }

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
    public SalesOrderDto update(SalesOrderDto salesOrderDto) {
        if (salesOrderDto.getStatus().getText().equals(INPROGRESS.getText()) || salesOrderDto.getStatus().getText().equals(SUBMITED.getText())) {
            SalesOrder salesOrder = converterDomainToDto.convertToDomain(salesOrderDto);
            return converterDomainToDto.convertToDto(salesOrderReposirory.save(salesOrder));
        }
        else return null; //тут что-то надо вернуть, свое исключение?
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

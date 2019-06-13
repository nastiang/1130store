package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.Bucket;
import ru.store.store1130.db.repository.BucketRepository;
import ru.store.store1130.service.BucketService;
import ru.store.store1130.service.dto.BucketDto;

@Service
public class BucketServiceImpl implements BucketService {

    @Autowired
    BucketRepository bucketRepository;
    @Autowired
    ConverterDomainToDto converterDomainToDto;

    @Override
    public BucketDto saveOrUpdate(BucketDto bucketDto) {
        Bucket bucket =
        bucketRepository.findById(converterDomainToDto.convertToDomain(bucketDto).getId()).orElse(new Bucket());
        return converterDomainToDto.convertToDto(bucket);
    }

    @Override
    public void delete(BucketDto bucketDto) {
        bucketRepository.delete(converterDomainToDto.convertToDomain(bucketDto));
    }
}

package ru.store.store1130.service;

import ru.store.store1130.service.dto.BucketDto;

public interface BucketService {
    BucketDto saveOrUpdate(BucketDto bucketDto);
    void delete(BucketDto bucketDto);
}

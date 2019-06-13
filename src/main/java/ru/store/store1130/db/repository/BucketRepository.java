package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

}

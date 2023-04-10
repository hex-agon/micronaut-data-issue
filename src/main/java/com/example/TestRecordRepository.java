package com.example;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.GenericRepository;

import java.util.List;
import java.util.UUID;

@JdbcRepository
public interface TestRecordRepository extends GenericRepository<TestRecord, UUID> {

    List<TestRecord> findAll();

    TestRecord save(String username, byte[] password, String email);

    TestRecord save(TestRecord testRecord);
}

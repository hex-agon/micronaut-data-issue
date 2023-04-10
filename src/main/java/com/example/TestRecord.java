package com.example;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

@MappedEntity("account")
public record TestRecord(
        @Id @AutoPopulated UUID uuid,
        String username,
        String email,
        @GeneratedValue String emailStatus,
        byte[] password,
        @GeneratedValue OffsetDateTime registeredAt
) {

}

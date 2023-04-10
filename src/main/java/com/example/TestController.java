package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class TestController {

    private final TestRecordRepository repository;

    @Inject
    public TestController(TestRecordRepository repository) {
        this.repository = repository;
    }

    @Get("/record")
    @ExecuteOn(TaskExecutors.IO)
    public List<TestRecord> findTestRecord() {
        return repository.findAll();
    }

    @Post("/record")
    @ExecuteOn(TaskExecutors.IO)
    public TestRecord testRecord() {
        return repository.save("abc", "123".getBytes(StandardCharsets.UTF_8), "email@localhost");
    }

    @Post("/record-full")
    @ExecuteOn(TaskExecutors.IO)
    public TestRecord testRecordFull() {
        return repository.save(new TestRecord(null, "abc", "email@localhost", null, "123".getBytes(StandardCharsets.UTF_8), null));
    }
}
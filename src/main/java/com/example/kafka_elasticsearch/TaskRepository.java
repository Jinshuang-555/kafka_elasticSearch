package com.example.kafka_elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskMessage, String> {
    TaskMessage findByTask(String task);
    Iterable<TaskMessage> findAll();
}

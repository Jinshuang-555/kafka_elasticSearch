package com.example.kafka_elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskRepository extends ElasticsearchRepository<TaskMessage, String> {
}

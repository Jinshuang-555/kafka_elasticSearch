package com.example.kafka_elasticsearch.kafkaConsumer;

import com.example.kafka_elasticsearch.ElasticSearch.TaskMessage;
import com.example.kafka_elasticsearch.ElasticSearch.TaskRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaListeners {

    private final TaskRepository taskRepository;

    public KafkaListeners(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @KafkaListener(topics = "sql",groupId = "groupId")
    void listener(TaskMessage message) throws IOException {
        System.out.println(message.getTask());
        System.out.println(message.getSummary());
        taskRepository.save(message);
    }
}

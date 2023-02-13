package com.example.kafka_elasticsearch.ElasticSearch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void save(TaskMessage taskMessage) {
        taskRepository.save(taskMessage);
    }

    public TaskMessage findById(String id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Iterator<TaskMessage> findAll() {
        return taskRepository.findAll().iterator();
    }

}

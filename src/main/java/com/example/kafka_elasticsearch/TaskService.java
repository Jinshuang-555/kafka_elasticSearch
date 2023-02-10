package com.example.kafka_elasticsearch;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(TaskMessage taskMessage) {
        taskRepository.save(taskMessage);
    }

    public TaskMessage findById(String id) {
        return taskRepository.findById(id).orElseThrow();
    }

}

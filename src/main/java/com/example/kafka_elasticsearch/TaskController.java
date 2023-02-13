package com.example.kafka_elasticsearch;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;

    private final ElasticsearchRepository elasticsearchRepository;
    private final TaskRepository taskRepository;


    @PostMapping("")
    public ResponseEntity<String> addIndex(@RequestBody TaskMessage taskMessage) {
        try {
            elasticsearchRepository.save(taskMessage);
            return ResponseEntity.ok("new task document saved with name " + taskMessage.task);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/task")
    public TaskMessage findByTask(@RequestParam String task) {
        return taskRepository.findByTask(task);
    }

    @GetMapping("/all")
    public Iterator<TaskMessage> findAll() {
        return taskRepository.findAll().iterator();
    }

    @GetMapping
    public TaskMessage getIndex(@RequestParam String id) {
        return taskService.findById(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        taskRepository.deleteAll();
        return ResponseEntity.ok("all document deleted");
    }
}

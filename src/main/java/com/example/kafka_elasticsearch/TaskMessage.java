package com.example.kafka_elasticsearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Document(indexName = "tasks")
public class TaskMessage {
    @Id
    String id;

    String listName;
    String task;
    String summary;
    LocalDateTime dueDate;
    int priority;
    String tag;
    public TaskMessage(@JsonProperty("listName") String listName, @JsonProperty("task") String task, @JsonProperty("summary") String summary, @JsonProperty("dueDate") LocalDateTime dueDate, @JsonProperty("priority") int priority, @JsonProperty("tag") String tag) {
        this.listName = listName;
        this.task = task;
        this.summary = summary;
        this.dueDate = dueDate;
        this.priority = priority;
        this.tag = tag;
    }


}

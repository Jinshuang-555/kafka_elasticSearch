package com.example.kafka_elasticsearch.ElasticSearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.time.LocalDateTime;

@Getter
@Setter
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
}

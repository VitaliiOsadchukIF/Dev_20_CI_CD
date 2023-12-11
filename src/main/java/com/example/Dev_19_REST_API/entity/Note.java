package com.example.Dev_19_REST_API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(name = "title", nullable = false)
    private String title;

@Column(name = "content", nullable = false)
private String content;

@Column(name = "create_at", nullable = false)
@Builder.Default
private LocalDateTime createAt = LocalDateTime.now();
}

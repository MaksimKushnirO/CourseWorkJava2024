package com.example.coursework.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.coursework.entity.Player}
 */
public record PlayerCreationDto(String lastName, String firstName, int height, long teamId) implements Serializable {
}
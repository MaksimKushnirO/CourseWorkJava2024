package com.example.coursework.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.coursework.entity.Player}
 */
public record PlayerDto(long id, String lastName, String firstName, int height, long teamId) implements Serializable {
}
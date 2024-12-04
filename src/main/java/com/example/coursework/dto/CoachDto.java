package com.example.coursework.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.coursework.entity.Coach}
 */
public record CoachDto(long id, String firstName, String lastName, long teamId) implements Serializable {
  }
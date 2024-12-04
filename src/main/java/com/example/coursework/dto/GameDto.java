package com.example.coursework.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.coursework.entity.Game}
 */
public record GameDto(long id, LocalDate date_played, String score, long team1Id,
                      long team2Id) implements Serializable {
}
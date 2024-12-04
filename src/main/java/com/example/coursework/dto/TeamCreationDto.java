package com.example.coursework.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.coursework.entity.Team}
 */
public record TeamCreationDto(@NotNull @NotEmpty String teamName, int victories, int defeats, List<PlayerDto> players, List<GameDto> gamesAsTeam1, List<GameDto> gamesAsTeam2, CoachDto coach) implements Serializable {
  }
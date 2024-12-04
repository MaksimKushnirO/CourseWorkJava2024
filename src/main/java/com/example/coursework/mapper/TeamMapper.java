package com.example.coursework.mapper;

import com.example.coursework.dto.TeamCreationDto;
import com.example.coursework.dto.TeamDto;
import com.example.coursework.entity.Coach;
import com.example.coursework.entity.Team;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CoachMapper.class})
public interface TeamMapper {

    Team toEntity(TeamDto teamDto);

    Team toEntity(TeamCreationDto teamCreationDto);

    TeamDto toDto(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team partialUpdate(TeamDto teamDto, @MappingTarget Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team partialUpdate(TeamCreationDto teamCreationDto, @MappingTarget Team team);

    @AfterMapping
    default void linkCoach(@MappingTarget Team team) {
        Coach coach = team.getCoach();
        if (coach != null) {
            coach.setTeam(team);
        }
    }

    @AfterMapping
    default void linkPlayers(@MappingTarget Team team) {
        if (team.getPlayers() != null) {
            team.getPlayers().forEach(player -> player.setTeam(team));
        }
    }
}

package com.example.coursework.mapper;

import com.example.coursework.dto.CoachCreationDto;
import com.example.coursework.dto.CoachDto;
import com.example.coursework.entity.Coach;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CoachMapper {
    @Mapping(source = "teamId", target = "team.id")
    Coach toEntity(CoachDto coachDto);

    @Mapping(source = "team.id", target = "teamId")
    CoachDto toDto(Coach coach);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "teamId", target = "team.id")
    Coach partialUpdate(CoachDto coachDto, @MappingTarget Coach coach);

    @Mapping(source = "teamId", target = "team.id")
    Coach toEntity(CoachCreationDto coachCreatiomDto);

    @Mapping(source = "team.id", target = "teamId")
    CoachCreationDto toDto1(Coach coach);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "teamId", target = "team.id")
    Coach partialUpdate(CoachCreationDto coachCreatiomDto, @MappingTarget Coach coach);
}
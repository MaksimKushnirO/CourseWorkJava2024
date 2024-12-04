package com.example.coursework.mapper;

import com.example.coursework.dto.GameCreationDto;
import com.example.coursework.dto.GameDto;
import com.example.coursework.entity.Game;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {
    @Mapping(source = "team2Id", target = "team2.id")
    @Mapping(source = "team1Id", target = "team1.id")
    Game toEntity(GameDto gameDto);

    @InheritInverseConfiguration(name = "toEntity")
    GameDto toDto(Game game);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Game partialUpdate(GameDto gameDto, @MappingTarget Game game);

    @Mapping(source = "team2Id", target = "team2.id")
    @Mapping(source = "team1Id", target = "team1.id")
    Game toEntity(GameCreationDto gameCreationDto);

    @InheritInverseConfiguration(name = "toEntity")
    GameCreationDto toDto1(Game game);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Game partialUpdate(GameCreationDto gameCreationDto, @MappingTarget Game game);
}
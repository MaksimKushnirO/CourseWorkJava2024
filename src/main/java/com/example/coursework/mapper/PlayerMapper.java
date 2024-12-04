package com.example.coursework.mapper;

import com.example.coursework.dto.PlayerCreationDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Player;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {
    @Mapping(source = "teamId", target = "team.id")
    Player toEntity(PlayerDto playerDto);

    @Mapping(source = "team.id", target = "teamId")
    PlayerDto toDto(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "teamId", target = "team.id")
    Player partialUpdate(PlayerDto playerDto, @MappingTarget Player player);

    @Mapping(source = "teamId", target = "team.id")
    Player toEntity(PlayerCreationDto playerCreationDto);

    @Mapping(source = "team.id", target = "teamId")
    PlayerCreationDto toDto1(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "teamId", target = "team.id")
    Player partialUpdate(PlayerCreationDto playerCreationDto, @MappingTarget Player player);
}
package com.example.coursework.mapper;

import com.example.coursework.dto.PlayerCreationDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Player;
import com.example.coursework.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T23:38:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player toEntity(PlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setTeam( playerDtoToTeam( playerDto ) );
        player.setId( playerDto.id() );
        player.setLastName( playerDto.lastName() );
        player.setFirstName( playerDto.firstName() );
        player.setHeight( playerDto.height() );

        return player;
    }

    @Override
    public PlayerDto toDto(Player player) {
        if ( player == null ) {
            return null;
        }

        long teamId = 0L;
        long id = 0L;
        String lastName = null;
        String firstName = null;
        int height = 0;

        teamId = playerTeamId( player );
        id = player.getId();
        lastName = player.getLastName();
        firstName = player.getFirstName();
        height = player.getHeight();

        PlayerDto playerDto = new PlayerDto( id, lastName, firstName, height, teamId );

        return playerDto;
    }

    @Override
    public Player partialUpdate(PlayerDto playerDto, Player player) {
        if ( playerDto == null ) {
            return player;
        }

        if ( player.getTeam() == null ) {
            player.setTeam( new Team() );
        }
        playerDtoToTeam1( playerDto, player.getTeam() );
        player.setId( playerDto.id() );
        if ( playerDto.lastName() != null ) {
            player.setLastName( playerDto.lastName() );
        }
        if ( playerDto.firstName() != null ) {
            player.setFirstName( playerDto.firstName() );
        }
        player.setHeight( playerDto.height() );

        return player;
    }

    @Override
    public Player toEntity(PlayerCreationDto playerCreationDto) {
        if ( playerCreationDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setTeam( playerCreationDtoToTeam( playerCreationDto ) );
        player.setLastName( playerCreationDto.lastName() );
        player.setFirstName( playerCreationDto.firstName() );
        player.setHeight( playerCreationDto.height() );

        return player;
    }

    @Override
    public PlayerCreationDto toDto1(Player player) {
        if ( player == null ) {
            return null;
        }

        long teamId = 0L;
        String lastName = null;
        String firstName = null;
        int height = 0;

        teamId = playerTeamId( player );
        lastName = player.getLastName();
        firstName = player.getFirstName();
        height = player.getHeight();

        PlayerCreationDto playerCreationDto = new PlayerCreationDto( lastName, firstName, height, teamId );

        return playerCreationDto;
    }

    @Override
    public Player partialUpdate(PlayerCreationDto playerCreationDto, Player player) {
        if ( playerCreationDto == null ) {
            return player;
        }

        if ( player.getTeam() == null ) {
            player.setTeam( new Team() );
        }
        playerCreationDtoToTeam1( playerCreationDto, player.getTeam() );
        if ( playerCreationDto.lastName() != null ) {
            player.setLastName( playerCreationDto.lastName() );
        }
        if ( playerCreationDto.firstName() != null ) {
            player.setFirstName( playerCreationDto.firstName() );
        }
        player.setHeight( playerCreationDto.height() );

        return player;
    }

    protected Team playerDtoToTeam(PlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( playerDto.teamId() );

        return team;
    }

    private long playerTeamId(Player player) {
        if ( player == null ) {
            return 0L;
        }
        Team team = player.getTeam();
        if ( team == null ) {
            return 0L;
        }
        long id = team.getId();
        return id;
    }

    protected void playerDtoToTeam1(PlayerDto playerDto, Team mappingTarget) {
        if ( playerDto == null ) {
            return;
        }

        mappingTarget.setId( playerDto.teamId() );
    }

    protected Team playerCreationDtoToTeam(PlayerCreationDto playerCreationDto) {
        if ( playerCreationDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( playerCreationDto.teamId() );

        return team;
    }

    protected void playerCreationDtoToTeam1(PlayerCreationDto playerCreationDto, Team mappingTarget) {
        if ( playerCreationDto == null ) {
            return;
        }

        mappingTarget.setId( playerCreationDto.teamId() );
    }
}

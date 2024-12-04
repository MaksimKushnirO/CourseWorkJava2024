package com.example.coursework.mapper;

import com.example.coursework.dto.GameCreationDto;
import com.example.coursework.dto.GameDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Team;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T19:48:42+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class GameMapperImpl implements GameMapper {

    @Override
    public Game toEntity(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setTeam2( gameDtoToTeam( gameDto ) );
        game.setTeam1( gameDtoToTeam1( gameDto ) );
        game.setId( gameDto.id() );
        game.setDate_played( gameDto.date_played() );
        game.setScore( gameDto.score() );

        return game;
    }

    @Override
    public GameDto toDto(Game game) {
        if ( game == null ) {
            return null;
        }

        long team2Id = 0L;
        long team1Id = 0L;
        long id = 0L;
        LocalDate date_played = null;
        String score = null;

        team2Id = gameTeam2Id( game );
        team1Id = gameTeam1Id( game );
        id = game.getId();
        date_played = game.getDate_played();
        score = game.getScore();

        GameDto gameDto = new GameDto( id, date_played, score, team1Id, team2Id );

        return gameDto;
    }

    @Override
    public Game partialUpdate(GameDto gameDto, Game game) {
        if ( gameDto == null ) {
            return game;
        }

        if ( game.getTeam2() == null ) {
            game.setTeam2( new Team() );
        }
        gameDtoToTeam2( gameDto, game.getTeam2() );
        if ( game.getTeam1() == null ) {
            game.setTeam1( new Team() );
        }
        gameDtoToTeam3( gameDto, game.getTeam1() );
        game.setId( gameDto.id() );
        if ( gameDto.date_played() != null ) {
            game.setDate_played( gameDto.date_played() );
        }
        if ( gameDto.score() != null ) {
            game.setScore( gameDto.score() );
        }

        return game;
    }

    @Override
    public Game toEntity(GameCreationDto gameCreationDto) {
        if ( gameCreationDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setTeam2( gameCreationDtoToTeam( gameCreationDto ) );
        game.setTeam1( gameCreationDtoToTeam1( gameCreationDto ) );
        game.setDate_played( gameCreationDto.date_played() );
        game.setScore( gameCreationDto.score() );

        return game;
    }

    @Override
    public GameCreationDto toDto1(Game game) {
        if ( game == null ) {
            return null;
        }

        long team2Id = 0L;
        long team1Id = 0L;
        LocalDate date_played = null;
        String score = null;

        team2Id = gameTeam2Id( game );
        team1Id = gameTeam1Id( game );
        date_played = game.getDate_played();
        score = game.getScore();

        GameCreationDto gameCreationDto = new GameCreationDto( date_played, score, team1Id, team2Id );

        return gameCreationDto;
    }

    @Override
    public Game partialUpdate(GameCreationDto gameCreationDto, Game game) {
        if ( gameCreationDto == null ) {
            return game;
        }

        if ( game.getTeam2() == null ) {
            game.setTeam2( new Team() );
        }
        gameCreationDtoToTeam2( gameCreationDto, game.getTeam2() );
        if ( game.getTeam1() == null ) {
            game.setTeam1( new Team() );
        }
        gameCreationDtoToTeam3( gameCreationDto, game.getTeam1() );
        if ( gameCreationDto.date_played() != null ) {
            game.setDate_played( gameCreationDto.date_played() );
        }
        if ( gameCreationDto.score() != null ) {
            game.setScore( gameCreationDto.score() );
        }

        return game;
    }

    protected Team gameDtoToTeam(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gameDto.team2Id() );

        return team;
    }

    protected Team gameDtoToTeam1(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gameDto.team1Id() );

        return team;
    }

    private long gameTeam2Id(Game game) {
        if ( game == null ) {
            return 0L;
        }
        Team team2 = game.getTeam2();
        if ( team2 == null ) {
            return 0L;
        }
        long id = team2.getId();
        return id;
    }

    private long gameTeam1Id(Game game) {
        if ( game == null ) {
            return 0L;
        }
        Team team1 = game.getTeam1();
        if ( team1 == null ) {
            return 0L;
        }
        long id = team1.getId();
        return id;
    }

    protected void gameDtoToTeam2(GameDto gameDto, Team mappingTarget) {
        if ( gameDto == null ) {
            return;
        }

        mappingTarget.setId( gameDto.team2Id() );
    }

    protected void gameDtoToTeam3(GameDto gameDto, Team mappingTarget) {
        if ( gameDto == null ) {
            return;
        }

        mappingTarget.setId( gameDto.team1Id() );
    }

    protected Team gameCreationDtoToTeam(GameCreationDto gameCreationDto) {
        if ( gameCreationDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gameCreationDto.team2Id() );

        return team;
    }

    protected Team gameCreationDtoToTeam1(GameCreationDto gameCreationDto) {
        if ( gameCreationDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gameCreationDto.team1Id() );

        return team;
    }

    protected void gameCreationDtoToTeam2(GameCreationDto gameCreationDto, Team mappingTarget) {
        if ( gameCreationDto == null ) {
            return;
        }

        mappingTarget.setId( gameCreationDto.team2Id() );
    }

    protected void gameCreationDtoToTeam3(GameCreationDto gameCreationDto, Team mappingTarget) {
        if ( gameCreationDto == null ) {
            return;
        }

        mappingTarget.setId( gameCreationDto.team1Id() );
    }
}

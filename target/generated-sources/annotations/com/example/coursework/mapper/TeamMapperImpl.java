package com.example.coursework.mapper;

import com.example.coursework.dto.CoachDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.dto.TeamCreationDto;
import com.example.coursework.dto.TeamDto;
import com.example.coursework.entity.Coach;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Player;
import com.example.coursework.entity.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T00:52:56+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Autowired
    private CoachMapper coachMapper;

    @Override
    public Team toEntity(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamDto.id() );
        team.setTeamName( teamDto.teamName() );
        team.setVictories( teamDto.victories() );
        team.setDefeats( teamDto.defeats() );
        team.setPlayers( playerDtoListToPlayerList( teamDto.players() ) );
        team.setGamesAsTeam1( gameDtoListToGameList( teamDto.gamesAsTeam1() ) );
        team.setGamesAsTeam2( gameDtoListToGameList( teamDto.gamesAsTeam2() ) );
        team.setCoach( coachMapper.toEntity( teamDto.coach() ) );

        linkCoach( team );
        linkPlayers( team );

        return team;
    }

    @Override
    public Team toEntity(TeamCreationDto teamCreationDto) {
        if ( teamCreationDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( teamCreationDto.teamName() );
        team.setVictories( teamCreationDto.victories() );
        team.setDefeats( teamCreationDto.defeats() );
        team.setPlayers( playerDtoListToPlayerList( teamCreationDto.players() ) );
        team.setGamesAsTeam1( gameDtoListToGameList( teamCreationDto.gamesAsTeam1() ) );
        team.setGamesAsTeam2( gameDtoListToGameList( teamCreationDto.gamesAsTeam2() ) );
        team.setCoach( coachMapper.toEntity( teamCreationDto.coach() ) );

        linkCoach( team );
        linkPlayers( team );

        return team;
    }

    @Override
    public TeamDto toDto(Team team) {
        if ( team == null ) {
            return null;
        }

        long id = 0L;
        String teamName = null;
        int victories = 0;
        int defeats = 0;
        List<PlayerDto> players = null;
        List<GameDto> gamesAsTeam1 = null;
        List<GameDto> gamesAsTeam2 = null;
        CoachDto coach = null;

        id = team.getId();
        teamName = team.getTeamName();
        victories = team.getVictories();
        defeats = team.getDefeats();
        players = playerListToPlayerDtoList( team.getPlayers() );
        gamesAsTeam1 = gameListToGameDtoList( team.getGamesAsTeam1() );
        gamesAsTeam2 = gameListToGameDtoList( team.getGamesAsTeam2() );
        coach = coachMapper.toDto( team.getCoach() );

        TeamDto teamDto = new TeamDto( id, teamName, victories, defeats, players, gamesAsTeam1, gamesAsTeam2, coach );

        return teamDto;
    }

    @Override
    public Team partialUpdate(TeamDto teamDto, Team team) {
        if ( teamDto == null ) {
            return team;
        }

        team.setId( teamDto.id() );
        if ( teamDto.teamName() != null ) {
            team.setTeamName( teamDto.teamName() );
        }
        team.setVictories( teamDto.victories() );
        team.setDefeats( teamDto.defeats() );
        if ( team.getPlayers() != null ) {
            List<Player> list = playerDtoListToPlayerList( teamDto.players() );
            if ( list != null ) {
                team.getPlayers().clear();
                team.getPlayers().addAll( list );
            }
        }
        else {
            List<Player> list = playerDtoListToPlayerList( teamDto.players() );
            if ( list != null ) {
                team.setPlayers( list );
            }
        }
        if ( team.getGamesAsTeam1() != null ) {
            List<Game> list1 = gameDtoListToGameList( teamDto.gamesAsTeam1() );
            if ( list1 != null ) {
                team.getGamesAsTeam1().clear();
                team.getGamesAsTeam1().addAll( list1 );
            }
        }
        else {
            List<Game> list1 = gameDtoListToGameList( teamDto.gamesAsTeam1() );
            if ( list1 != null ) {
                team.setGamesAsTeam1( list1 );
            }
        }
        if ( team.getGamesAsTeam2() != null ) {
            List<Game> list2 = gameDtoListToGameList( teamDto.gamesAsTeam2() );
            if ( list2 != null ) {
                team.getGamesAsTeam2().clear();
                team.getGamesAsTeam2().addAll( list2 );
            }
        }
        else {
            List<Game> list2 = gameDtoListToGameList( teamDto.gamesAsTeam2() );
            if ( list2 != null ) {
                team.setGamesAsTeam2( list2 );
            }
        }
        if ( teamDto.coach() != null ) {
            if ( team.getCoach() == null ) {
                team.setCoach( new Coach() );
            }
            coachMapper.partialUpdate( teamDto.coach(), team.getCoach() );
        }

        linkCoach( team );
        linkPlayers( team );

        return team;
    }

    @Override
    public Team partialUpdate(TeamCreationDto teamCreationDto, Team team) {
        if ( teamCreationDto == null ) {
            return team;
        }

        if ( teamCreationDto.teamName() != null ) {
            team.setTeamName( teamCreationDto.teamName() );
        }
        team.setVictories( teamCreationDto.victories() );
        team.setDefeats( teamCreationDto.defeats() );
        if ( team.getPlayers() != null ) {
            List<Player> list = playerDtoListToPlayerList( teamCreationDto.players() );
            if ( list != null ) {
                team.getPlayers().clear();
                team.getPlayers().addAll( list );
            }
        }
        else {
            List<Player> list = playerDtoListToPlayerList( teamCreationDto.players() );
            if ( list != null ) {
                team.setPlayers( list );
            }
        }
        if ( team.getGamesAsTeam1() != null ) {
            List<Game> list1 = gameDtoListToGameList( teamCreationDto.gamesAsTeam1() );
            if ( list1 != null ) {
                team.getGamesAsTeam1().clear();
                team.getGamesAsTeam1().addAll( list1 );
            }
        }
        else {
            List<Game> list1 = gameDtoListToGameList( teamCreationDto.gamesAsTeam1() );
            if ( list1 != null ) {
                team.setGamesAsTeam1( list1 );
            }
        }
        if ( team.getGamesAsTeam2() != null ) {
            List<Game> list2 = gameDtoListToGameList( teamCreationDto.gamesAsTeam2() );
            if ( list2 != null ) {
                team.getGamesAsTeam2().clear();
                team.getGamesAsTeam2().addAll( list2 );
            }
        }
        else {
            List<Game> list2 = gameDtoListToGameList( teamCreationDto.gamesAsTeam2() );
            if ( list2 != null ) {
                team.setGamesAsTeam2( list2 );
            }
        }
        if ( teamCreationDto.coach() != null ) {
            if ( team.getCoach() == null ) {
                team.setCoach( new Coach() );
            }
            coachMapper.partialUpdate( teamCreationDto.coach(), team.getCoach() );
        }

        linkCoach( team );
        linkPlayers( team );

        return team;
    }

    protected Player playerDtoToPlayer(PlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( playerDto.id() );
        player.setLastName( playerDto.lastName() );
        player.setFirstName( playerDto.firstName() );
        player.setHeight( playerDto.height() );

        return player;
    }

    protected List<Player> playerDtoListToPlayerList(List<PlayerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Player> list1 = new ArrayList<Player>( list.size() );
        for ( PlayerDto playerDto : list ) {
            list1.add( playerDtoToPlayer( playerDto ) );
        }

        return list1;
    }

    protected Game gameDtoToGame(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setId( gameDto.id() );
        game.setDate_played( gameDto.date_played() );
        game.setTeam1( toEntity( gameDto.team1() ) );
        game.setTeam2( toEntity( gameDto.team2() ) );

        return game;
    }

    protected List<Game> gameDtoListToGameList(List<GameDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Game> list1 = new ArrayList<Game>( list.size() );
        for ( GameDto gameDto : list ) {
            list1.add( gameDtoToGame( gameDto ) );
        }

        return list1;
    }

    protected PlayerDto playerToPlayerDto(Player player) {
        if ( player == null ) {
            return null;
        }

        long id = 0L;
        String lastName = null;
        String firstName = null;
        int height = 0;

        id = player.getId();
        lastName = player.getLastName();
        firstName = player.getFirstName();
        height = player.getHeight();

        long teamId = 0L;

        PlayerDto playerDto = new PlayerDto( id, lastName, firstName, height, teamId );

        return playerDto;
    }

    protected List<PlayerDto> playerListToPlayerDtoList(List<Player> list) {
        if ( list == null ) {
            return null;
        }

        List<PlayerDto> list1 = new ArrayList<PlayerDto>( list.size() );
        for ( Player player : list ) {
            list1.add( playerToPlayerDto( player ) );
        }

        return list1;
    }

    protected GameDto gameToGameDto(Game game) {
        if ( game == null ) {
            return null;
        }

        long id = 0L;
        LocalDate date_played = null;
        TeamDto team1 = null;
        TeamDto team2 = null;

        id = game.getId();
        date_played = game.getDate_played();
        team1 = toDto( game.getTeam1() );
        team2 = toDto( game.getTeam2() );

        GameDto gameDto = new GameDto( id, date_played, team1, team2 );

        return gameDto;
    }

    protected List<GameDto> gameListToGameDtoList(List<Game> list) {
        if ( list == null ) {
            return null;
        }

        List<GameDto> list1 = new ArrayList<GameDto>( list.size() );
        for ( Game game : list ) {
            list1.add( gameToGameDto( game ) );
        }

        return list1;
    }
}

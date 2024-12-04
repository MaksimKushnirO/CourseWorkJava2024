package com.example.coursework.mapper;

import com.example.coursework.dto.CoachCreationDto;
import com.example.coursework.dto.CoachDto;
import com.example.coursework.entity.Coach;
import com.example.coursework.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T00:52:56+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class CoachMapperImpl implements CoachMapper {

    @Override
    public Coach toEntity(CoachDto coachDto) {
        if ( coachDto == null ) {
            return null;
        }

        Coach coach = new Coach();

        coach.setTeam( coachDtoToTeam( coachDto ) );
        coach.setId( coachDto.id() );
        coach.setFirstName( coachDto.firstName() );
        coach.setLastName( coachDto.lastName() );

        return coach;
    }

    @Override
    public CoachDto toDto(Coach coach) {
        if ( coach == null ) {
            return null;
        }

        long teamId = 0L;
        long id = 0L;
        String firstName = null;
        String lastName = null;

        teamId = coachTeamId( coach );
        id = coach.getId();
        firstName = coach.getFirstName();
        lastName = coach.getLastName();

        CoachDto coachDto = new CoachDto( id, firstName, lastName, teamId );

        return coachDto;
    }

    @Override
    public Coach partialUpdate(CoachDto coachDto, Coach coach) {
        if ( coachDto == null ) {
            return coach;
        }

        if ( coach.getTeam() == null ) {
            coach.setTeam( new Team() );
        }
        coachDtoToTeam1( coachDto, coach.getTeam() );
        coach.setId( coachDto.id() );
        if ( coachDto.firstName() != null ) {
            coach.setFirstName( coachDto.firstName() );
        }
        if ( coachDto.lastName() != null ) {
            coach.setLastName( coachDto.lastName() );
        }

        return coach;
    }

    @Override
    public Coach toEntity(CoachCreationDto coachCreatiomDto) {
        if ( coachCreatiomDto == null ) {
            return null;
        }

        Coach coach = new Coach();

        coach.setTeam( coachCreationDtoToTeam( coachCreatiomDto ) );
        coach.setFirstName( coachCreatiomDto.firstName() );
        coach.setLastName( coachCreatiomDto.lastName() );

        return coach;
    }

    @Override
    public CoachCreationDto toDto1(Coach coach) {
        if ( coach == null ) {
            return null;
        }

        long teamId = 0L;
        String firstName = null;
        String lastName = null;

        teamId = coachTeamId( coach );
        firstName = coach.getFirstName();
        lastName = coach.getLastName();

        CoachCreationDto coachCreationDto = new CoachCreationDto( firstName, lastName, teamId );

        return coachCreationDto;
    }

    @Override
    public Coach partialUpdate(CoachCreationDto coachCreatiomDto, Coach coach) {
        if ( coachCreatiomDto == null ) {
            return coach;
        }

        if ( coach.getTeam() == null ) {
            coach.setTeam( new Team() );
        }
        coachCreationDtoToTeam1( coachCreatiomDto, coach.getTeam() );
        if ( coachCreatiomDto.firstName() != null ) {
            coach.setFirstName( coachCreatiomDto.firstName() );
        }
        if ( coachCreatiomDto.lastName() != null ) {
            coach.setLastName( coachCreatiomDto.lastName() );
        }

        return coach;
    }

    protected Team coachDtoToTeam(CoachDto coachDto) {
        if ( coachDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( coachDto.teamId() );

        return team;
    }

    private long coachTeamId(Coach coach) {
        if ( coach == null ) {
            return 0L;
        }
        Team team = coach.getTeam();
        if ( team == null ) {
            return 0L;
        }
        long id = team.getId();
        return id;
    }

    protected void coachDtoToTeam1(CoachDto coachDto, Team mappingTarget) {
        if ( coachDto == null ) {
            return;
        }

        mappingTarget.setId( coachDto.teamId() );
    }

    protected Team coachCreationDtoToTeam(CoachCreationDto coachCreationDto) {
        if ( coachCreationDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( coachCreationDto.teamId() );

        return team;
    }

    protected void coachCreationDtoToTeam1(CoachCreationDto coachCreationDto, Team mappingTarget) {
        if ( coachCreationDto == null ) {
            return;
        }

        mappingTarget.setId( coachCreationDto.teamId() );
    }
}

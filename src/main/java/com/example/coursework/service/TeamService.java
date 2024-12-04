package com.example.coursework.service;

import com.example.coursework.dto.TeamCreationDto;
import com.example.coursework.dto.TeamDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Team;
import com.example.coursework.mapper.TeamMapper;
import com.example.coursework.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Transactional
    public TeamDto create(TeamCreationDto teamCreationDto){
        return teamMapper.toDto(teamRepository.save(teamMapper.toEntity(teamCreationDto)));
    }

    public TeamDto getById(Long id){
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return teamMapper.toDto(team);
    }

    @Transactional
    public void delete(Long id){
        if (!teamRepository.existsById(id)) {
            throw new RuntimeException("Team with ID " + id + " not found");
        }
        teamRepository.deleteById(id);
    }

    public Page<TeamDto> getAll(int page, int size){
        Page<Team> teams = teamRepository.findAll(PageRequest.of(page, size));
        return teams.map(teamMapper::toDto);
    }

    @Transactional
    public TeamDto update(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        // Логування для перевірки отриманих даних
        System.out.println("Updating team: " + team);

        team.setTeamName(teamDto.teamName());
        team.setVictories(teamDto.victories());
        team.setDefeats(teamDto.defeats());

        // Збереження та повернення DTO
        return teamMapper.toDto(teamRepository.save(team));
    }

}

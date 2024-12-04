package com.example.coursework.service;


import com.example.coursework.dto.CoachCreationDto;
import com.example.coursework.dto.CoachDto;
import com.example.coursework.entity.Coach;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Team;
import com.example.coursework.mapper.CoachMapper;
import com.example.coursework.repository.CoachRepository;
import com.example.coursework.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;
    private final TeamRepository teamRepository;

    @Transactional
    public CoachDto create(CoachCreationDto coachCreationDto){
        return coachMapper.toDto(coachRepository.save(coachMapper.toEntity(coachCreationDto)));
    }

    public CoachDto getById(Long id){
        Coach coach = coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return coachMapper.toDto(coach);
    }

    @Transactional
    public void delete(Long id){
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach with ID " + id + " not found"));


        if (coach.getTeam() != null) {
            coach.getTeam().setCoach(null);
            coach.setTeam(null);
        }
        coachRepository.deleteById(id);
    }

    public Page<CoachDto> getAll(int page, int size){
        Page<Coach> coaches = coachRepository.findAll(PageRequest.of(page, size));
        return coaches.map(coachMapper::toDto);
    }

    @Transactional
    public CoachDto update(Long id, CoachDto coachDto) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach not found"));

        if (coachDto.firstName() != null && !coachDto.firstName().isEmpty()) {
            coach.setFirstName(coachDto.firstName());
        }
        if (coachDto.lastName() != null && !coachDto.lastName().isEmpty()) {
            coach.setLastName(coachDto.lastName());
        }
        if (coachDto.teamId() != 0) {
            Team team = teamRepository.findById(coachDto.teamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            coach.setTeam(team);
        } else {
            coach.setTeam(null);
        }

        Coach updatedCoach = coachRepository.save(coach);
        return coachMapper.toDto(updatedCoach);
    }

}

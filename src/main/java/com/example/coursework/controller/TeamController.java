package com.example.coursework.controller;


import com.example.coursework.dto.TeamCreationDto;
import com.example.coursework.dto.TeamDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Team;
import com.example.coursework.repository.TeamRepository;
import com.example.coursework.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamRepository teamRepository;
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamCreationDto teamCreationDto){
        return new ResponseEntity(teamService.create(teamCreationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(teamService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public Page<TeamDto> getAllTeams(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return teamService.getAll(page,size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Long id){
        try {
            teamService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        try {
            TeamDto updatedTeam = teamService.update(id, teamDto);
            return ResponseEntity.ok(updatedTeam);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

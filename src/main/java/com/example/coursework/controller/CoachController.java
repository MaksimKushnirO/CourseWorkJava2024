package com.example.coursework.controller;

import com.example.coursework.dto.CoachCreationDto;
import com.example.coursework.dto.CoachDto;
import com.example.coursework.entity.Coach;
import com.example.coursework.entity.Game;
import com.example.coursework.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coaches")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;
    @PostMapping
    public ResponseEntity<CoachDto> createCoach(@RequestBody CoachCreationDto coachCreationDto){
        return new ResponseEntity(coachService.create(coachCreationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDto> getCoahById(@PathVariable Long id){
        try {
            return  ResponseEntity.ok(coachService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public Page<CoachDto> getAllCoach(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return coachService.getAll(page,size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id){
        try {
            coachService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachDto> updateCoach(@PathVariable Long id, @RequestBody CoachDto coachDto) {
        try {
            CoachDto updatedCoach = coachService.update(id, coachDto);
            return ResponseEntity.ok(updatedCoach);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

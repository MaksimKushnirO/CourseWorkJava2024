package com.example.coursework.controller;


import com.example.coursework.dto.GameCreationDto;
import com.example.coursework.dto.GameDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Game;
import com.example.coursework.repository.GameRepository;
import com.example.coursework.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameRepository gameRepository;
    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameDto> createCoach(@RequestBody GameCreationDto gameCreationDto){
        return new ResponseEntity(gameService.create(gameCreationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(gameService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public Page<GameDto> getAllGame(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return gameService.getAll(page,size);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable Long id){
        try {
            gameService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable Long id, @RequestBody GameDto gameDto) {
        try {
            GameDto updatedGame = gameService.update(id, gameDto);
            return ResponseEntity.ok(updatedGame);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

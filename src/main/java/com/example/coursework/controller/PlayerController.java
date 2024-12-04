package com.example.coursework.controller;


import com.example.coursework.dto.PlayerCreationDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Player;
import com.example.coursework.repository.PlayersRepository;
import com.example.coursework.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayersRepository playersRepository;
    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerCreationDto playerCreationDto){
        return new ResponseEntity(playerService.create(playerCreationDto), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<PlayerDto> getAllPlayers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return playerService.getAll(page,size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(playerService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id,@RequestBody PlayerDto playerDto){
        try {
            return new ResponseEntity(playerService.update(id,playerDto), HttpStatus.OK);
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id){
        try {
            playerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

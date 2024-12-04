package com.example.coursework.service;

import com.example.coursework.dto.GameCreationDto;
import com.example.coursework.dto.GameDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Player;
import com.example.coursework.entity.Team;
import com.example.coursework.mapper.GameMapper;
import com.example.coursework.repository.GameRepository;
import com.example.coursework.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final TeamRepository teamRepository;

    public Page<GameDto> getAll(int page, int size){
        Page<Game> games  = gameRepository.findAll(PageRequest.of(page, size));
        return games.map(gameMapper::toDto);
    }

    @Transactional
    public GameDto create(GameCreationDto gameCreationDto){

        return gameMapper.toDto(gameRepository.save(gameMapper.toEntity(gameCreationDto)));
    }

    public GameDto getById(long id){
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return gameMapper.toDto(game);
    }

    @Transactional
    public void delete(Long id){
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Game with ID " + id + " not found");
        }
        gameRepository.deleteById(id);
    }

    @Transactional
    public GameDto update(Long id, GameDto gameDto) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));


        game.setDate_played(gameDto.date_played());

        if (!gameDto.score().isEmpty()) {
            game.setScore(gameDto.score());
        }
        if (gameDto.team1Id() != 0) {
            Team team1 = teamRepository.findById(gameDto.team1Id())
                    .orElseThrow(() -> new RuntimeException("Team1 not found"));
            game.setTeam1(team1);
        }
        if (gameDto.team2Id() != 0) {
            Team team2 = teamRepository.findById(gameDto.team2Id())
                    .orElseThrow(() -> new RuntimeException("Team2 not found"));
            game.setTeam2(team2);
        }

        Game updatedGame = gameRepository.save(game);
        return gameMapper.toDto(updatedGame);
    }


}

package com.example.coursework.service;



import com.example.coursework.dto.PlayerCreationDto;
import com.example.coursework.dto.PlayerDto;
import com.example.coursework.entity.Game;
import com.example.coursework.entity.Player;
import com.example.coursework.entity.Team;
import com.example.coursework.mapper.PlayerMapper;
import com.example.coursework.repository.GameRepository;
import com.example.coursework.repository.PlayersRepository;
import com.example.coursework.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayersRepository playersRepository;
    private final PlayerMapper playerMapper;
    private final TeamRepository teamRepository;

    @Transactional
    public PlayerDto create(PlayerCreationDto playerCreationDto){
        return playerMapper.toDto(playersRepository.save(playerMapper.toEntity(playerCreationDto)));
    }


    public PlayerDto getById(long id){
        Player player = playersRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return playerMapper.toDto(player);
    }

    public Page<PlayerDto> getAll(int page, int size){
        Page<Player> players = playersRepository.findAll(PageRequest.of(page, size));
        return players.map(playerMapper::toDto);
    }

    @Transactional
    public PlayerDto update(Long id, PlayerDto playerDto) {

        Player player = playersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        if (playerDto.firstName() != null && !playerDto.firstName().isEmpty()) {
            player.setFirstName(playerDto.firstName());
        }
        if (playerDto.lastName() != null && !playerDto.lastName().isEmpty()) {
            player.setLastName(playerDto.lastName());
        }
        if (playerDto.height() > 0) {
            player.setHeight(playerDto.height());
        }
        if (playerDto.teamId() > 0) {
            Team team = teamRepository.findById(playerDto.teamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            player.setTeam(team);
        } else {
            player.setTeam(null);
        }


        Player updatedPlayer = playersRepository.save(player);
        return playerMapper.toDto(updatedPlayer);
    }

    @Transactional
    public void delete(Long id){
        if (!playersRepository.existsById(id)) {
            throw new RuntimeException("Player with ID " + id + " not found");
        }
        playersRepository.deleteById(id);
    }
}

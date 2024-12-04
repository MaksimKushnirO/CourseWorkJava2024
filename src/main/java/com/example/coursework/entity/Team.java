package com.example.coursework.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties({"players", "gamesAsTeam1", "gamesAsTeam2", "coach"})
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "victories")
    private int victories;

    @Column(name = "defeats")
    private int defeats;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Player> players;


    @OneToMany(mappedBy = "team1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> gamesAsTeam1;

    @OneToMany(mappedBy = "team2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> gamesAsTeam2;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private Coach coach;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", victories=" + victories +
                ", defeats=" + defeats +
                '}';
    }
}

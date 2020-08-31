package com.codegym.repository;

import com.codegym.model.Player;
import com.codegym.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player,Long> {
    Player findFirstByIdentity(String identity);
    Iterable<Player> findAllByTeam(Team team);
    void deleteAllByTeam(Team team);
}

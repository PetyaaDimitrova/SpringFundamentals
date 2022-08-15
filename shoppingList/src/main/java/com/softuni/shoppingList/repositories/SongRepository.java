package com.softuni.shoppingList.repositories;

import com.softuni.shoppingList.models.Song;
import com.softuni.shoppingList.models.dtos.SongDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    Optional<Song> findByTitle(String title);

    List<Song> findByUserId(long loggedUserId);

    List<SongDTO> findByOrderByTitleAsc();
}

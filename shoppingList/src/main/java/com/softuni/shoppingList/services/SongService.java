package com.softuni.shoppingList.services;

import com.softuni.shoppingList.models.Song;
import com.softuni.shoppingList.models.Style;
import com.softuni.shoppingList.models.StyleName;
import com.softuni.shoppingList.models.User;
import com.softuni.shoppingList.models.dtos.AddSongDTO;
import com.softuni.shoppingList.models.dtos.SongDTO;
import com.softuni.shoppingList.repositories.SongRepository;
import com.softuni.shoppingList.repositories.StyleRepository;
import com.softuni.shoppingList.repositories.UserRepository;
import com.softuni.shoppingList.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public SongService(SongRepository songRepository, StyleRepository styleRepository,
                       LoggedUser loggedUser, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean addSong(AddSongDTO addSongDTO) {

        Optional<Song> byName =
                this.songRepository.findByTitle(addSongDTO.getTitle());

        if (byName.isPresent()) {
            return false;
        }

        StyleName styleName = switch (addSongDTO.getStyle()) {
            case 0 -> StyleName.POP;
            case 1 -> StyleName.ROCK;
            case 2 -> StyleName.JAZZ;
            default -> StyleName.POP;
        };

        Style style = this.styleRepository.findByStyleName(styleName);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Song song = new Song();

        song.setDuration(addSongDTO.getDuration());
        song.setPerformer(addSongDTO.getPerformer());
        song.setUser(owner.get());
        song.setReleaseDate(addSongDTO.getReleaseDate());
        song.setStyle(style);
        song.setTitle(addSongDTO.getTitle());

        this.songRepository.save(song);

        return true;
    }



    public List<SongDTO> getAllSongs() {
        return this.songRepository.findByOrderByTitleAsc().stream().map(SongDTO::new).collect(Collectors.toList());
    }

}

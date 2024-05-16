package com.example.atv6.controllers;

import com.example.atv6.models.Weapon;
import com.example.atv6.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class AtvController {

    //registro do usuario
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody Map<String, String> user) {

        Map<String, String> createdUser = new HashMap<>();
        createdUser.put("id", "1");
        createdUser.put("nome", user.get("nome"));
        createdUser.put("email", user.get("email"));

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //leitura usuario
    @GetMapping("/{id}")
    public ResponseEntity<Object> readUser(@PathVariable String id) {
        Map<String, String> user = new HashMap<>();
        user.put("id", id);
        user.put("nome", "Nome");
        user.put("email", "exemplo@email.com");

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    //atualizacao usuario
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable String id, @RequestBody Map<String, String> user) {
        Map<String, String> updateUser = new HashMap<>();
        updateUser.put("id", id);
        updateUser.put("nome", user.get("nome"));
        updateUser.put("email", user.get("email"));

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    //excluir usuer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //criar playlist
    @PostMapping("/{id}/playlist")
    public ResponseEntity<Object> createPlaylist(@PathVariable String id, @RequestBody Map<String, String> playlist) {
        Map<String, String> createdPlaylist = new HashMap<>();
        createdPlaylist.put("id", "1");
        createdPlaylist.put("nome", playlist.get("nome"));
        createdPlaylist.put("usuarioId", id);

        return new ResponseEntity<>(createdPlaylist, HttpStatus.CREATED);
    }

    //ler playlist
    @GetMapping("/{id}/playlist/{playlist_id}")
    public ResponseEntity<Object> readPlaylist(@PathVariable String id, @PathVariable String playlist_id) {
        Map<String, String> playlist = new HashMap<>();
        playlist.put("id", playlist_id);
        playlist.put("nome", "Playlist de academia");
        playlist.put("usuarioId", id);

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    //atualizar playlist
    @PutMapping("/{id}/playlist/{playlist_id}")
    public ResponseEntity<Object> updatePlaylist(@PathVariable String id, @PathVariable String playlist_id, @RequestBody Map<String, String> playlist) {
        Map<String, String> updatedPlaylist = new HashMap<>();
        updatedPlaylist.put("id", playlist_id);
        updatedPlaylist.put("nome", playlist.get("nome"));
        updatedPlaylist.put("usuarioId", id);

        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }

    //deletar playliost
    @DeleteMapping("/{id}/playlist/{playlist_id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id, @PathVariable String playlist_id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

















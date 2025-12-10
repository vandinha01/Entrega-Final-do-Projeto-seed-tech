package com.seedtech_pi.controller;

import com.seedtech_pi.model.Armazem;
import com.seedtech_pi.repository.ArmazemRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/armazens")
@CrossOrigin(origins="*")
public class ArmazemController {
    private final ArmazemRepository repo;
    public ArmazemController(ArmazemRepository r){this.repo=r;}

    @GetMapping public List<Armazem> listar(){return repo.findAll();}
    @PostMapping public Armazem criar(@RequestBody Armazem a){return repo.save(a);}
    @GetMapping("/{id}")
    public ResponseEntity<Armazem> buscar(@PathVariable Integer id){
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Armazem> atualizar(@PathVariable Integer id,@RequestBody Armazem d){
        return repo.findById(id).map(a->{
            a.setNome(d.getNome());
            a.setLocalizacao(d.getLocalizacao());
            a.setCapacidadeKg(d.getCapacidadeKg());
            repo.save(a);
            return ResponseEntity.ok(a);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

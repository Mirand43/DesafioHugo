package com.antonio.controller;

import java.util.List;

import com.antonio.model.Course;
import com.antonio.repository.CourseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/tarefas")
public class TarefasController {

    private final TarefasRepository tarefasRepository;

    @GetMapping
    public @ResponseBody List<Tarefas> list() {
        return tarefasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> findById(@PathVariable Long id) {
        return tarefasRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tarefas create(@RequestBody Tarefas tarefa) {
        return tarefasRepository.save(tarefas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> update(@PathVariable Long id,
            @RequestBody Tarefas tarefa) {
        return tarefasRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setTarefa(tarefa.getTarefa());
                    recordFound.setDescrition(tarefa.getDescrition());
                    Tarefas updated = tarefasRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return tarefasRepository.findById(id)
                .map(recordFound -> {
                    tarefasRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
        
}

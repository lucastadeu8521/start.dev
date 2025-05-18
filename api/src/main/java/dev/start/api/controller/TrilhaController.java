package dev.start.api.controller;

import dev.start.api.dto.TrilhaRequest;
import dev.start.api.dto.TrilhaResponse;
import dev.start.api.service.TrilhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @PostMapping
    public ResponseEntity<TrilhaResponse> criar(@RequestBody TrilhaRequest request) {
        return ResponseEntity.ok(trilhaService.criar(request));
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<TrilhaResponse>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(trilhaService.listarPorCurso(cursoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(trilhaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaResponse> atualizar(@PathVariable Long id, @RequestBody TrilhaRequest request) {
        return ResponseEntity.ok(trilhaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trilhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

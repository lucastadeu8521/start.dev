package dev.start.api.controller;

import dev.start.api.dto.AulaRequest;
import dev.start.api.dto.AulaResponse;
import dev.start.api.service.AulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @PostMapping
    public ResponseEntity<AulaResponse> criar(@RequestBody AulaRequest request) {
        return ResponseEntity.ok(aulaService.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<AulaResponse>> listar() {
        return ResponseEntity.ok(aulaService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaResponse> atualizar(@PathVariable Long id, @RequestBody AulaRequest request) {
        return ResponseEntity.ok(aulaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        aulaService.desativar(id);
        return ResponseEntity.noContent().build();
    }
}

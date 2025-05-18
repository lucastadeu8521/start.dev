package dev.start.api.controller;

import dev.start.api.dto.CursoRequest;
import dev.start.api.dto.CursoResponse;
import dev.start.api.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResponse> criarCurso(@RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.criarCurso(request));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscarCurso(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> atualizarCurso(@PathVariable Long id, @RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.atualizarCurso(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}

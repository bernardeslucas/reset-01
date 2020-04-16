package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.management.SeriesManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/series")
public class SeriesController {

    @Autowired
    private SeriesManagement management;

    @GetMapping
    private List<Series> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Series search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Series music) {
        management.create(music);
    }

    @PutMapping("{id}")
    private Series edit(@PathVariable int id, @RequestBody Series music) {
        return management.edit(id, music);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }
}


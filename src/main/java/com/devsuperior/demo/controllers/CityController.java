package com.devsuperior.demo.controllers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService service;


    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllCities() {
        List<CityDTO> cityDTOS = service.findAllCities();
        return ResponseEntity.ok().body(cityDTOS);
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDTO) {
        cityDTO = service.insert(cityDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cityDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(cityDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

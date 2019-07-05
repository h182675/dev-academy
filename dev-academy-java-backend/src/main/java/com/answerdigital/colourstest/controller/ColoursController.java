package com.answerdigital.colourstest.controller;

import com.answerdigital.colourstest.dto.ColourCreateDTO;
import com.answerdigital.colourstest.model.Colour;
import com.answerdigital.colourstest.repository.ColoursRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colours")
public class ColoursController {

    @Autowired
    private ColoursRepository coloursRepository;

    @GetMapping
    public ResponseEntity<List<Colour>> getColours() {
        return new ResponseEntity(coloursRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colour> getColour(@PathVariable("id") long id) {
        // TODO Optional 1

        Optional<Colour> colourData = coloursRepository.findById(id);
        ResponseEntity responseEntity;

        if (colourData.isPresent()) {
            responseEntity = new ResponseEntity(colourData, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Colour> createColour(@RequestBody ColourCreateDTO colourCreateDto) {
        // TODO Optional 2

        ResponseEntity<Colour> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(colourCreateDto.getName().length()>0){
            Colour colour = new Colour(null, colourCreateDto.getName());
            coloursRepository.saveAndFlush(colour);
            responseEntity = new ResponseEntity(colour, HttpStatus.OK);
        }

        return responseEntity;
    }


}

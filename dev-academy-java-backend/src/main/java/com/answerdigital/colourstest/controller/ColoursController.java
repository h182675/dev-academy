package com.answerdigital.colourstest.controller;

import com.answerdigital.colourstest.exception.NotImplementedException;
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
    public ResponseEntity<Colour> getColour(@PathVariable("id") long id){
        // TODO Optional 1

        Optional<Colour> colourData = coloursRepository.findById(id);
        ResponseEntity responseEntity;

        if(colourData.isPresent()){
            responseEntity = new ResponseEntity(colourData,HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Colour> createColour(){
        // TODO Optional 2
        throw new NotImplementedException();
    }


}

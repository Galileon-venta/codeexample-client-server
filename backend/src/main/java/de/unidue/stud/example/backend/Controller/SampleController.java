package de.unidue.stud.example.backend.Controller;

import de.unidue.stud.example.backend.Entities.Sample;
import de.unidue.stud.example.backend.Service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/v1/samples")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/all")
    public ResponseEntity<List<Sample>> getAll(){
        return new ResponseEntity<>(sampleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getById(@PathVariable Integer id){
        return new ResponseEntity<>(sampleService.getSampleById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/new", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Sample> createNewSample(@RequestBody Sample sample){
        return new ResponseEntity<>(sampleService.createSample(sample), HttpStatus.CREATED);
    }


}

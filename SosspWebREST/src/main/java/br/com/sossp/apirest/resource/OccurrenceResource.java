package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.models.Occurrence;
import br.com.sossp.apirest.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/occurrence")
public class OccurrenceResource {

    @Autowired
    private OccurrenceRepository repository;

    // CRUD - Start
    @GetMapping
    public List<Occurrence> getOccurrence(){
        return repository.findAll();
    }

    @GetMapping("{occurrenceId}")
    public Occurrence getOccurrenceId(@PathVariable long occurrenceId){
        return repository.findById(occurrenceId).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Occurrence postOccurrence(@RequestBody Occurrence occurrence){
        return repository.save(occurrence);
    }

    @PutMapping("{occurrenceId}")
    public Occurrence putOccurrence(@RequestBody Occurrence occurrence, @PathVariable long occurrenceId){
        occurrence.setOccurrenceId(occurrenceId);
        return repository.save(occurrence);
    }

    @DeleteMapping("{occurrenceId}")
    public void deleteOccurrence(@PathVariable long occurrenceId){
        repository.deleteById(occurrenceId);
    }
    // CRUD - End

}

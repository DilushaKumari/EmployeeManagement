package lk.ou.se.test.controller;

import lk.ou.se.test.entity.Dependent;
import lk.ou.se.test.exception.NotFoundException;
import lk.ou.se.test.service.custom.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/dependents")
@CrossOrigin
@RestController
public class DependentController {

    @Autowired
    private DependentService dependentService;

    @GetMapping
    public ResponseEntity<List<Dependent>> getAllDependents() {
        List<Dependent> allDependents = dependentService.findAllDependents();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",allDependents.size() + "");
        return new ResponseEntity<>(allDependents,httpHeaders,HttpStatus.OK);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dependent getDependent(@PathVariable String id) {
        try {
            return dependentService.findDependentById(id);
        } catch (NullPointerException e) {
            throw new NotFoundException(e);
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDependent(@RequestBody Dependent dependent) {
        dependentService.saveDependent(dependent);
        return "\"" + dependent.getDependent_id() + "\"";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDependent(@PathVariable String id) {
        dependentService.deleteDependent(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateDependent(@PathVariable String id,
                               @RequestBody Dependent dependent) {
        dependent.setDependent_id(id);
        dependentService.updateDependent(dependent);
    }

}

package org.architecture.test.infraestructure.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.architecture.test.application.services.SubjectService;
import org.architecture.test.application.usecase.ISubjectService;
import org.architecture.test.domain.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    @Autowired
    private final ISubjectService subjectService;

    @PostMapping()
    public Subject create(@RequestBody Subject subject){
        return subjectService.save(subject);
    }

    @GetMapping("/find/{uuid}")
    public Subject getByUuid(@PathVariable String uuid){
        return subjectService.findByUuid(uuid);
    }

    @PutMapping("/update/{uuid}")
    public Subject update(@RequestBody Subject subject, @PathVariable String uuid){
        return subjectService.update(subject, uuid);
    }

    @DeleteMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid){
        subjectService.delete(uuid);
    }
}

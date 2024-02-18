package org.architecture.test.infraestructure.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.architecture.test.application.services.TopicService;
import org.architecture.test.application.usecase.ITopicService;
import org.architecture.test.domain.model.Topic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicService topicService;

    @GetMapping("/find/{uuid}")
    public Topic findByUuid(@PathVariable String uuid) {
        return topicService.findByUuid(uuid);
    }

    @GetMapping("/all")
    public List<Topic> findAll() {
        return topicService.findAll();
    }

    @PutMapping("/update/{uuid}")
    public Topic update(@RequestBody Topic topic, @PathVariable String uuid) {
        return topicService.update(topic, uuid);
    }

    @DeleteMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        topicService.delete(uuid);
    }

}

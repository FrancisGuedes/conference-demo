package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speakers;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speakers> getAllSpeakers(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speakers getSpeakerById(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

    @PostMapping
    public Speakers createSpeaker(@RequestBody final Speakers speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeakerById(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speakers updateSpeakerById(@PathVariable Long id, @RequestBody Speakers speaker) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400 error
        Speakers existingSession = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSession, "speaker_id");
        return speakerRepository.saveAndFlush(existingSession);
    }
}

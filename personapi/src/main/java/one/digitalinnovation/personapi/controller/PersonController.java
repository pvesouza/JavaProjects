package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public MessageResponseDto createPerson(@RequestBody Person person)
    {
        personService.createPerson(person);
    }
}

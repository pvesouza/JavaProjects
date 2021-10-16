package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(Person person)
    {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto.builder().
                message("Created Person with Id " + savedPerson.getId())
                .build();

    }
}

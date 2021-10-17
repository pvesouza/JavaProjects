package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDto;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exceptions.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(PersonDTO personDTO)
    {

        Person personToSaved = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSaved);
        return MessageResponseDto.builder().
                message("Created Person with Id " + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = this.personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO).
                collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = this.personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
    }
}

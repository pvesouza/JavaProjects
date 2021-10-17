package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDto;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    protected void testGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakePerson();
        Person savedPerson = createFakeEntity();

        Mockito.when(personRepository.save(savedPerson)).thenReturn(savedPerson);

        MessageResponseDto expectedSuccessMessage = createExpectedMessageResponse(savedPerson.getId());

        MessageResponseDto messageResponseDto = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, messageResponseDto);
    }

    private PersonDTO createFakePerson() {
        return personMapper.toDTO(createFakeEntity());
    }

    private Person createFakeEntity() {
        PersonUtils personUtils = new PersonUtils();
        return personUtils.getTestPerson();
    }

    private MessageResponseDto createExpectedMessageResponse(Long id) {
        return MessageResponseDto
                .builder()
                .message("Person created with id: " + id)
                .build();
    }
}

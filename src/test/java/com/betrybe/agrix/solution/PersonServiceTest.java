package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetPersonById_PersonExists() {
    Person person = new Person();
    person.setId(1L);
    when(personRepository.findById(1L)).thenReturn(Optional.of(person));

    Person result = personService.getPersonById(1L);
    assertEquals(person, result);
  }

  @Test
  void testGetPersonById_PersonNotFound() {
    when(personRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(1L));
  }

  @Test
  void testGetPersonByUsername_PersonExists() {
    Person person = new Person();
    person.setUsername("testuser");
    when(personRepository.findByUsername("testuser")).thenReturn(Optional.of(person));

    Person result = personService.getPersonByUsername("testuser");
    assertEquals(person, result);
  }

  @Test
  void testGetPersonByUsername_PersonNotFound() {
    when(personRepository.findByUsername("testuser")).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("testuser"));
  }

  @Test
  void testCreatePerson() {
    Person person = new Person();
    when(personRepository.save(any(Person.class))).thenReturn(person);

    Person result = personService.create(person);
    assertEquals(person, result);
  }
}
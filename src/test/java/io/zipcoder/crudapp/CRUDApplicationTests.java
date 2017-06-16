package io.zipcoder.crudapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonConfig.class)
//@SpringBootTest
public class CRUDApplicationTests {

	@InjectMocks
	private PersonController personController;

	@Mock
	private PersonRepository personRepository;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllPersons(){
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		List<Person> pList = new ArrayList<>();
		p1.setId(1);
		p2.setId(2);
		p3.setId(3);
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);

		when(personRepository.findAll()).thenReturn(pList);

		assertEquals(3, personController.getAllPersons().size());
	}

	@Test
	public void testGetPersonById(){
		Person person = new Person();
		person.setName("Andrew");
		person.setId(1);

		when(personRepository.findOne(1)).thenReturn(person);
		Person p = personController.getPersonById(1);

		assertEquals(1, p.getId().intValue());
		assertEquals("Andrew", p.getName());
	}

	@Test
	public void testDeletePersonById(){
		Person p1 = new Person();
		Person p2 = new Person();
		List<Person> pList = new ArrayList<>();
		p1.setId(1);
		p2.setId(2);
		pList.add(p1);
		pList.add(p2);

		when(personRepository.findAll()).thenReturn(pList);
		personController.deletePersonById(2);
		verify(personRepository).delete(2);
		System.out.println(personRepository.count());

		assertNull(personRepository.findOne(2));
		assertNotNull(personRepository.findOne(1));
	}

	@Test
	public void testPostPerson(){
		List<Person> pList = new ArrayList<>();
		Person p = new Person("Andrew", 20);
		pList.add(p);

		when(personRepository.findAll()).thenReturn(pList);
		personController.postPerson(p);

		assertEquals(1, personController.getAllPersons().size());
	}

	@Test
	public void testPutPerson(){
		List<Person> pList = new ArrayList<>();
		Person p = new Person("Andrew", 20);
		Person newP = new Person("Andy", 20);
		pList.add(p);

		personController.putPerson(newP);

		assertEquals("Andy", personController.getPersonById(1).getName());
	}
}

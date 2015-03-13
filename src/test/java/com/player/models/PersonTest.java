package com.player.models;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonTest {
	@Mock
	public Person person;
	public Person person2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks( this );
		person2 = new Person();
	}
	
	@Test
	public void testEqual(){
		when( person.age(2000) ).thenReturn(100);
		assertEquals(person2.age(2000), person.age(2000));
	}
}
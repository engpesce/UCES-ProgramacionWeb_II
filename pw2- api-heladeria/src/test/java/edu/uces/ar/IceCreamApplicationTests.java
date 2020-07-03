package edu.uces.ar;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uces.ar.model.IceCream;
import edu.uces.ar.repository.IceCreamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IceCreamApplicationTests {

	@Autowired
	private IceCreamRepository iceCreamService;
		
	
	public IceCreamApplicationTests() {
	}

	@Test
	public void contextLoads() {
	}
	
}


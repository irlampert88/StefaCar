import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class MovimentoFinananceiroTest {

	MovimentoFinananceiro moviteste;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMovFin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGeravencimento() {
		
		moviteste.geravencimento(LocalDate.now().plusDays(30));
		assertEquals(moviteste.getDatavencimento(), LocalDate.now().plusDays(30));
		
		
	}

	@Test
	public void testCalculajuros() {
		fail("Not yet implemented");
	}

}

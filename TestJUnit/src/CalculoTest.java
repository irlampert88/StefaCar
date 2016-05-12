import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	public CalculoTest() {
		// TODO Auto-generated constructor stub
	}

	 @Test     
	 public void testSoma(){
	          System.out.println("Soma");
	         int a = 10;
	         int b = 20;
	         int expResult = 30;
	         int result = Calculo.Soma(a, b);
	         assertEquals(expResult, result);
	     }
	 
	     @Test
	        public void testSubtracao(){
	          System.out.println("Subtra��o");
	         int a = 20;
	         int b = 10;
	         int expResult = 10;
	         int result = Calculo.Subtracao(a, b);
	         assertEquals(expResult, result);
	     }
	     
	     @Test
	     public void testMultiplicacao(){
	          System.out.println("Multiplica��o");
	         int a = 5;
	         int b = 10;
	         int expResult = 50;
	         int result = Calculo.Multiplicacao(a, b);
	         assertEquals(expResult, result);
	     }
	     
	     
	     @Test
	     public void testDivisao(){
	          System.out.println("Divis�o");
	         float a = 20;
	         float b = 10;
	         float expResult = 2;
	         float result = Calculo.Divisao(a, b);
	         assertEquals(expResult, result,0);
	     }
	
	
}
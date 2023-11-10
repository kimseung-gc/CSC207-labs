package Class10.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the sample methods.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class SampleMethodsTests {
  /**
   * A test that should succeed.
   */
  @Test
  void sampleSuccesfulTest() {
    assertEquals(2, 2);
  } // sampleSuccessfulTest()

  /**
   * A test that should fail.
   */
  //@Test // Successfully fails the test
  void sampleFailingTest() {
    assertEquals(2, 3);
  } // sampleFailingTest()

  /**
   * A test that should fail.
   */
  /*
  @Test
  public void test2() {
    //fail("Not yet implemented");
    assertEquals(10, 3*5, "stupid test");
  } // test2()
  */
  /* Expected: Fail
   * Actual: Suuccessfully failed
   */


  @Test
  public void test3() {
    //fail("Not yet implemented");
    assertEquals(32, SampleMethods.c2f(0), "Fahrenheit to Celsius Test");
  } // test2()

  @Test
  public void test4() {
    int[] values = { 1, 2, 3 };
    assertEquals(6, SampleMethods.sum(values), "Sum test");
  }

  @Test
  void exptTest() {
    int expected = 1;
    for(int i = 0; i < 5; i++){
      assertEquals(expected, SampleMethods.expt(2, i));
      expected *= 2;
    }
  } // sampleSuccessfulTest()  
} // class TestSampleMethods

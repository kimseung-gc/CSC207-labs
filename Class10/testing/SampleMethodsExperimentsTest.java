package Class10.testing;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import Class6.exp;

public class SampleMethodsExperimentsTest 
{
  @Test
  public void testRemoveAs() {
    assertEquals("", 
                 SampleMethods.removeAs(""),
                 "empty string");
    assertEquals("hello", 
                 SampleMethods.removeAs("hello"),
                 "no as");
    assertEquals("", 
                 SampleMethods.removeAs("a"),
                 "eliminate one a");
    assertEquals("", 
                 SampleMethods.removeAs("aaaa"),
                 "eliminate many as");
    assertEquals("pin", 
                 SampleMethods.removeAs("pain"),
                 "eliminate one a, short string");
    assertEquals("lphbet", 
                 SampleMethods.removeAs("alphabet"),
                 "eliminate many as, medium string");
    assertEquals("BCDEFGHIJKLMNOPQ",
                 SampleMethods.removeAs("aBaaCDaaaEFGaaaaHIJKaaaaLMNaaaOPaaQa"),
                 "eliminate many as, silly string");
    assertEquals("bbb",
                 SampleMethods.removeAs("aaabbbaaa"),
                 "eliminate prefix and suffix as");
  } // testRemoveAs

  @Test
  public void testRemoveBs() {
    assertEquals("", 
                 SampleMethods.removeBs(""),
                 "empty string");
    assertEquals("hello", 
                 SampleMethods.removeBs("hello"),
                 "no as");
    assertEquals("", 
                 SampleMethods.removeBs("b"),
                 "eliminate one b");
    assertEquals("", 
                 SampleMethods.removeBs("bbbb"),
                 "eliminate many bs");
    assertEquals("eta", 
                 SampleMethods.removeBs("beta"),
                 "eliminate one b, short string");
    assertEquals("alphaet", 
                 SampleMethods.removeBs("alphabet"),
                 "eliminate many as, medium string");
    assertEquals("aaaaaa",
                 SampleMethods.removeBs("aaabbbaaa"),
                 "eliminate prefix and suffix as");
  } // testRemoveAs
}

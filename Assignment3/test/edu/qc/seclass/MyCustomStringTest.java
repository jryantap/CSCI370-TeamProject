package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

  private MyCustomStringInterface mycustomstring;

  @Before
  public void setUp() {
      mycustomstring = new MyCustomString();
  }

  @After
  public void tearDown() {
      mycustomstring = null;
  }

  @Test
  public void testCountNumbers1() {
      mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
      assertEquals(7, mycustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers2() {
      fail("Not yet implemented");
  }

  @Test
  public void testCountNumbers3() {
      fail("Not yet implemented");
  }

  @Test
  public void testCountNumbers4() {
      fail("Not yet implemented");
  }

  @Test
  public void testCountNumbers5() {
      fail("Not yet implemented");
  }

  @Test
  public void testCountNumbers6() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd1() {
      mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
      assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd2() {
      mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
      assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd3() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd4() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd5() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd6() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd7() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd8() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd9() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd10() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd11() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd12() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd13() {
      fail("Not yet implemented");
  }

  @Test
  public void testGetEveryNthCharacterFromBeginningOrEnd14() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring1() {
      mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
      mycustomstring.convertDigitsToNamesInSubstring(17, 23);
      assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
  }

  @Test
  public void testConvertDigitsToNamesInSubstring2() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring3() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring4() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring5() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring6() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring7() {
      fail("Not yet implemented");
  }

  @Test
  public void testConvertDigitsToNamesInSubstring8() {
      fail("Not yet implemented");
  }

}

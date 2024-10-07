package tp03;

import static org.junit.Assert.*;
import org.junit.Test;

public class RecursiviteTest {

  @Test
  public void testAdd() {
    assertEquals(7, Recursivite.add(3, 4));
    assertEquals(0, Recursivite.add(0, 0));
    assertEquals(5, Recursivite.add(5, 0));
    assertEquals(5, Recursivite.add(0, 5));
    assertEquals(10, Recursivite.add(6, 4));
  }

  @Test
  public void testInc() {
    assertEquals(1, Recursivite.inc(0));
    assertEquals(5, Recursivite.inc(4));
  }

  @Test
  public void testDec() {
    assertEquals(-1, Recursivite.dec(0));
    assertEquals(3, Recursivite.dec(4));
  }

  @Test
  public void testIsZero() {
    assertTrue(Recursivite.isZero(0));
    assertFalse(Recursivite.isZero(1));
  }

  @Test
  public void testMult() {
    assertEquals(0, Recursivite.mult(0, 5));
    assertEquals(0, Recursivite.mult(5, 0));
    assertEquals(20, Recursivite.mult(4, 5));
    assertEquals(15, Recursivite.mult(3, 5));
    assertEquals(1, Recursivite.mult(1, 1));
  }

  @Test
  public void testPuis() {
    assertEquals(1, Recursivite.puis(2, 0));
    assertEquals(2, Recursivite.puis(2, 1));
    assertEquals(4, Recursivite.puis(2, 2));
    assertEquals(8, Recursivite.puis(2, 3));
    assertEquals(27, Recursivite.puis(3, 3));
    assertEquals(1, Recursivite.puis(5, 0));
    assertEquals(0, Recursivite.puis(0, 5));
  }

  @Test
  public void testFiboRecNaif() {
    assertEquals(0, Recursivite.fibo_rec_naif(0));
    assertEquals(1, Recursivite.fibo_rec_naif(1));
    assertEquals(1, Recursivite.fibo_rec_naif(2));
    assertEquals(2, Recursivite.fibo_rec_naif(3));
    assertEquals(3, Recursivite.fibo_rec_naif(4));
    assertEquals(5, Recursivite.fibo_rec_naif(5));
    assertEquals(8, Recursivite.fibo_rec_naif(6));
    assertEquals(13, Recursivite.fibo_rec_naif(7));
    assertEquals(21, Recursivite.fibo_rec_naif(8));
    assertEquals(34, Recursivite.fibo_rec_naif(9));
  }

  @Test
  public void testFiboIter() {
    assertEquals(0, Recursivite.fibo_iter(0));
    assertEquals(1, Recursivite.fibo_iter(1));
    assertEquals(1, Recursivite.fibo_iter(2));
    assertEquals(2, Recursivite.fibo_iter(3));
    assertEquals(3, Recursivite.fibo_iter(4));
    assertEquals(5, Recursivite.fibo_iter(5));
    assertEquals(8, Recursivite.fibo_iter(6));
    assertEquals(13, Recursivite.fibo_iter(7));
    assertEquals(21, Recursivite.fibo_iter(8));
    assertEquals(34, Recursivite.fibo_iter(9));
  }
}
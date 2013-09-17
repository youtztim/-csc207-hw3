package edu.grinnell.csc207.youtztim.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.*;

public class Assignment3tests {

	@Test
	public void test_splitAt() {
		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitAt("a:b:c", ':'));
		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitAt("a b c", ' '));
		assertArrayEquals(new String[] { "a:b:c" },
				StringUtils.splitAt("a:b:c", ' '));
		assertArrayEquals("one field", new String[] { "a" },
				StringUtils.splitAt("a", ':'));
		assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
				StringUtils.splitAt("a::c", ':'));
		assertArrayEquals("leading empty field", new String[] { "", "a" },
				StringUtils.splitAt(":a", ':'));
		assertArrayEquals("trailing empty field", new String[] { "a", "" },
				StringUtils.splitAt("a:", ':'));
	}

	@Test
	public void test_splitCSV() {
		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitCSV("a,b,c"));
		assertArrayEquals(new String[] { "a,b", "c" },
				StringUtils.splitCSV("\"a,b\",c"));
		assertArrayEquals(new String[] { "a", "b,b\"", "c" },
				StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	}
	
	@Test
	public void test_deLeet() {
		assertEquals("e", StringUtils.deLeet("3"));
		assertEquals("leet", StringUtils.deLeet("133+"));
		assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
	}
		
	@Test
	public void test_eval0(){
		assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
		assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
		assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
		assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
	}
	
	@Test
	public void test_fewestCoins(){
		assertEquals("55", "true", StringUtils.fewestCoins(55));
		
	}


}

package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public abstract class AbstractRuthenium2019Test {
	abstract Ruthenium2019Interface getTestObject();

	@Test
	void test01() {
		int[] A = new int[] { 1, 1, 3, 4, 3, 3, 4 };
		int K = 2;
		int Expected = 5;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test02() {
		int[] A = new int[] { 4, 5, 5, 4, 2, 2, 4 };
		int K = 0;
		int Expected = 2;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test03() {
		int[] A = new int[] { 1, 3, 3, 2 };
		int K = 2;
		int Expected = 4;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test04() {
		int[] A = new int[] { 2, 2, 1, 3, 2, 2, 2, 5, 4, 3, 2, 2, 2, 2, 2, 2, 6, 7 };
		int K = 2;
		int Expected = 8;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test05() {
		int[] A = new int[] { 2, 2, 1, 2, 2, 2, 5, 2, 2, 4, 2, 2, 2, 2, 6, 7, 2, 2, 3 };
		int K = 2;
		int Expected = 11;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test06a() {
		int[] A = new int[] { 1 };
		int K = 0;
		int Expected = 1;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test06b() {
		int[] A = new int[] { 100000 };
		int K = 0;
		int Expected = 1;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test07() {
		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int K = 2;
		int Expected = 3;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test08a() {
		int[] A = new int[] { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int K = 2;
		int Expected = 4;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test08b() {
		int[] A = new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10 };
		int K = 2;
		int Expected = 4;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test08c() {
		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 };
		int K = 2;
		int Expected = 4;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

	@Test
	void test09() {
		int[] A = new int[] { 3, 5, 10, 6, 9, 8, 3, 5, 3, 10 };
		int K = 2;
		int Expected = 4;

		assertEquals(Expected, getTestObject().solution(A, K));
	}

}

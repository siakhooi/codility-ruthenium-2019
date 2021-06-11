package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public abstract class AbstractChallenge2021Test {
	abstract Challenge2021Interface getTestObject();

	@Test
	void test01() {
		int[] A = new int[] { 2, 3, 3, 4 };
		int L = 3;
		int R = 1;
		int a = 3;

		assertEquals(a, getTestObject().solution(A, L, R));
	}

}

package edu.chl.roborally.model;

import org.junit.Assert;
import org.junit.Test;

public class RoboRallyTest {
	private static final int NUM_INCREMENTATIONS = 128;

	@Test
	public void testIncrementResult() {
		final RoboRally roboRally = new RoboRally();

		for (int i = 0; i < NUM_INCREMENTATIONS; i++) {
			roboRally.incrementPresses();
		}

		Assert.assertEquals(NUM_INCREMENTATIONS, roboRally.getPresses());
	}
}

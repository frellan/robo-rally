package edu.chl.change2projectname;

import java.io.IOException;
import jdepend.framework.JDepend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CyclicDependenciesTest {
	private JDepend jdepend;

	@Before
	public void setUp() throws IOException {
		jdepend = new JDepend();
		jdepend.addDirectory("target/classes");
	}

	@Test
	public void testIsFreeFromCyclicDependencies() {
		jdepend.analyze();
		Assert.assertFalse(jdepend.containsCycles());
	}
}

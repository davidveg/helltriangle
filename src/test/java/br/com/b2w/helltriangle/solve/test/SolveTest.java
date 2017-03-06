package br.com.b2w.helltriangle.solve.test;

import static org.junit.Assert.assertEquals;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.b2w.helltriangle.model.Triangle;
import br.com.b2w.helltriangle.solve.Solver;

public class SolveTest {

	static Integer[][] stressTriangleConfig;

	@BeforeClass
	public static final void initialConfigurations() {
		stressTriangleConfig = new Integer[10000][];

		for (int i = 0; i < stressTriangleConfig.length; i++) {
			stressTriangleConfig[i] = new Integer[i + 1];

			for (Integer j = 0; j < (i + 1); j++) {
				stressTriangleConfig[i][j] = (int) (Math.random() * 1000);
			}
		}
	}

	@Test
	public final void constructorTest() throws InvalidAttributeValueException {
		Integer[][] triangleConfig = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 } };

		Triangle triangle = new Triangle(triangleConfig);

		new Solver(triangle);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void incorrectConstructorTest() {
		Triangle triangle = null;

		new Solver(triangle);
	}

	@Test
	public final void getBiggestSumTest() throws InvalidAttributeValueException {
		Integer[][] triangleConfig = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 } };

		Triangle triangle = new Triangle(triangleConfig);

		Solver solver = new Solver(triangle);

		assertEquals(new Integer(26), solver.getBiggestSum());
	}

	@Test
	public final void getBiggestSumStressTest() throws InvalidAttributeValueException {
		Triangle triangle = new Triangle(stressTriangleConfig);

		Solver solver = new Solver(triangle);

		solver.getBiggestSum();
	}
}

package br.com.b2w.helltriangle.validators;

import br.com.b2w.helltriangle.model.Triangle;

public class TriangleValidator {

	public void validate(Triangle triangle) {
		if (triangle == null || triangle.getRows() == null) {
			error();
		}
		int row = 1;
		for (Integer[] rowData : triangle.getRows()) {
			if (rowData.length != row) {
				error();
			}
			row++;
		}
	}

	void error() {
		throw new IllegalArgumentException("Invalid Triangle.");
	}
}

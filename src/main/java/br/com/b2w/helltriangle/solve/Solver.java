package br.com.b2w.helltriangle.solve;

import br.com.b2w.helltriangle.model.Triangle;
import br.com.b2w.helltriangle.validators.TriangleValidator;

public class Solver {

	private Triangle triangle;

	private TriangleValidator validator = new TriangleValidator();

	public Solver(Triangle input) {

		validator.validate(input);
		
		this.triangle = input;
	}

	public final Integer getLeftNumberInNextRow(final Integer row, final Integer pos) {
		return triangle.getRows()[row + 1][pos];
	}

	public final Integer getRightNumberInNextRow(final Integer row, final Integer pos) {
		return triangle.getRows()[row + 1][pos + 1];
	}

	public final Integer getFirstRow() {
		return triangle.getRows()[0][0];
	}

	public final Integer getBiggestNumberInSelection(final Integer row, final Integer pos) {
		return Math.max(getLeftNumberInNextRow(row, pos), getRightNumberInNextRow(row, pos));
	}

	public final Integer getTriangleSize() {
		return this.triangle.getRows().length;
	}

	public final Integer adjustPositionInNextRow(final Integer row, final Integer pos) {
		if (getLeftNumberInNextRow(row, pos) > getRightNumberInNextRow(row, pos)) {
			return pos;
		} else {
			return pos + 1;
		}
	}

	public final Integer getBiggestSum() {
		Integer sum = this.getFirstRow();

		Integer pos = 0;

		for (int row = 0; row < this.getTriangleSize() - 1; row++) {
			sum += this.getBiggestNumberInSelection(row, pos);

			pos = this.adjustPositionInNextRow(row, pos);
		}

		return sum;
	}
}

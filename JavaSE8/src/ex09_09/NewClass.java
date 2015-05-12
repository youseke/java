package ex09_09;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

public class NewClass {
	@Test
	public void perform() {
		LabeledPoint a = new LabeledPoint(null, 1, 4);
		LabeledPoint b = new LabeledPoint(null, 1, 4);
		assertEquals(a, b);
		assertEquals(a.hashCode(), b.hashCode());
	}

	class LabeledPoint {

		String label;
		int x;
		int y;

		public LabeledPoint(String label, int x, int y) {
			this.label = label;
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(label, x, y);
		}

		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (getClass() != other.getClass())
				return false;
			LabeledPoint otherPoint = (LabeledPoint) other;
			return Objects.equals(label, otherPoint.label)
					&& Objects.equals(x, otherPoint.x)
					&& Objects.equals(y, otherPoint.y);
		}
	}

}

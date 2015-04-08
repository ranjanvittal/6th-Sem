class Test2 {
	public static void main(String[] args) {
		boolean b;
		int r;
		Circle circle;
		r = 90;

		circle = new Circle();
		/* INLINE */
		b = circle.check(r);
		if (b) {
			b = circle.check(r);
		} else {
			b = circle.check(r);
		}
	}
}

class Circle {
	public boolean check(int r) {
		boolean ret;
		boolean cond;
		cond=r < 0;
		if (cond) {
			ret = false;
		} else {
			ret = true;

		}
		return ret;
	}

}
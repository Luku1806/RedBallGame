package de.lukas_reining.redball.utils;

public class Vec2D {

	private double x, y;

	public Vec2D() {
		this(0.0, 0.0);
	}

	public Vec2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	public double sqrLength() {
		return x * x + y * y;
	}

	public Vec2D normalized() {
		double inv_len = 1 / length();
		return new Vec2D(x * inv_len, y * inv_len);
	}

	public Vec2D add(Vec2D vec2) {
		return new Vec2D(x + vec2.x, y + vec2.y);
	}

	public Vec2D sub(Vec2D vec2) {
		return new Vec2D(x - vec2.x, y - vec2.y);
	}

	public Vec2D mult(double scalar) {
		return new Vec2D(x * scalar, y * scalar);
	}

	public Vec2D div(double scalar) {
		return new Vec2D(x / scalar, y / scalar);
	}

	public double dot(Vec2D vec2) {
		return x * vec2.x + y * vec2.y;
	}

	public double cross(Vec2D vec2) {
		return x * vec2.y + y * vec2.x;
	}

	/////// Getter/Setter stuff////////////////

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}

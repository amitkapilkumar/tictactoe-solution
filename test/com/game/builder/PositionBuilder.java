package com.game.builder;

import com.game.model.Position;

public class PositionBuilder {
	private int x;
	private int y;
	
	public PositionBuilder withX(int x) {
		this.x = x;
		return this;
	}
	
	public PositionBuilder withY(int y) {
		this.y = y;
		return this;
	}
	
	public Position build() {
		Position position = new Position();
		position.setX(x);
		position.setY(y);
		return position;
	}
}

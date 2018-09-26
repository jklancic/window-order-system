package xyz.blackmonster.window.responses;

import xyz.blackmonster.window.types.Blinds;
import xyz.blackmonster.window.types.Color;
import xyz.blackmonster.window.types.Glazing;
import xyz.blackmonster.window.types.Mosquito;
import xyz.blackmonster.window.types.Shelf;
import xyz.blackmonster.window.types.WindowType;

/**
 * Rest response body for window configuration
 */
public class WindowWS {

	private int quantity;
	private int width;
	private int height;
	private Glazing glazing;
	private Color color;
	private WindowType type;
	private Shelf shelf;
	private Blinds blinds;
	private Mosquito mosquito;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Glazing getGlazing() {
		return glazing;
	}

	public void setGlazing(Glazing glazing) {
		this.glazing = glazing;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public WindowType getType() {
		return type;
	}

	public void setType(WindowType type) {
		this.type = type;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Blinds getBlinds() {
		return blinds;
	}

	public void setBlinds(Blinds blinds) {
		this.blinds = blinds;
	}

	public Mosquito getMosquito() {
		return mosquito;
	}

	public void setMosquito(Mosquito mosquito) {
		this.mosquito = mosquito;
	}
}

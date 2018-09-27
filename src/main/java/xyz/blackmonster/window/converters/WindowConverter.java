package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Window;
import xyz.blackmonster.window.responses.WindowWS;

/**
 * Converts WS cost objects from and to cost models
 */
public class WindowConverter {

	/**
	 * Converts Window instance to WindowWS instance
	 * @param window
	 * @return
	 */
	public static WindowWS toWS(Window window) {
		WindowWS windowWS = new WindowWS();
		windowWS.setQuantity(window.getQuantity());
		windowWS.setWidth(window.getWidth());
		windowWS.setHeight(window.getHeight());
		windowWS.setGlazing(window.getGlazing());
		windowWS.setColor(window.getColor());
		windowWS.setType(window.getType());
		windowWS.setShelf(window.getShelf());
		windowWS.setBlinds(window.getBlinds());
		windowWS.setMosquito(window.getMosquito());

		return windowWS;
	}

	/**
	 * Converts WindowWS instance to Window instance
	 * @param windowWS
	 * @return
	 */
	public static Window toModel(WindowWS windowWS) {
		Window window = new Window();
		window.setQuantity(windowWS.getQuantity());
		window.setWidth(windowWS.getWidth());
		window.setHeight(windowWS.getHeight());
		window.setGlazing(windowWS.getGlazing());
		window.setColor(windowWS.getColor());
		window.setType(windowWS.getType());
		window.setShelf(windowWS.getShelf());
		window.setBlinds(windowWS.getBlinds());
		window.setMosquito(windowWS.getMosquito());

		return window;
	}
}

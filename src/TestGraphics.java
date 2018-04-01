import java.awt.*;

public abstract class TestGraphics {

	public static void main(String[] args) {

		final Frame newFrame = new Frame();
		final TextField textField = new TextField("Hello World");
		newFrame.add(textField);
		newFrame.setSize(550, 200);
		newFrame.setVisible(true);

	}

}

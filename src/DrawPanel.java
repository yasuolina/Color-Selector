import javax.swing.*;
import java.awt.*;

class DrawPanel extends JPanel {
    // TWO COLOR ONE OF FOR THE BACKGROUND OTHER ONE IS FOR THE FOREGROUND
    Color backgroundColor = Color.BLACK;
    Color foregroundColor = Color.BLACK;

    // CONSTRUCCTOR METHOD FOR OUR DRAW PANEL
    public DrawPanel()
    {
        setPreferredSize(new Dimension(500, 200));
    }

    // WHEN THE WINDOW IS UPDATED , THIS METHOD WILL BE CALLED
    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        // FILL ENTIRE PANEL WITH THE BACKGROUND COLOR
        graphics.setColor(backgroundColor);

        graphics.fillRect(0, 0, getWidth(), getHeight());

        // FILL ENTIRE PANEL WITH THE BACKGROUND COLOR
        graphics.setColor(foregroundColor);

        graphics.drawOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
        // DARW A FILLED CIRCLE

        graphics.fillOval(getWidth() / 2 - 30, getHeight() / 2 - 30, 60, 60);
    }
}
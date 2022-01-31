import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSelector extends JFrame implements ChangeListener
{
    //DEFINE COLORSELECTOR PANEL OBJECTS AND DRAW PANEL OBJECT
    ColorSelectorPanel backGround, foreGround;
    DrawPanel drawPanel;

    // CONSTRUCTOR METHOD TO INITIALIZE A WINDOW
    public ColorSelector()
    {

        super("Color Selector");// we are assigning a title

        // INITIALIZE DRAWPANEL,BACKGROUND AND FOREGROUND OBJECTS
        drawPanel = new DrawPanel();
        backGround = new ColorSelectorPanel("Background", this);
        foreGround = new ColorSelectorPanel("Foreground", this);

        //ADD BACKGROUND TO THE LEFT SIDE , FOREGROUND TO STHE RIGHT SIDE AND DRAWPANEL TO THE MIDDLE
        add(backGround, BorderLayout.WEST);
        add(foreGround, BorderLayout.EAST);
        add(drawPanel, BorderLayout.CENTER);

        //DISPLAY THE WINDOW
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    @Override
    public void stateChanged(ChangeEvent e)
    {
        // checking if event is from bg ColorSelectorPanel sliders
        if (e.getSource() == backGround.red || e.getSource() == backGround.green || e.getSource() == backGround.blue)
        {
            // GET RED,GREEN,BLUE VALUES FROM THE SLIDERS
            int redColor = backGround.red.getValue();
            int greenColor = backGround.green.getValue();
            int blueColor = backGround.blue.getValue();

            // CREATE NEW COLOR FROM THE COLORS
            Color color = new Color(redColor, greenColor, blueColor);

            // UPDATE LABELS IN BACKGROUND
            backGround.redLabel.setText(String.format("%03d", redColor));
            backGround.greenLabel.setText(String.format("%03d", greenColor));
            backGround.blueLabel.setText(String.format("%03d", blueColor));

            //UPDATE HEXLABEL OF BACKROUND TO DISPLAY THEIR CORRESPOND HEXADECIMAL VALUES
            backGround.hexLabel.setText(String.format("#%02X%02X%02X", redColor, greenColor, blueColor));

            drawPanel.backgroundColor = color;

            repaint();
        }
        else if (e.getSource() == foreGround.red || e.getSource() == foreGround.green || e.getSource() == foreGround.blue) {
            // REPEAT ALL STEPS FOR THE FOREGROUND
            int redColor = foreGround.red.getValue();
            int greenColor = foreGround.green.getValue();
            int blueColor = foreGround.blue.getValue();

            Color color = new Color(redColor, greenColor, blueColor);

            foreGround.redLabel.setText(String.format("%03d", redColor));
            foreGround.greenLabel.setText(String.format("%03d", greenColor));
            foreGround.blueLabel.setText(String.format("%03d", blueColor));
            foreGround.hexLabel.setText(String.format("#%02X%02X%02X", redColor,
                    greenColor, blueColor));

            drawPanel.foregroundColor = color;
            repaint();
        }
    }
}
import javax.swing.*;

class ColorSelectorPanel extends JPanel {
    // SLIDER WITH DIFFERENT COLORS
    JSlider red, green, blue;

    // LABELS FOR THE DISPLAYING HEXADECIMAL VALUES
    JLabel redLabel, greenLabel, blueLabel, hexLabel;

    public ColorSelectorPanel(String title, ColorSelector parent)
    {
        // INITIALIZE SLIDERS VERTICALLY 0-255
        red = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        green = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        blue = new JSlider(JSlider.VERTICAL, 0, 255, 0);

        red.addChangeListener(parent);
        green.addChangeListener(parent);
        blue.addChangeListener(parent);

        // LABEL'S FIRST STATUS
        redLabel = new JLabel("000");
        greenLabel = new JLabel("000");
        blueLabel = new JLabel("000");
        hexLabel = new JLabel("#000000");


        JPanel redPanel = new JPanel();
        redPanel.setLayout(new BoxLayout(redPanel, BoxLayout.Y_AXIS));
        redPanel.add(red);
        redPanel.add(redLabel);
        // using a titled border with text="R"
        redPanel.setBorder(BorderFactory.createTitledBorder("R"));


        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(new BoxLayout(greenPanel, BoxLayout.Y_AXIS));
        greenPanel.add(green);
        greenPanel.add(greenLabel);
        // using a titled border with text="G"
        greenPanel.setBorder(BorderFactory.createTitledBorder("G"));

        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(new BoxLayout(bluePanel, BoxLayout.Y_AXIS));
        bluePanel.add(blue);
        bluePanel.add(blueLabel);
        // using a titled border with text="B"
        bluePanel.setBorder(BorderFactory.createTitledBorder("B"));

        // ADD THREE PANELS TO THE ONE PANEL
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(redPanel);
        sliderPanel.add(greenPanel);
        sliderPanel.add(bluePanel);

        // ONE MORE PANEL FOR THE HEXLABEL
        JPanel hexPanel = new JPanel();
        hexPanel.setBorder(BorderFactory.createTitledBorder("Hex"));
        hexPanel.add(hexLabel);

        // ADD BOTH PANELS TO THE MAIN PANEL
        add(sliderPanel);
        add(hexPanel);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder(title));
    }
}
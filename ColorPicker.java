import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorPicker implements ChangeListener {
    private static JFrame frame;
    private static JPanel main_panel;
    private static JPanel pallette;
    private static JSlider red_slider;
    private static JSlider blue_slider;
    private static JSlider green_slider;
    private static JLabel red_label;
    private static JLabel blue_label;
    private static JLabel green_label;
    private static JTextField hex_field;



    private static Integer RED;
    private static Integer BLUE;
    private static Integer GREEN;


    ColorPicker(){
        frame = new JFrame("Color Picker");
        main_panel = new JPanel();
        main_panel.setLayout(null);
        pallette = new JPanel();
        pallette.setBackground(Color.WHITE);
        pallette.setBounds(10, 10, 460, 100);

        red_label = new JLabel("R: 255");
        red_label.setBounds(10, 380, 40, 40);
        green_label = new JLabel("G: 255");
        green_label.setBounds(70, 380, 40, 40);
        blue_label = new JLabel("B: 255");
        blue_label.setBounds(120, 380, 40, 40);
        hex_field = new JTextField("#ffffff", 8);
        hex_field.setBounds(180, 380, 40, 40);



        red_slider = new JSlider();
        red_slider.setBounds(10, 130, 460, 80);
        red_slider.setMaximum(255);
        red_slider.setValue(255);
        red_slider.setPaintTicks(true);
        red_slider.setMajorTickSpacing(255);
        red_slider.setPaintLabels(true);
        red_slider.addChangeListener(this);

        green_slider = new JSlider();
        green_slider.setBounds(10, 210, 460, 80);
        green_slider.setMaximum(255);
        green_slider.setValue(255);
        green_slider.setPaintTicks(true);
        green_slider.setMajorTickSpacing(255);
        green_slider.setPaintLabels(true);
        green_slider.addChangeListener(this);

        blue_slider = new JSlider();
        blue_slider.setBounds(10, 290, 460, 80);
        blue_slider.setMaximum(255);
        blue_slider.setValue(255);
        blue_slider.setPaintTicks(true);
        blue_slider.setMajorTickSpacing(255);
        blue_slider.setPaintLabels(true);
        blue_slider.addChangeListener(this);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 550);

        main_panel.add(red_slider);
        main_panel.add(blue_slider);
        main_panel.add(green_slider);
        main_panel.add(red_label);
        main_panel.add(blue_label);
        main_panel.add(green_label);
        main_panel.add(pallette);
        main_panel.add(hex_field);

        frame.add(main_panel);

        frame.setVisible(true);

    }

    @Override
    public void  stateChanged(ChangeEvent e) {
        RED = red_slider.getValue();
        red_label.setText(RED.toString());
        BLUE = blue_slider.getValue();
        blue_label.setText(BLUE.toString());
        GREEN = green_slider.getValue();
        green_label.setText(GREEN.toString());
        Color COLOR = new Color(RED, GREEN, BLUE);
        String hex = String.format("#%02x%02x%02x", RED, GREEN, BLUE);
        hex_field.setText(hex);

        pallette.setBackground(COLOR);
    }
}

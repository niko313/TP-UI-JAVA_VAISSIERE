package swing.windows;

import javax.swing.JFrame;
import java.awt.*;

public class general_setting extends JFrame{


    public general_setting() throws HeadlessException {

        this.setTitle("Dashboard");
        this.setSize(380, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

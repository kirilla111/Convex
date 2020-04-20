import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class MyFrame extends JFrame {

    private Convex t;
    public MyFrame(Convex t) {

        this.t = t;
        this.setSize(1007, 1080);
        this.setVisible(true);
        this.setResizable(true);
        JButton cancelButton = new JButton("Выход из приложения");
        cancelButton.setVisible(true);
        cancelButton.setLocation(0, 0);
        cancelButton.setSize(1007, 50);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });



    this.getContentPane().add(cancelButton);
    this.getContentPane().add(new JLabel());
    }
    @Override
    public void paint(Graphics g){
        g.drawLine(507,0, 507, 1080);
        g.drawLine(0,580, 1080, 580);
        g.drawLine(507,550, 537, 550);//делаем квадрат
        g.drawLine(537,550, 537, 580);
        t.draw(g);

    }

}


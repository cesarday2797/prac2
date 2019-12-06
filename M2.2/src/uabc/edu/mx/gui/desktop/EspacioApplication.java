package uabc.edu.mx.gui.desktop;

import uabc.edu.mx.libreria.Lugar;
import uabc.edu.mx.libreria.Objeto;
import uabc.edu.mx.libreria.Posicion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class EspacioApplication extends JDialog {
    private Lugar miLugar = new Lugar("Mi lugar");
    private Random random = new Random();
    private JPanel contentPane;

    private JButton buttonCancel;
    private JButton buttonAddObject;
    private JPanel panelPrincipal;



    public EspacioApplication() {
        setContentPane(contentPane);
        setModal(true);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonAddObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Objeto unObjeto = new Objeto("miObjeto" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), miLugar);
                miLugar.getLosObjetos().add(unObjeto);
                System.out.print(miLugar);

                Image image = null;
                try {
                    image = ImageIO.read(new File("comentario.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                for (int i = 0; i < miLugar.getLosObjetos().size(); i++) {
                    //panelPrincipal.getGraphics().drawRect(miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(), 20, 20);
                    panelPrincipal.getGraphics().drawImage(image,miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(),100,100,null);
                }
            }
        });

        panelPrincipal.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image image = null;
                try {
                    image = ImageIO.read(new File("comentario.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                for (int i = 0; i < miLugar.getLosObjetos().size(); i++) {
                    //panelPrincipal.getGraphics().drawRect(miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(), 20, 20);
                    panelPrincipal.getGraphics().drawImage(image,miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(),100,100,null);
                }
            }
        });


        panelPrincipal.addComponentListener(new ComponentAdapter() {
        });
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        EspacioApplication dialog = new EspacioApplication();
        dialog.setUndecorated(true);
        dialog.setBackground(Color.cyan);
        dialog.setBounds(300,100,300,100);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

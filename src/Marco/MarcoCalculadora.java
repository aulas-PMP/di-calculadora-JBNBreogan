package Marco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoCalculadora extends JFrame {

    private JTextField resultado;
    private JTextField escritura;
    private JPanel panelNumeros;
    private JPanel panelOperadores;

    public MarcoCalculadora() {
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = mipantalla.getScreenSize();
        int anchoPantalla = tamano.width;
        int altoPantalla = tamano.height;
        setSize(anchoPantalla / 2, 600);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setBackground(Color.DARK_GRAY);

        setTitle("Calculadora - Breogán Fernández Tacón");

        setLayout(new BorderLayout(10, 10));

        JPanel display = new JPanel(new GridLayout(2, 1, 5, 5));
        display.setPreferredSize(new Dimension(400, 150));

        escritura = new JTextField();
        resultado = new JTextField();
        escritura.setEditable(false);
        resultado.setEditable(false);
        escritura.setBackground(Color.darkGray);
        escritura.setForeground(Color.WHITE);
        escritura.setBorder(null);
        escritura.setFont(new Font("Courier new", Font.PLAIN, 30));
        resultado.setFont(new Font("Courier new", Font.PLAIN, 30));
        escritura.setHorizontalAlignment(JTextField.RIGHT);
        resultado.setHorizontalAlignment(JTextField.RIGHT);
        resultado.setBorder(null);
        resultado.setBackground(Color.DARK_GRAY);
        resultado.setForeground(Color.WHITE);

        display.add(escritura);
        display.add(resultado);
        display.setBackground(Color.darkGray);
        add(display, BorderLayout.NORTH); // Colocarlo en la parte superior de la ventana (Norte)

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3, 10, 10)); // 4 filas y 3 columnas para los números
        panelNumeros.setPreferredSize(new Dimension(300, 400));
        panelNumeros.setBackground(Color.darkGray);
        

        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnDec = new JButton(".");
        JButton btnCl = new JButton("C");

        btn0.setBackground(Color.WHITE);
        btn1.setBackground(Color.WHITE);
        btn2.setBackground(Color.WHITE);
        btn3.setBackground(Color.WHITE);
        btn4.setBackground(Color.WHITE);
        btn5.setBackground(Color.WHITE);
        btn6.setBackground(Color.WHITE);
        btn7.setBackground(Color.WHITE);
        btn8.setBackground(Color.WHITE);
        btn9.setBackground(Color.WHITE);
        btnDec.setBackground(Color.WHITE);
        btnCl.setBackground(Color.WHITE);


        panelNumeros.add(btn7);
        panelNumeros.add(btn8);
        panelNumeros.add(btn9);
        panelNumeros.add(btn4);
        panelNumeros.add(btn5);
        panelNumeros.add(btn6);
        panelNumeros.add(btn1);
        panelNumeros.add(btn2);
        panelNumeros.add(btn3);
        panelNumeros.add(btn0);
        panelNumeros.add(btnDec);
        panelNumeros.add(btnCl);


        panelOperadores = new JPanel();
        panelOperadores.setLayout(new GridLayout(5, 1, 10, 10)); 
        panelOperadores.setPreferredSize(new Dimension(100, 400));
        panelOperadores.setBackground(Color.darkGray);


        JButton btnSum = new JButton("+");
        JButton btnRest = new JButton("-");
        JButton btnDiv = new JButton("/");
        JButton btnMult = new JButton("*");
        JButton btnEqu = new JButton("=");

        btnSum.setBackground(Color.white);
        btnRest.setBackground(Color.white);
        btnMult.setBackground(Color.white);
        btnEqu.setBackground(Color.white);
        btnDiv.setBackground(Color.white);
 
        panelOperadores.add(btnSum);
        panelOperadores.add(btnRest);
        panelOperadores.add(btnMult);
        panelOperadores.add(btnDiv);
        panelOperadores.add(btnEqu);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout(10, 10));
        panelCentro.add(panelNumeros, BorderLayout.CENTER); 
        panelCentro.add(panelOperadores, BorderLayout.EAST); 
        panelCentro.setBackground(Color.darkGray);

        add(panelCentro, BorderLayout.CENTER);

        this.setVisible(true);


        ActionListener numListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = ((JButton) e.getSource()).getText();
                escritura.setText(escritura.getText() + value);
            }
        };


        ActionListener operatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = ((JButton) e.getSource()).getText();
                escritura.setText(escritura.getText() + value);
            }
        };

        btn0.addActionListener(numListener);
        btn1.addActionListener(numListener);
        btn2.addActionListener(numListener);
        btn3.addActionListener(numListener);
        btn4.addActionListener(numListener);
        btn5.addActionListener(numListener);
        btn6.addActionListener(numListener);
        btn7.addActionListener(numListener);
        btn8.addActionListener(numListener);
        btn9.addActionListener(numListener);

        btnDiv.addActionListener(operatorListener);
        btnSum.addActionListener(operatorListener);
        btnRest.addActionListener(operatorListener);
        btnMult.addActionListener(operatorListener);
        btnEqu.addActionListener(operatorListener);
        btnCl.addActionListener(operatorListener);
    }
}


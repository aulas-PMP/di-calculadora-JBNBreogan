package Marco;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoCalculadora extends JFrame {

    private JTextField resultado;
    private JTextField escritura;
    private JPanel numeros;
    private JPanel operadores;

    public MarcoCalculadora(){
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = mipantalla.getScreenSize();
        int anchoPantalla = tamano.width;
        int altoPantalla = tamano.height;
        setSize(anchoPantalla/2,600);
        setLocation(anchoPantalla/4,altoPantalla/4);


        JPanel display = new JPanel(new GridLayout(3,1));
        numeros = new JPanel(new GridLayout(4,3));
        operadores = new JPanel(new GridLayout(6,1));
        
        setTitle("Calculadora - Breogán Fernández Tacón");

        escritura = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);
        escritura.setEditable(false);
        resultado.setFont(new Font("Courier new", Font.PLAIN, 24));
        escritura.setFont(new Font("Courier new", Font.PLAIN, 24));

        display.add(escritura);
        display.add(resultado);

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
        JButton btnSum = new JButton("+");
        JButton btnRest = new JButton("-");
        JButton btnDiv = new JButton("/");
        JButton btnMult = new JButton("*");
        JButton btnEqu = new JButton("=");
        JButton btnCl = new JButton("C");

        numeros.add(btn0);
        numeros.add(btn1);
        numeros.add(btn2);
        numeros.add(btn3);
        numeros.add(btn4);
        numeros.add(btn5);
        numeros.add(btn6);
        numeros.add(btn7);
        numeros.add(btn8);
        numeros.add(btn9);
        numeros.add(btnCl);

        operadores.add(btnSum);
        operadores.add(btnRest);
        operadores.add(btnMult);
        operadores.add(btnDiv);
        operadores.add(btnEqu);

        display.add(numeros);
        display.add(operadores);


        add(display);

        this.setVisible(true);

        ActionListener numListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = ((JButton) e.getSource()).getText();
                escritura.setText(escritura.getText()+value);
            }
        };

        ActionListener operatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = ((JButton) e.getSource()).getText();
                escritura.setText(escritura.getText()+value);
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
        
        
    } 
}
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

    private double num1 = 0;
    private String operando = "";

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
        resultado.setBackground(Color.LIGHT_GRAY);
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

        btn0.setFont(new Font("Courier New", Font.BOLD, 30));
        btn1.setFont(new Font("Courier New", Font.BOLD, 30));
        btn2.setFont(new Font("Courier New", Font.BOLD, 30));
        btn3.setFont(new Font("Courier New", Font.BOLD, 30));
        btn4.setFont(new Font("Courier New", Font.BOLD, 30));
        btn5.setFont(new Font("Courier New", Font.BOLD, 30));
        btn6.setFont(new Font("Courier New", Font.BOLD, 30));
        btn7.setFont(new Font("Courier New", Font.BOLD, 30));
        btn8.setFont(new Font("Courier New", Font.BOLD, 30));
        btn9.setFont(new Font("Courier New", Font.BOLD, 30));
        btnDec.setFont(new Font("Courier New", Font.BOLD, 30));
        btnCl.setFont(new Font("Courier New", Font.BOLD, 30));


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

        btnSum.setFont(new Font("Courier New", Font.BOLD, 25));
        btnRest.setFont(new Font("Courier New", Font.BOLD, 25));
        btnDiv.setFont(new Font("Courier New", Font.BOLD, 25));
        btnMult.setFont(new Font("Courier New", Font.BOLD, 25));
        btnEqu.setFont(new Font("Courier New", Font.BOLD, 25));

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

                if (value.equals("C")){
                    escritura.setText("");
                    resultado.setText(""); 
                    num1 = 0; 
                    operando = "";
                } else if (value.equals("="))
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


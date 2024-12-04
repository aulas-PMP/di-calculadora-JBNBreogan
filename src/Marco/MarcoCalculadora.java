package Marco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MarcoCalculadora extends JFrame {

    private JTextField resultado;
    private JTextField escritura;
    private JPanel panelNumeros;
    private JPanel panelOperadores;

    private JComboBox<String> modeSelector;

    private Double num1 = 0.0;
    private Double num2 = 0.0;
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
        
        String[] modes = {"Modo libre", "Solo ratón", "Solo teclado"};
        modeSelector = new JComboBox<>(modes);
        modeSelector.setFont(new Font("Courier New", Font.BOLD, 16));
        add(modeSelector, BorderLayout.SOUTH); // Añadir al panel

        modeSelector.addActionListener(e -> updateMode());

        escritura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
        
                // Detectar teclas numéricas del numpad
                if (keyCode >= KeyEvent.VK_NUMPAD0 && keyCode <= KeyEvent.VK_NUMPAD9) {
                    int numpadValue = keyCode - KeyEvent.VK_NUMPAD0;
                    escritura.setText(escritura.getText() + numpadValue);
                } 
                // Detectar operadores básicos del numpad
                else if (keyCode == KeyEvent.VK_ADD) {
                    escritura.setText(escritura.getText() + "+");
                } else if (keyCode == KeyEvent.VK_SUBTRACT) {
                    escritura.setText(escritura.getText() + "-");
                } else if (keyCode == KeyEvent.VK_MULTIPLY) {
                    escritura.setText(escritura.getText() + "*");
                } else if (keyCode == KeyEvent.VK_DIVIDE) {
                    escritura.setText(escritura.getText() + "/");
                } else if (keyCode == KeyEvent.VK_DECIMAL) {
                    escritura.setText(escritura.getText() + ".");
                } else if (keyCode == KeyEvent.VK_ENTER) {
                    calcular(); // Calcular resultado
                } else if (keyCode == KeyEvent.VK_BACK_SPACE && escritura.getText().length() > 0) {
                    // Borrar último carácter
                    escritura.setText(escritura.getText().substring(0, escritura.getText().length() - 1));
                }
            }
        });

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
                
                if (value.equals("C")) {
                    escritura.setText("");
                    resultado.setText("");
                    num1 = 0.0;
                    operando = "";
                    return;
                }

                if (value.equals("=")) {
                    calcular();
                    return;
                }

                if (operando.equals("")){
                    if (!escritura.getText().isEmpty()) {
                        num1 = Double.parseDouble(escritura.getText());
                        operando = value;
                        escritura.setText(String.valueOf(escritura.getText() + value).replace('.', ','));
                    }
                }      
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
        btnDec.addActionListener(numListener);
        
    }

    private void calcular() {
        try {
            if (!escritura.getText().contains(operando)) {
                resultado.setText("Error");
                return;
            }
    
            String[] partes = escritura.getText().split("\\" + operando);
            if (partes.length < 2 || partes[1].trim().isEmpty()) {
                resultado.setText("Error");
                return;
            }
    
            num2 = Double.parseDouble(partes[1].trim());
    
            double result = 0;
    
            switch (operando) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {  
                        resultado.setText("Syntax Error");
                        return; 
                    } else {
                        result = num1 / num2; 
                    }
                    break;
                default:
                    resultado.setText("Operador inválido");
                    return;
            }
            
            resultado.setText(String.valueOf(result).replace('.', ',')); 
        } catch (NumberFormatException e) {
            resultado.setText("Entrada inválida");
        } catch (Exception e) {
            resultado.setText("Error inesperado");
        }
    }


    private void updateMode() {
        String selectedMode = (String) modeSelector.getSelectedItem();

        switch (selectedMode) {
            case "Solo ratón":
                setMouseMode(true);
                setKeyboardMode(false);
                break;
            case "Solo teclado":
                setMouseMode(false);
                setKeyboardMode(true);
                break;
            default: // "Modo libre"
                setMouseMode(true);
                setKeyboardMode(true);
                break;
        }
    }

    private void setMouseMode(boolean enabled) {
        // Habilita/deshabilita los botones
        for (Component component : panelNumeros.getComponents()) {
            component.setEnabled(enabled);
        }
        for (Component component : panelOperadores.getComponents()) {
            component.setEnabled(enabled);
        }
    }

    private void setKeyboardMode(boolean enabled) {
        // Habilita/deshabilita entrada del teclado
        escritura.setFocusable(enabled);
        if (enabled) {
            escritura.requestFocus();
        }
    }
}
package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.Divicion;
import modelo.Multiplicacion;
import modelo.Resta;
import modelo.Suma;

/**
 * 
 * @author Adrian
 *
 */
public class Ventana extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7926404149181638529L;
	
	private JLabel lbNum1 = new JLabel("Número 1");
	private JTextField txtNum1 = new JTextField();
	
	private JLabel lbNum2 = new JLabel("Número 2");
	private JTextField txtNum2 = new JTextField();
	
	private JButton btnSuma = new JButton("+");
	private JButton btnResta = new JButton("-");
	private JButton btnMult = new JButton("x");
	private JButton btnDiv = new JButton("/");
	
	private JLabel lbResult = new JLabel("OK");
	
	Container c = getContentPane();
	
	Suma sum = new Suma();
	Resta resta = new Resta();
	Divicion div = new Divicion();
	Multiplicacion multi = new Multiplicacion();
	
	
	/**
	 * Constructor
	 * 
	 */
	public Ventana()
	{
		super.setTitle("Operaciones");
		super.setSize(320, 460);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		cargcarControles();
	}
	
	/**
	 * Carga los controles de la UI
	 */
	private void cargcarControles()
	{
		c.setLayout(null);
		
		lbNum1.setBounds(10,10,300,50);
		txtNum1.setBounds(10,50,300,50);
		
		lbNum2.setBounds(10,100,300,50);
		txtNum2.setBounds(10,140,300,50);
		
		btnSuma.setBounds(10,230,150,50);
		btnResta.setBounds(160, 230, 150, 50);
		btnMult.setBounds(10, 280, 150, 50);
		btnDiv.setBounds(160, 280, 150, 50);
		
		lbResult.setBounds(10,350,300,50);
		lbResult.setHorizontalAlignment(SwingConstants.CENTER);
		
		c.add(lbNum1);
		c.add(txtNum1);
		c.add(lbNum2);
		c.add(txtNum2);
		
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMult);
		c.add(btnDiv);
		
		c.add(lbResult);
		
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
	}

	/**
	 * Eventos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int result = 0;
		String tipo = "null";
		
		int n1 = Integer.parseInt( txtNum1.getText() );
		int n2 = Integer.parseInt( txtNum2.getText() );
		
		if (e.getSource() == btnSuma )
		{
			result = sum.operacion(n1, n2);
			tipo = "+";
		}
		
		if (e.getSource() == btnResta )
		{
			result = resta.operacion(n1, n2);
			tipo = "-";
		}
		
		if (e.getSource() == btnMult )
		{
			result = multi.operacion(n1, n2);
			tipo = "x";
		}
		
		if (e.getSource() == btnDiv )
		{
			result = div.operacion(n1, n2);
			tipo = "/";
		}
		
		lbResult.setText(String.format("%d %s %d = %d",n1, tipo, n2, result));
		
	}

}

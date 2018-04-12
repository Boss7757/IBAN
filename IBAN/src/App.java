import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class App {

	private JFrame frmIbanTikrinimas;

	private JTextField text;
	private JButton delete;
	private JLabel rezultatas;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmIbanTikrinimas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIbanTikrinimas = new JFrame();
		frmIbanTikrinimas.setTitle("IBAN tikrinimas");
		frmIbanTikrinimas.getContentPane().setForeground(Color.BLACK);
		frmIbanTikrinimas.setBounds(100, 100, 506, 399);
		frmIbanTikrinimas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIbanTikrinimas.getContentPane().setLayout(null);
		
		text = new JTextField();
		text.setBounds(29, 51, 249, 20);
		frmIbanTikrinimas.getContentPane().add(text);
		text.setColumns(10);
		
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
		fileChooser.setFileFilter(filter);
		
		JButton Validate = new JButton("Tikrinti");
		Validate.setBounds(342, 50, 93, 23);
		Validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IBAN = text.getText();
				
			if(Main.Tikrinti(IBAN)) 
			{
				rezultatas.setText("Teisingas");
				rezultatas.setForeground(new Color(0, 100, 0));
				}
			else {
				rezultatas.setText("Neteisingas");
				rezultatas.setForeground(new Color(120, 0, 0));
			}
			}


		});
		frmIbanTikrinimas.getContentPane().add(Validate);
		

		
		delete = new JButton("I\u0161valyti");
		delete.setBounds(342, 85, 93, 23);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { text.setText(null); rezultatas.setText("");
			}
		});
		frmIbanTikrinimas.getContentPane().add(delete);
		
		rezultatas = new JLabel("");
		rezultatas.setFont(new Font("Tahoma", Font.BOLD, 15));
		rezultatas.setForeground(new Color(0, 0, 0));
		rezultatas.setBounds(29, 88, 161, 20);
		frmIbanTikrinimas.getContentPane().add(rezultatas);
		
		JButton btnTikrintiTekstiniFail = new JButton("Tikrinti tekstini fail\u0105");
		btnTikrintiTekstiniFail.setBounds(29, 206, 154, 48);
		btnTikrintiTekstiniFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
			          File selectedFile = fileChooser.getSelectedFile();
			          System.out.println(selectedFile.getAbsolutePath());
			          try {
						Main.failoTikrinimas(selectedFile.getAbsolutePath());
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
			       }
				fileChooser.setBounds(25, 29, 582, 397);
			}
		});
		frmIbanTikrinimas.getContentPane().add(btnTikrintiTekstiniFail);
		
		lblNewLabel = new JLabel("S\u0105skaitos numeris IBAN");
		lblNewLabel.setBounds(29, 26, 179, 14);
		frmIbanTikrinimas.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Baigti darb\u0105");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(1);
			}
		});
		btnNewButton.setBounds(281, 206, 154, 48);
		frmIbanTikrinimas.getContentPane().add(btnNewButton);
	}

}

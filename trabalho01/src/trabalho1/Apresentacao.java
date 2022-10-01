package trabalho1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;

public class Apresentacao {

	JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextArea textArea;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void tela() {
		textField.setEditable(false);
		textArea.setEditable(false);
	}

	public Apresentacao() {
		initialize();
		tela();
	}
	
	//  Buscar o arquivo em html
	
	private void buscarArquivo() throws FileNotFoundException {
		JFileChooser fileChooser = new JFileChooser();
		StringBuilder fileName = new StringBuilder();

		fileChooser.setSelectedFile(new File(fileName.toString()));
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("HTML", "html"));
		int result = fileChooser.showOpenDialog(null);
		final File archive = fileChooser.getSelectedFile();

		if (result == JFileChooser.APPROVE_OPTION) {
			textField.setText(archive.getPath());
			ValidadorHTML validador = new ValidadorHTML(textField.getText());
			
			//validador.validarHTML();			
			
			String tags = validador.getOcorrenciaTags().toString();
			//OcorrenciaDeTag ocorrenciaDeTag = new OcorrenciaDeTag(tag);

			String informaçãoTags = "";
			String somenteTags = "";

			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(final int row, final int column) {
					return false;
				}
			};

			model.addColumn("Tags");
			model.addColumn("Número Ocorrências");

			table.setModel(model);
			textArea.setText(somenteTags);
			validador.validarHTML();
		}
	}

	
	private void jBotaoEscolherMouseClicked(ActionEvent e) throws FileNotFoundException {

		try {
			buscarArquivo();
		} catch (SintaxeInvalidaException ex) {
			textArea.setText(ex.getMessage());
		}

	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 661, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(103, 28, 391, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAnalisar = new JButton("Analisar");
		btnAnalisar.setBounds(504, 28, 123, 29);
		btnAnalisar.setBackground(Color.LIGHT_GRAY);
		btnAnalisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnalisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jBotaoEscolherMouseClicked(e);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
		
		frame.getContentPane().add(btnAnalisar);
		
		JLabel lblNewLabel = new JLabel("Arquivo:");
		lblNewLabel.setBounds(23, 25, 83, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(23, 67, 604, 176);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 253, 604, 201);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Quantidade", "Tag"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
	
	}

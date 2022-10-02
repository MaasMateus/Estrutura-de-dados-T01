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

import Lista03.ListaEncadeada;
import Lista03.NoLista;

import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;


public class Apresentacao {

	JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextArea textArea;
	private JScrollPane scrollPane;

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
			
			
			// Inicializa a table novamente, para que as informacoes do arquivo anterior não fiquem
			// aparentes apos a execução de um novo
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Tag", "Quantidade"
				}
			) 
			
			{
				Class[] columnTypes = new Class[] {
					String.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			
			scrollPane.setViewportView(table);
		
			textArea.setText("");
			
			try {
			
				ListaEncadeada<OcorrenciaDeTag> tags =  validador.validarHTML();			
			
				montarTabela(tags);
				
			} catch (SintaxeInvalidaException error) {
				textArea.setText(error.getMessage());
				
			}
			
		}

		
	}

	private void montarTabela(ListaEncadeada<OcorrenciaDeTag> tags) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		NoLista<OcorrenciaDeTag> no = tags.getPrimeiro();
		
		while (no != null) {
			
			OcorrenciaDeTag tagAtual = no.getInfo();
			
			model.addRow(new Object[] {tagAtual.getTag(), tagAtual.getOcorrencias()});
			//model.addRow(new Object[] {tagAtual.getTag(), tagAtual.getOcorrencias() });
			
			no = no.getProximo();
		}

		
		table.setModel(model);
		
		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 253, 604, 201);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Tag", "Quantidade"
			}
		) 
		
		
		{
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
	
	}
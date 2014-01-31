package com.converter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.Font;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConverterApp {

	private JFrame frame;
	private JTextField input;
	private JComboBox inputCombo;
	private JLabel resultLabel;
	private JComboBox resultCombo;
	private JLabel errorLabel;
	private JButton btnNewButton;

	private final String[] lengthUnits = new String[] { "km", "m", "mm",
			"miles", "yards", "feet" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterApp window = new ConverterApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConverterApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 123, 86, 52, 40, 27, 52, 0 };
		gbl_panel.rowHeights = new int[] { 20, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		input = new JTextField();
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.anchor = GridBagConstraints.NORTHWEST;
		gbc_input.insets = new Insets(0, 0, 5, 5);
		gbc_input.gridx = 1;
		gbc_input.gridy = 0;
		panel.add(input, gbc_input);
		input.setColumns(10);

		// inputCombo

		inputCombo = new JComboBox();

		GridBagConstraints gbc_inputCombo = new GridBagConstraints();
		gbc_inputCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_inputCombo.insets = new Insets(0, 0, 5, 5);
		gbc_inputCombo.gridx = 2;
		gbc_inputCombo.gridy = 0;
		panel.add(inputCombo, gbc_inputCombo);
		inputCombo.setModel(new DefaultComboBoxModel(lengthUnits));

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(40, 20));
		lblNewLabel.setIcon(new ImageIcon(ConverterApp.class
				.getResource("/com/converter/arrow.png")));

		resultLabel = new JLabel("result");
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.anchor = GridBagConstraints.WEST;
		gbc_resultLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultLabel.gridx = 4;
		gbc_resultLabel.gridy = 0;
		panel.add(resultLabel, gbc_resultLabel);

		// resultCombo
		resultCombo = new JComboBox();
		GridBagConstraints gbc_resultCombo = new GridBagConstraints();
		gbc_resultCombo.insets = new Insets(0, 0, 5, 0);
		gbc_resultCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_resultCombo.gridx = 5;
		gbc_resultCombo.gridy = 0;
		panel.add(resultCombo, gbc_resultCombo);
		resultCombo.setModel(new DefaultComboBoxModel(lengthUnits));

		btnNewButton = new JButton("Convert");

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);

		// errorLabel
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.insets = new Insets(0, 0, 0, 5);
		gbc_errorLabel.gridx = 2;
		gbc_errorLabel.gridy = 2;
		panel.add(errorLabel, gbc_errorLabel);

		// listeners

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorLabel.setText("");
				if (input.getText().isEmpty()) {
					errorLabel.setText("Empty input");

				} else {
					resultLabel.setText("25");
				}

			}
		});

		inputCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = (String) inputCombo.getSelectedItem();
				resultCombo.setModel(new DefaultComboBoxModel(lengthUnits));
				resultCombo.removeItem(input);
				errorLabel.setText(null);
				resultLabel.setText(null);
				//test
			}
		});

	}

}

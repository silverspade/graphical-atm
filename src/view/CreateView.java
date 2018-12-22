package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Database;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;
	
	private final static String SUBMIT = "Submit";
	
	private static long generatedAccountNumber = 100000009L;
	
	private JPasswordField pinField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField dobField;
	private JTextField phoneField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	
	private JButton submitButton;

	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initialies the CreateView components.
	 */
	
	private void initialize() {
		
		// you'll need to remove this when you start coding. for now, it's here only to
		// demonstrate that the button to create an account in LoginView.java correctly
		// navigates the user to CreateView.
		
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		//Account number, balance, and status were omitted
		initPinField();
		initLastNameField();
		initFirstNameField();
		initDobField();
		initPhoneField();
		initStreetField();
		initCityField();
		initStateField();
		initZipField();
		initSubmitButton();
		
		// TODO
		//
		// this is where you should build your create account form (i.e., all the
		// components that will allow the user to enter his or her information and
		// create a new account).
		//
		// feel free to use my layout in LoginView.java as an example for laying out
		// and positioning your components.
	}

	private void initPinField() {
		JLabel label = new JLabel("PIN", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(205, 140, 200, 35);
		pinField.addActionListener(this);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(205, 100, 200, 35);
		lastNameField.addActionListener(this);
		
		this.add(label);
		this.add(lastNameField);
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(205, 100, 200, 35);
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initDobField() {
		JLabel label = new JLabel("Date of Birth", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(dobField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		dobField = new JTextField(20);
		dobField.setBounds(205, 100, 200, 35);
		dobField.addActionListener(this);
		
		this.add(label);
		this.add(dobField);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(phoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneField = new JTextField(20);
		phoneField.setBounds(205, 100, 200, 35);
		phoneField.addActionListener(this);
		
		this.add(label);
		this.add(phoneField);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Street", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(streetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetField = new JTextField(20);
		streetField.setBounds(205, 100, 200, 35);
		streetField.addActionListener(this);
		
		this.add(label);
		this.add(streetField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(205, 100, 200, 35);
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateField = new JTextField(20);
		stateField.setBounds(205, 100, 200, 35);
		stateField.addActionListener(this);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initZipField() {
		JLabel label = new JLabel("ZIP code", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(20);
		zipField.setBounds(205, 100, 200, 35);
		zipField.addActionListener(this);
		
		this.add(label);
		this.add(zipField);
	}
	
	private void initSubmitButton() {	
		submitButton = new JButton("Submit");
		submitButton.setBounds(205, 180, 200, 35);
		submitButton.addActionListener(this);
		
		this.add(submitButton);
	}
	
	private boolean checking() {
		if (pinField.getPassword().length != 4) {
			System.out.println("Invalid PIN. Please re-enter");
			return false;
		}
		if (phoneField.getText().length() != 10) {
			System.out.println("Invalid phone number. Please re-enter");
			return false;
		} 
		if (stateField.getText().length() != 2) {
			System.out.println("Invalid state. Please re-enter");
			return false;
		}
		if (zipField.getText().length() != 5) {
			System.out.println("Invalid ZIP code. Please re-enter");
			return false;
		}
		return true;
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/**
	 * Responds to button clicks and other actions performed in the CreateView.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case SUBMIT:
			if (checking()) {
				long accountNumber = generatedAccountNumber++;
				String result = accountNumber + String.format("%-4s", pinField.getPassword()) + String.format("%-15.2f", 0) + String.format("%-20s", lastNameField.getText()) + String.format("%-15s", firstNameField.getText()) + String.format("%-8s", dobField.getText()) + String.format("%-10s", phoneField.getText()) + String.format("%-30s", streetField.getText()) + String.format("%-30s", cityField.getText()) + String.format("%-2s", stateField.getText()) + String.format("%-5s", zipField.getText()) + "Y";
				//manager.login(String.valueOf(accountNumber), pinField.getPassword());
				manager.switchTo(ATM.HOME_VIEW);
			}
			break;
		default: System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")"); break;
	}
		// TODO
		//
		// this is where you'll setup your action listener, which is reponsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
	
}
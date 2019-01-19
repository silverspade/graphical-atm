package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Database;
import model.BankAccount;
import model.User;
import controller.ViewManager;

@SuppressWarnings("serial")
public class InformationView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database

	private JTextField pinField;
	private JTextField accountNumField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField birthField;
	private JTextField phoneField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JComboBox stateDropdown;
	private JTextField zipField;
	
	private JButton editButton;
	private JButton backButton;
	private JButton saveButton;
	private JButton cancelButton;
	
	private JLabel errorMessageLabel;		
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	public void updateErrorMessage(String errorMessage) {
		errorMessageLabel.setText(errorMessage);
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		//Account number, balance, and status were omitted
		initEditButton();
		initBackButton();
		initSaveButton();
		initCancelButton();
		initInfoPortion();
		initErrorMessageLabel();
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
	}
	
	public void initInfoPortion() {
		initPinField();
		initActNumField();
		initLastNameField();
		initFirstNameField();
		initBirthField();
		initPhoneField();
		initStreetField();
		initCityField();
		initStateField();
		initStateDropdown();
		initZipField();
		stateDropdown.setVisible(false);
	}
	
	public void refreshInfo() {
		pinField.setText(Integer.toString(manager.getBankAccount().getUser().getPin()));
		accountNumField.setText(Long.toString(manager.getBankAccount().getAccountNumber()));
		lastNameField.setText(manager.getBankAccount().getUser().getLastName());
		firstNameField.setText(manager.getBankAccount().getUser().getFirstName());
		birthField.setText(Integer.toString(manager.getBankAccount().getUser().getDob()));
		phoneField.setText(Long.toString(manager.getBankAccount().getUser().getPhone()));
		streetField.setText(manager.getBankAccount().getUser().getStreetAddress());
		cityField.setText(manager.getBankAccount().getUser().getCity());
		stateField.setText(manager.getBankAccount().getUser().getState());
		zipField.setText(manager.getBankAccount().getUser().getZip());
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The InformationView class is not serializable.");
	}

	private void initPinField() {
		JLabel label = new JLabel("PIN", SwingConstants.RIGHT);
		label.setBounds(5, 10, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JTextField(20);
		pinField.setBounds(110, 10, 200, 35);
		pinField.setEditable(false);
		pinField.addActionListener(this);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initActNumField() {
		JLabel label = new JLabel("Acct.Num.", SwingConstants.RIGHT);
		label.setBounds(5, 50, 95, 35);
		label.setLabelFor(accountNumField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14)); 
		
		accountNumField = new JTextField(20);
		accountNumField.setBounds(110, 50, 200, 35);
		accountNumField.setEditable(false);
		accountNumField.addActionListener(this);
		
		this.add(label);
		this.add(accountNumField);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(5, 90, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(110, 90, 200, 35);
		lastNameField.setEditable(false);
		lastNameField.addActionListener(this);
		
		this.add(label);
		this.add(lastNameField);
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(5, 130, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(110, 130, 200, 35);
		firstNameField.setEditable(false);
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initBirthField() {
		JLabel label = new JLabel("DD MM YYYY", SwingConstants.RIGHT);
		label.setBounds(5, 170, 95, 35);
		label.setLabelFor(birthField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));

		birthField = new JTextField(20);
		birthField.setBounds(110, 170, 200, 35);
		birthField.setEditable(false);
		birthField.addActionListener(this);
		
		this.add(label);
		this.add(birthField);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(5, 210, 95, 35);
		label.setLabelFor(phoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));

		phoneField = new JTextField(20);
		phoneField.setBounds(110, 210, 200, 35);
		phoneField.setEditable(false);
		phoneField.addActionListener(this);
		
		this.add(label);
		this.add(phoneField);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Street", SwingConstants.RIGHT);
		label.setBounds(5, 250, 95, 35);
		label.setLabelFor(streetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetField = new JTextField(20);
		streetField.setBounds(110, 250, 200, 35);
		streetField.setEditable(false);
		streetField.addActionListener(this);
		
		this.add(label);
		this.add(streetField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(5, 290, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(110, 290, 200, 35);
		cityField.setEditable(false);
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(5, 330, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));

		stateField = new JTextField(20);
		stateField.setBounds(110, 330, 50, 35);
		stateField.setEditable(false);
		stateField.addActionListener(this);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initStateDropdown() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(5, 330, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] states = {"AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
		
		stateDropdown = new JComboBox(states);

		stateDropdown.setBounds(110, 330, 50, 35);
		
		this.add(label);
		this.add(stateDropdown);
	}
	
	private void initZipField() {
		JLabel label = new JLabel("ZIP code", SwingConstants.RIGHT);
		label.setBounds(5, 370, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(20);
		zipField.setBounds(110, 370, 200, 35);
		zipField.setEditable(false);
		zipField.addActionListener(this);
		
		this.add(label);
		this.add(zipField);
	}
	
	private void initEditButton() {	
		editButton = new JButton("Edit");
		editButton.setBounds(5, 410, 95, 35);
		editButton.addActionListener(this);
		
		this.add(editButton);
	}
	
	private void initSaveButton() {	
		saveButton = new JButton("Save");
		saveButton.setBounds(5, 410, 95, 35);
		saveButton.addActionListener(this);
		
		this.add(saveButton);
	}
	
	private void initBackButton() {	
		backButton = new JButton("Back");
		backButton.setBounds(110, 410, 200, 35);
		backButton.addActionListener(this);
		
		this.add(backButton);
	}
	
	private void initCancelButton() {	
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(110, 410, 200, 35);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		errorMessageLabel.setBounds(120, 240, 500, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
	}
	
//	public void setBankAccount(BankAccount setAccount) {
//		this.account = setAccount;
//	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(editButton)) {
			pinField.setEditable(true);
			phoneField.setEditable(true);
			streetField.setEditable(true);
			cityField.setEditable(true);
			zipField.setEditable(true);
			stateDropdown.setVisible(true);
			stateField.setVisible(false);
			
			editButton.setVisible(false);
			saveButton.setVisible(true);
			backButton.setVisible(false);
			cancelButton.setVisible(true);
		} else if (source.equals(cancelButton)) {
			pinField.setText(Integer.toString(manager.getBankAccount().getUser().getPin()));
			pinField.setEditable(false);
			accountNumField.setText(Long.toString(manager.getBankAccount().getAccountNumber()));
			accountNumField.setEditable(false);
			lastNameField.setText(manager.getBankAccount().getUser().getLastName());
			lastNameField.setEditable(false);
			firstNameField.setText(manager.getBankAccount().getUser().getFirstName());
			firstNameField.setEditable(false);
			birthField.setText(Integer.toString(manager.getBankAccount().getUser().getDob()));
			birthField.setEditable(false);
			phoneField.setText(Long.toString(manager.getBankAccount().getUser().getPhone()));
			phoneField.setEditable(false);
			streetField.setText(manager.getBankAccount().getUser().getStreetAddress());
			streetField.setEditable(false);
			cityField.setText(manager.getBankAccount().getUser().getCity());
			cityField.setEditable(false);
			stateField.setText(manager.getBankAccount().getUser().getState());
			stateField.setEditable(false);
			zipField.setText(manager.getBankAccount().getUser().getZip());
			zipField.setEditable(false);
			stateDropdown.setVisible(false);
			stateField.setVisible(true);
			
			editButton.setVisible(true);
			saveButton.setVisible(false);
			backButton.setVisible(true);
			cancelButton.setVisible(false);
			updateErrorMessage("");
		} else if (source.equals(backButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		}
		else if (source.equals(saveButton)) {
			if (manager.getBankAccount().getUser().isValidPin(Integer.valueOf(pinField.getText()), manager.getBankAccount().getUser().getPin()) == false) {
				updateErrorMessage("Invalid PIN");
			} else if (phoneField.getText().length() != 10 || manager.containsOnlyNumbers(phoneField.getText()) == false) {
				updateErrorMessage("Invalid phone");
			} else if (zipField.getText().length() != 5) {
				updateErrorMessage("Invalid zip code");
			} else {
				System.out.println("Saving...");
				manager.getBankAccount().getUser().setPin(manager.getBankAccount().getUser().getPin(), Integer.valueOf(pinField.getText()));
				manager.getBankAccount().getUser().setPhone(Long.valueOf(phoneField.getText()));
				manager.getBankAccount().getUser().setStreetAddress(streetField.getText());
				manager.getBankAccount().getUser().setCity(cityField.getText());
				manager.getBankAccount().getUser().setState(String.valueOf(stateDropdown.getSelectedItem()));
				manager.getBankAccount().getUser().setZip(zipField.getText());
				manager.updateAccount(manager.getBankAccount());
				System.out.println("Saved!");
				pinField.setText(Integer.toString(manager.getBankAccount().getUser().getPin()));
				pinField.setEditable(false);
				accountNumField.setText(Long.toString(manager.getBankAccount().getAccountNumber()));
				accountNumField.setEditable(false);
				lastNameField.setText(manager.getBankAccount().getUser().getLastName());
				lastNameField.setEditable(false);
				firstNameField.setText(manager.getBankAccount().getUser().getFirstName());
				firstNameField.setEditable(false);
				birthField.setText(Integer.toString(manager.getBankAccount().getUser().getDob()));
				birthField.setEditable(false);
				phoneField.setText(Long.toString(manager.getBankAccount().getUser().getPhone()));
				phoneField.setEditable(false);
				streetField.setText(manager.getBankAccount().getUser().getStreetAddress());
				streetField.setEditable(false);
				cityField.setText(manager.getBankAccount().getUser().getCity());
				cityField.setEditable(false);
				stateField.setText(manager.getBankAccount().getUser().getState());
				stateField.setEditable(false);
				zipField.setText(manager.getBankAccount().getUser().getZip());
				zipField.setEditable(false);
				stateDropdown.setVisible(false);
				stateField.setVisible(true);
				
				editButton.setVisible(true);
				saveButton.setVisible(false);
				backButton.setVisible(true);
				cancelButton.setVisible(false);
				updateErrorMessage("");
			}
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")"); 
		}
	}
}
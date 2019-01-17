package view;

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
	private BankAccount account;
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
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
		saveButton.setVisible(false);
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
		pinField.setText(Integer.toString(account.getUser().getPin()));
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
		accountNumField.setText(Long.toString(account.getAccountNumber()));
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
		lastNameField.setText(account.getUser().getLastName());
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
		firstNameField.setText(account.getUser().getFirstName());
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
		birthField.setText(Integer.toString(account.getUser().getDob()));
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
		phoneField.setText(Long.toString(account.getUser().getPhone()));
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
		streetField.setText(account.getUser().getStreetAddress());
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
		cityField.setText(account.getUser().getCity());
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
		stateField.setText(account.getUser().getState());
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
		zipField.setText(account.getUser().getZip());
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
		backButton = new JButton("Back/Cancel");
		backButton.setBounds(110, 410, 200, 35);
		backButton.addActionListener(this);
		
		this.add(backButton);
	}
	
	public void setBankAccount(BankAccount setAccount) {
		this.account = setAccount;
	}
	
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
			editButton.setVisible(false);
			saveButton.setVisible(true);
			stateDropdown.setVisible(true);
			stateField.setVisible(false);
		} else if (source.equals(backButton)) {
			manager.switchTo(ATM.HOME_VIEW);
			pinField.setText(Integer.toString(account.getUser().getPin()));
			pinField.setEditable(false);
			accountNumField.setText(Long.toString(account.getAccountNumber()));
			accountNumField.setEditable(false);
			lastNameField.setText(account.getUser().getLastName());
			lastNameField.setEditable(false);
			firstNameField.setText(account.getUser().getFirstName());
			firstNameField.setEditable(false);
			birthField.setText(Integer.toString(account.getUser().getDob()));
			birthField.setEditable(false);
			phoneField.setText(Long.toString(account.getUser().getPhone()));
			phoneField.setEditable(false);
			streetField.setText(account.getUser().getStreetAddress());
			streetField.setEditable(false);
			cityField.setText(account.getUser().getCity());
			cityField.setEditable(false);
			stateField.setText(account.getUser().getState());
			stateField.setEditable(false);
			zipField.setText(account.getUser().getZip());
			zipField.setEditable(false);
			editButton.setVisible(true);
			saveButton.setVisible(false);
			stateDropdown.setVisible(false);
			stateField.setVisible(true);
		} else if (source.equals(saveButton)) {
			System.out.println("Saving...");
			account.getUser().setPin(account.getUser().getPin(), Integer.valueOf(pinField.getText()));
			//Can add error message for if it was not valid and didn't changed
			account.getUser().setPhone(Long.valueOf(phoneField.getText()));
			account.getUser().setStreetAddress(streetField.getText());
			account.getUser().setCity(cityField.getText());
			account.getUser().setState(String.valueOf(stateDropdown.getSelectedItem()));
			account.getUser().setZip(zipField.getText());
			manager.updateAccount(account);
			System.out.println("Saved");
			pinField.setText(Integer.toString(account.getUser().getPin()));
			pinField.setEditable(false);
			accountNumField.setText(Long.toString(account.getAccountNumber()));
			accountNumField.setEditable(false);
			lastNameField.setText(account.getUser().getLastName());
			lastNameField.setEditable(false);
			firstNameField.setText(account.getUser().getFirstName());
			firstNameField.setEditable(false);
			birthField.setText(Integer.toString(account.getUser().getDob()));
			birthField.setEditable(false);
			phoneField.setText(Long.toString(account.getUser().getPhone()));
			phoneField.setEditable(false);
			streetField.setText(account.getUser().getStreetAddress());
			streetField.setEditable(false);
			cityField.setText(account.getUser().getCity());
			cityField.setEditable(false);
			stateField.setText(account.getUser().getState());
			stateField.setEditable(false);
			zipField.setText(account.getUser().getZip());
			zipField.setEditable(false);
			editButton.setVisible(true);
			saveButton.setVisible(false);
			stateDropdown.setVisible(false);
			stateField.setVisible(true);
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")"); 
		}
	}
}
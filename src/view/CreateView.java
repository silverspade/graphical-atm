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
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	
	private final static String SUBMIT = "Submit";
	private final static String CANCEL = "Cancel";
		
	private JPasswordField pinField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JComboBox daysField;
	private JComboBox monthsField;
	private JComboBox yearsField;
	private JTextField firstPhone;
	private JTextField secondPhone;
	private JTextField thirdPhone;
	private JTextField streetField;
	private JTextField cityField;
	private JComboBox stateField;
	private JTextField zipField;
	
	private JButton submitButton;
	private JButton cancelButton;
	
	private User createdUser;
	private BankAccount createdBank;
	
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
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
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
		initCancelButton();
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}

	private void initPinField() {
		JLabel label = new JLabel("PIN", SwingConstants.LEFT);
		//x,y,width,height
		label.setBounds(75, 50, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(110, 50, 200, 35);
		pinField.addActionListener(this);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(5, 90, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(110, 90, 200, 35);
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
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initDobField() {
		JLabel label = new JLabel("DD MM YYYY", SwingConstants.RIGHT);
		label.setBounds(5, 170, 95, 35);
		label.setLabelFor(daysField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "12", "12"};
		String[] years = new String[120];
		int startYear = 1900;
		for (int i = 0; i <= 119; i++) {
			years[i] = String.valueOf(startYear + i);
		}
		
		daysField = new JComboBox(days);
		monthsField = new JComboBox(months);
		yearsField = new JComboBox(years);
		
		daysField.setBounds(110, 170, 50, 35);
		monthsField.setBounds(180, 170, 50, 35);
		yearsField.setBounds(260, 170, 75, 35);
		
		this.add(label);
		this.add(daysField);
		this.add(monthsField);
		this.add(yearsField);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(5, 210, 95, 35);
		label.setLabelFor(firstPhone);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstPhone = new JTextField(3);
		firstPhone.setBounds(110, 210, 75, 35);
		firstPhone.addActionListener(this);
		
		secondPhone = new JTextField(3);
		secondPhone.setBounds(190, 210, 75, 35);
		secondPhone.addActionListener(this);
		
		thirdPhone = new JTextField(4);
		thirdPhone.setBounds(270, 210, 75, 35);
		thirdPhone.addActionListener(this);
		
		this.add(label);
		this.add(firstPhone);
		this.add(secondPhone);
		this.add(thirdPhone);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Street", SwingConstants.RIGHT);
		label.setBounds(5, 250, 95, 35);
		label.setLabelFor(streetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetField = new JTextField(20);
		streetField.setBounds(110, 250, 200, 35);
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
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(5, 330, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] states = {"AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
		
		stateField = new JComboBox(states);

		stateField.setBounds(110, 330, 50, 35);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initZipField() {
		JLabel label = new JLabel("ZIP code", SwingConstants.RIGHT);
		label.setBounds(5, 370, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(20);
		zipField.setBounds(110, 370, 200, 35);
		zipField.addActionListener(this);
		
		this.add(label);
		this.add(zipField);
	}
	
	private void initSubmitButton() {	
		submitButton = new JButton("Submit");
		submitButton.setBounds(5, 410, 95, 35);
		submitButton.addActionListener(this);
		
		this.add(submitButton);
	}
	
	private void initCancelButton() {	
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(110, 410, 95, 35);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case SUBMIT:
				//POSSIBLY ADD IN A CHECKING METHOD
				createdUser = new User(Integer.valueOf(String.valueOf(pinField.getPassword())), Integer.valueOf(String.valueOf(yearsField.getSelectedItem()) + String.valueOf(monthsField.getSelectedItem()) + String.valueOf(daysField.getSelectedItem())), Long.valueOf(firstPhone.getText() + secondPhone.getText() + thirdPhone.getText()), firstNameField.getText(), lastNameField.getText(), streetField.getText(), cityField.getText(), String.valueOf(stateField.getSelectedItem()), zipField.getText());
				System.out.println(createdUser.toString());
				manager.switchTo(ATM.LOGIN_VIEW);
				createdBank = new BankAccount('Y', manager.getNextAccountNumber(), 0.00, createdUser);
				System.out.println(createdBank.toString());
				manager.insertNewAccount(createdBank);
				System.out.println("Insert successful");
				break;
			case CANCEL:
				pinField.setText(null);
				lastNameField.setText(null);
				firstNameField.setText(null);
				daysField.setSelectedIndex(0);
				monthsField.setSelectedIndex(0);
				yearsField.setSelectedIndex(0);
				firstPhone.setText(null);
				secondPhone.setText(null);
				thirdPhone.setText(null);
				streetField.setText(null);
				cityField.setText(null);
				stateField.setSelectedIndex(0);
				zipField.setText(null);
				manager.switchTo(ATM.LOGIN_VIEW);
				break;
			default: System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")"); break;
		}
	}
}
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

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	
	private final static String SUBMIT = "Submit";
	
	private static long generatedAccountNumber = 100000009L;
	
	private JPasswordField pinField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField dobField;
	private JTextField firstPhone;
	private JTextField secondPhone;
	private JTextField thirdPhone;
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
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
			
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
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
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
		label.setBounds(50, 50, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(80, 50, 200, 35);
		pinField.addActionListener(this);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(5, 100, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(110, 100, 200, 35);
		lastNameField.addActionListener(this);
		
		this.add(label);
		this.add(lastNameField);
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(5, 150, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(110, 150, 200, 35);
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initDobField() {
		JLabel label = new JLabel("DOB", SwingConstants.RIGHT);
		label.setBounds(5, 200, 95, 35);
		label.setLabelFor(dobField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
		String[] years = new String[120];
		int startYear = 1900;
		for (int i = 0; i <= 119; i++) {
			years[i] = String.valueOf(startYear + i);
		}
		
		JComboBox daysField = new JComboBox(days);
		JComboBox monthsField = new JComboBox(months);
		JComboBox yearsField = new JComboBox(years);
		
		daysField.setBounds(110, 200, 50, 35);
		monthsField.setBounds(180, 200, 100, 35);
		yearsField.setBounds(300, 200, 75, 35);
		
		this.add(label);
		this.add(daysField);
		this.add(monthsField);
		this.add(yearsField);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(5, 250, 95, 35);
		label.setLabelFor(firstPhone);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstPhone = new JTextField(3);
		firstPhone.setBounds(110, 250, 75, 35);
		firstPhone.addActionListener(this);
		
		//Add in the other boxes
		
		this.add(label);
		this.add(firstPhone);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Street", SwingConstants.RIGHT);
		label.setBounds(300, 300, 95, 35);
		label.setLabelFor(streetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetField = new JTextField(20);
		streetField.setBounds(300, 300, 200, 35);
		streetField.addActionListener(this);
		
		this.add(label);
		this.add(streetField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(300, 300, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(300, 300, 200, 35);
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(300, 300, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateField = new JTextField(20);
		stateField.setBounds(300, 300, 200, 35);
		stateField.addActionListener(this);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initZipField() {
		JLabel label = new JLabel("ZIP code", SwingConstants.RIGHT);
		label.setBounds(300, 300, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(20);
		zipField.setBounds(300, 300, 200, 35);
		zipField.addActionListener(this);
		
		this.add(label);
		this.add(zipField);
	}
	
	private void initSubmitButton() {	
		submitButton = new JButton("Submit");
		submitButton.setBounds(300, 300, 95, 35);
		submitButton.addActionListener(this);
		
		this.add(submitButton);
	}
	
	private boolean checking() {
		if (pinField.getPassword().length != 4) {
			System.out.println("Invalid PIN. Please re-enter");
			return false;
		}
		/*if (phoneField.getText().length() != 10) {
			System.out.println("Invalid phone number. Please re-enter");
			return false;
		} */
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
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case SUBMIT:
				if (checking()) {
					long accountNumber = generatedAccountNumber++;
					String result = accountNumber + String.format("%-4s", pinField.getPassword()) + String.format("%-15.2f", 0) + String.format("%-20s", lastNameField.getText()) + String.format("%-15s", firstNameField.getText()) + String.format("%-8s", dobField.getText()) /*+ String.format("%-10s", phoneField.getText())*/ + String.format("%-30s", streetField.getText()) + String.format("%-30s", cityField.getText()) + String.format("%-2s", stateField.getText()) + String.format("%-5s", zipField.getText()) + "Y";
					//manager.login(String.valueOf(accountNumber), pinField.getPassword());
					manager.switchTo(ATM.HOME_VIEW);
				}
				break;
			default: System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")"); break;
		}
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}
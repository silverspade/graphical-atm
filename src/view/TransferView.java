package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Database;
import model.BankAccount;
import model.User;
import controller.ViewManager;

@SuppressWarnings("serial")
public class TransferView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	
	private JButton transferButton;
	private JButton cancelButton;
	private JTextField amountField;
	private JTextField destinationField;

	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public TransferView(ViewManager manager) {
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
		initLabel();
		initAmountField();
		initDestinationField();
		initTransferButton();
		initCancelButton();
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The DepositView class is not serializable.");
	}

	private void initLabel() {
		JLabel nameLabel = new JLabel("Deposit View", SwingConstants.LEFT);
		nameLabel.setBounds(20, 5, 250, 35);
		this.add(nameLabel);
	}
	
	private void initTransferButton() {	
		transferButton = new JButton("Transfer");
		transferButton.setBounds(270, 410, 95, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	private void initCancelButton() {	
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(110, 410, 95, 35);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	private void initAmountField() {
		JLabel label = new JLabel("Amount to transfer: ", SwingConstants.RIGHT);
		label.setBounds(5, 90, 200, 35);
		label.setLabelFor(amountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		amountField = new JTextField(20);
		amountField.setBounds(250, 90, 200, 35);
		amountField.addActionListener(this);
		
		this.add(label);
		this.add(amountField);
	}
	
	private void initDestinationField() {
		JLabel label = new JLabel("Acct. Num. to transfer to: ", SwingConstants.RIGHT);
		label.setBounds(5, 150, 230, 35);
		label.setLabelFor(destinationField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		destinationField = new JTextField(20);
		destinationField.setBounds(250, 150, 200, 35);
		destinationField.addActionListener(this);
		
		this.add(label);
		this.add(destinationField);
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
		if (source.equals(cancelButton)) {
			manager.switchTo(ATM.HOME_VIEW);
			manager.welcomeMessage("clear");
			manager.welcomeMessage("init");
			amountField.setText(null);
		} else if(source.equals(transferButton)) {
			BankAccount origin = manager.getBankAccount();
			BankAccount destination = manager.getAccount(Long.valueOf(destinationField.getText()));
			int result = origin.transfer(destination, Double.valueOf(amountField.getText()));
			if (result == 3) {
				manager.updateAccount(origin);
				manager.switchTo(ATM.HOME_VIEW);
				manager.welcomeMessage("clear");
				manager.welcomeMessage("init");
				amountField.setText(null);
			} else {
				System.out.println("Account Not Found");
			}
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
}
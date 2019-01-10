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
public class WithdrawView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	
	private JButton withdrawButton;
	private JButton cancelButton;
	private JTextField amountField;

	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public WithdrawView(ViewManager manager) {
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
		initWithdrawButton();
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
	
	private void initWithdrawButton() {	
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(270, 410, 95, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	private void initCancelButton() {	
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(110, 410, 95, 35);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	private void initAmountField() {
		JLabel label = new JLabel("Amount to withdraw: ", SwingConstants.RIGHT);
		label.setBounds(5, 90, 200, 35);
		label.setLabelFor(amountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		amountField = new JTextField(20);
		amountField.setBounds(250, 90, 200, 35);
		amountField.addActionListener(this);
		
		this.add(label);
		this.add(amountField);
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
		} else if(source.equals(withdrawButton)) {
			BankAccount account = manager.getBankAccount();
			int result = account.withdraw(Double.valueOf(amountField.getText()));
			if (result == 3) {
				manager.updateAccount(account);
				manager.switchTo(ATM.HOME_VIEW);
				manager.welcomeMessage("clear");
				manager.welcomeMessage("init");
				amountField.setText(null);
			} else if (result == 0) {
				System.out.println("Invalid Amount");
			} else {
				System.out.println("Insuffienct Funds");
			}
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
}
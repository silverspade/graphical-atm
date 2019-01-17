package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton logoutButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton informationButton;
	private JButton closeButton;
		
	private JLabel nameLabel;
	private JLabel acctNumLabel;
	private JLabel balanceLabel;
	
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		initLogoutButton();
		initDepositButton();
		initWithdrawButton();
		initTransferButton();
		initInfoButton();
		initCloseButton();
	}
	
	private void initLogoutButton() {	
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(20, 400, 200, 35);
		logoutButton.addActionListener(this);
		
		this.add(logoutButton);
	}
	
	private void initCloseButton() {	
		closeButton = new JButton("Close Account");
		closeButton.setBounds(20, 280, 250, 35);
		closeButton.addActionListener(this);
		
		this.add(closeButton);
	}
	
	private void initDepositButton() {	
		depositButton = new JButton("Deposit");
		depositButton.setBounds(20, 80, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	private void initWithdrawButton() {	
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(20, 130, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	private void initTransferButton() {	
		transferButton = new JButton("Transfer");
		transferButton.setBounds(20, 180, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	private void initInfoButton() {	
		informationButton = new JButton("View/Edit Personal Information");
		informationButton.setBounds(20, 230, 250, 35);
		informationButton.addActionListener(this);
		
		this.add(informationButton);
	}
	
	public void welcomeMessage(String method) {
		if (method.equals("init")) {
			String nameMessage = "Welcome " + manager.getBankAccount().getUser().getName();
			nameLabel = new JLabel(nameMessage, SwingConstants.LEFT);
			nameLabel.setBounds(20, 5, 200, 35);
			
			String accountNumMessage = "Account Number: " + manager.getBankAccount().getAccountNumber();
			acctNumLabel = new JLabel(accountNumMessage, SwingConstants.LEFT);
			acctNumLabel.setBounds(20, 20, 200, 35);
			
			String balanceMessage = "Current Balance: " + manager.getBankAccount().getBalance();
			balanceLabel = new JLabel(balanceMessage, SwingConstants.LEFT);
			balanceLabel.setBounds(20, 35, 200, 35);
		} else if (method.equals("update")) {
			nameLabel.setText("Welcome " + manager.getBankAccount().getUser().getName());
			acctNumLabel.setText("Account Number: " + manager.getBankAccount().getAccountNumber());
			balanceLabel.setText("Current Balance: " + manager.getBankAccount().getBalance());
		} else {
			nameLabel.setText("");
			acctNumLabel.setText("");
			balanceLabel.setText("");
		}
		
		this.add(nameLabel);
		this.add(acctNumLabel);
		this.add(balanceLabel);
	}
	
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(depositButton)) {
			manager.switchTo(ATM.DEPOSIT_VIEW);
		} else if (source.equals(withdrawButton)) {
			manager.switchTo(ATM.WITHDRAW_VIEW);
		} else if (source.equals(transferButton)) {
			manager.switchTo(ATM.TRANSFER_VIEW);
		} else if (source.equals(logoutButton)){
			if (manager.confirm() == 1) {
				manager.switchTo(ATM.LOGIN_VIEW);
				manager.welcomeMessage("clear");
			} 
		} else if (source.equals(closeButton)) {
			if (manager.confirm() == 1) {
				manager.switchTo(ATM.LOGIN_VIEW);
				manager.welcomeMessage("clear");
				if (manager.closeAccount(manager.getBankAccount()) == true) {
					System.out.println("Closing successful");
				} else {
					System.out.println("Closing unsuccessful");
				}
			} 
		} else if (source.equals(informationButton)) {
			manager.switchTo(ATM.INFORMATION_VIEW);
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
}
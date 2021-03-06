package controller;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JOptionPane;

import data.Database;
import model.BankAccount;
import view.ATM;
import view.HomeView;
import view.LoginView;

public class ViewManager {
	
	private Container views;				// the collection of all views in the application
	private Database db;					// a reference to the database
	private BankAccount account;			// the user's bank account
	private BankAccount destination;		// an account to which the user can transfer funds
	
	/**
	 * Constructs an instance (or object) of the ViewManager class.
	 * 
	 * @param layout
	 * @param container
	 */
	
	public ViewManager(Container views) {
		this.views = views;
		this.db = new Database();
	}
	
	///////////////////// INSTANCE METHODS ////////////////////////////////////////////
	
	/**
	 * Routes a login request from the LoginView to the Database.
	 * 
	 * @param accountNumber
	 * @param pin
	 */
	
	public void login(String accountNumber, char[] pin) {
		String userPin = new String(pin);
		LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
		if (accountNumber != null && userPin != null && accountNumber.length() > 0 && userPin.length() > 0) {
			account = db.getAccount(Long.valueOf(accountNumber), Integer.valueOf(new String(pin)));
			if (account == null) {
				lv.updateErrorMessage("Invalid account number and/or PIN.");
			} else if (account.getStatus() == 'N') {
				lv.updateErrorMessage("Account Closed");
			} else {
				switchTo(ATM.HOME_VIEW);
				welcomeMessage("init");
				welcomeMessage("clear");
				welcomeMessage("update");
				lv.clear();
				refreshBankInfo(account);
				lv.updateErrorMessage("");
				System.out.println("Logged in!");
			}
		}
	}
	
	public void refreshBankInfo(BankAccount account) {
		view.InformationView iv = ((view.InformationView) views.getComponents()[ATM.INFORMATION_VIEW_INDEX]);
		iv.refreshInfo();;
	}
	
	public void welcomeMessage(String method) {
		HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
		hv.welcomeMessage(method);
	}
	
	public long getNextAccountNumber() {
		return db.getMaxAccountNumber() + 1;
	}
	
	public boolean insertNewAccount(BankAccount newAccount) {
		return db.insertAccount(newAccount);
	}
	/**
	 * Switches the active (or visible) view upon request.
	 * 
	 * @param view
	 */
	
	public void switchTo(String view) {
		((CardLayout) views.getLayout()).show(views, view);
	}
	
	/**
	 * Routes a shutdown request to the database before exiting the application. This
	 * allows the database to clean up any open resources it used.
	 */
	
	public void shutdown() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Shutdown ATM",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.shutdown();
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		if (confirm() == 1) {
			account = null;
			switchTo(ATM.LOGIN_VIEW);
			welcomeMessage("clear");
		}
	}
	
	public int confirm() {
		int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Confirm choice",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				return 1;
			} else {
				return -1;
			}
	}	
	
	public BankAccount getBankAccount() {
		return account;
	}
	
	public boolean updateAccount(BankAccount account) {
		return db.updateAccount(account);
	}
	
	public BankAccount getAccount(long accountNumber) {
		return db.getAccount(accountNumber);
	}
	
	public boolean closeAccount(BankAccount account) {
		return db.closeAccount(account);
	}
	
	public boolean containsOnlyNumbers(String str) {        
        if (str == null || str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }
}

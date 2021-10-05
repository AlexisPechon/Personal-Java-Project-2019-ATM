/*
ATM.java
S Slav
22/6/2020
*/
public class ATM{
	//Data Members
	private boolean choiceValidator; //Checks if the choice is valid or not
	private boolean validator; //Checks if the password entered is correct.
	private String goAgain;
	private String userName;
	private int password;
	private int choice; //Variable will let the user choose whether between options 1 and 2.
	private int passwordCounter; //Password counter will count the amount of failed attempts
	private double withdrawAmount;
	private double depositAmount;
	private double balance; //The amount of money the user has in their bank account originally;
	private double newBalance; //The amount of money the user has in their bank account when they deposit or withdraw money.
	//Constructor
	public ATM(){
		choiceValidator=false;
		validator=false;
		goAgain="";
		userName="";
		password=0;
		choice=0;
		withdrawAmount=0.0;
		depositAmount=0.0;
		balance=0.0;
		newBalance=0.0;
	}
	//Setters
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPassword(int password){
		this.password=password;
	}
	public void setChoice(int choice){
		this.choice=choice;
	}
	public void setWithdrawAmount(double withdrawAmount){
		this.withdrawAmount=withdrawAmount;
	}
	public void setDepositAmount(double depositAmount){
		this.depositAmount=depositAmount;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	//Process
	public void balanceWithdraw(){
		//Process used to calculate the withdraw amount

			newBalance=balance-withdrawAmount;

	}
	public void balanceDeposit(){
		//Process used to calculate the deposit amount

			newBalance=balance+depositAmount;

	}
	//Getters
	public double getNewBalance(){ //Returning the new balance the user has back to the user
		return newBalance;
	}
}
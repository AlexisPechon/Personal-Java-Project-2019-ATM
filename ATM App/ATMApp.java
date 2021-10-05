/*
ATMApp.java
S Slav
22/6/2020
*/
import java.util.Scanner;
public class ATMApp{//Opening class bracket
	public static void main(String args[]){//Opening main method
		//Variables
		String goAgain;
		String userName;
		int password;
		int choice;
		double withdrawAmount;
		double depositAmount;
		double balance;
		double newBalance;
		//Objects
		Scanner in = new Scanner(System.in);
		ATM myATM = new ATM();
		//Welcome Message
		System.out.println("Welcome to my bank app!");
		System.out.println();//Space added for cosmetic reasons
		do{
			//Inputs
			System.out.println("Please enter your username");
			userName=in.next();
			//Error Checking to see if the user name is valid
			String[] validUsernames={"Slav","Pax","Milk"};
			boolean validator=false;
			while(validator==false){//Opening while loop
				for(int i=0;i<validUsernames.length;i++){//Beginning for loop
					if(validUsernames[i].equalsIgnoreCase(userName)){
						System.out.println("Welcome "+userName+"!");
						validator=true;
					}
				}//Closing for loop
				if(validator==false){
					System.out.println("Invalid username, please try again");
					userName=in.next();
				}
			}//Closing while loop
			//End of Error Checking
			System.out.println();
			System.out.println("Please enter your password");
			password=in.nextInt();
			//Error Checking to see if the password is valid
			int[] validPassword={111,222,333};
			//Boolean passwordValidator to check the password
			boolean passwordValidator=false;
			while(passwordValidator==false){
				for(int index=0;index<validPassword.length;index++){
					//For loop to access the array
					if(validPassword[index]==(password)){
						//If the array that contains the valid passwords equal to the password the user puts in, program will run
						passwordValidator=true;
					}
				}
				if(passwordValidator==false){
					//If false, the program will loop until the user inputs the right password
					System.out.println("Invalid password, please try again");
					password=in.nextInt();
				}
			}
			//End of Error Checking
			System.out.println();
			System.out.println("What is your balance?");
			balance=in.nextDouble();
			myATM.setBalance(balance);
			System.out.println();
			System.out.println("Your balance is "+balance);
			System.out.println();
			System.out.println("Choose what you want to do from the choices below");
			System.out.println();
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Exit");
			choice=in.nextInt();
			myATM.setChoice(choice);
			//Validating
			boolean choiceValidator=false;
			while(choiceValidator==false){
				//While loop to loop when the choice validator is false
				switch(choice){
					case 1:
						System.out.println("Enter the amount you wish to deposit");
						depositAmount=in.nextDouble();
						myATM.setDepositAmount(depositAmount);
						choiceValidator=true;
						while(depositAmount>balance){
							System.out.println("Insufficient amount to deposit");
							depositAmount = in.nextDouble();
							myATM.setDepositAmount(depositAmount);
						}
						myATM.balanceDeposit();
						break;
					case 2:
						System.out.println("Enter the amount you wish to withdraw");
						withdrawAmount=in.nextDouble();
						myATM.setWithdrawAmount(withdrawAmount);
						choiceValidator=true;
						//Error Checking
						while(withdrawAmount>balance){
							System.out.println("Insufficent funds to withdraw, please try again");
							withdrawAmount=in.nextDouble();
							myATM.setWithdrawAmount(withdrawAmount);
						}
						//Error Checking
						while(withdrawAmount<0){
							System.out.println("Insufficent funds, please try again");
							withdrawAmount=in.nextDouble();
							myATM.setWithdrawAmount(withdrawAmount);
						}
						myATM.balanceWithdraw();
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("You have exceeded the boundaries, please select from 1,2 or 3");
						choice=in.nextInt();
						break;
				}
			}
			//Outputs
			newBalance=myATM.getNewBalance();
			System.out.println("Your new balance is: "+newBalance);//Displays the new balance back to the user
			System.out.println("Enter yes to go again");//Do while loop will continue to execute if the input enters yes
			goAgain=in.next();
		}while(goAgain.equalsIgnoreCase("Yes"));
		System.out.println("Thank you for using this ATM");
	}//Closing main method
}//Closing class bracket
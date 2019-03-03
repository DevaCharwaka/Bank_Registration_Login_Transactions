package com.bank.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.bank.login.*;
import com.bank.model.Customer;


 
public class AllProcess {
	static Scanner scan=new Scanner(System.in);
	static ArrayList<Customer> list=new ArrayList<Customer>();
	//static BankLogin blogin=new BankLogin();
	
public static void register() throws Exception {
		System.out.println("enter no of customers");
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
		Customer cust=new Customer();
		System.out.println("enter first name");
		cust.setFirstName(scan.next());
		System.out.println("enter last name");
		cust.setLastName(scan.next());
		System.out.println("enter aadhar number");
		cust.setAadharNo(scan.nextLong());
	
		System.out.println("enter address");
		cust.setAddress(scan.next());
		System.out.println("enter mobile number");
		cust.setMobileNo(scan.nextLong());
		System.out.println("enter password");
		cust.setPassword(scan.next());
//		System.out.println("enter account number");
		Random random =new Random();
		int accNo= random.nextInt(999999999)+random.nextInt(999999);
		cust.setAccNo(accNo);
		System.out.println("your account number is "+cust.getAccNo());	//System.out.println(Math.abs(cust.getAccNo()));
		list.add(cust);
		login();
		
		}
		serializeArray();
	}
	static void serializeArray()throws Exception{
		
			FileOutputStream output = new FileOutputStream("E:\\custdetails.txt");
			ObjectOutputStream object=new ObjectOutputStream(output);
			object.writeObject(list);
			object.close();
	}
/*	 public static ArrayList<Customer> deserializeArray() throws Exception {
		
			FileInputStream out=new FileInputStream("user1.txt");
			ObjectInputStream obj=new ObjectInputStream(out);
			ArrayList<Customer> array=(ArrayList<Customer>)obj.readObject();
			return array;
		/**		long aadhar=scan.nextLong();
				for(int i=0;i<array.size();i++) {
					Customer customer = array.get(i);
					if(customer.getAadharNo()==aadhar) 
						login();
					else
						register();
						//blogin.login();
					}*/
			
		
	
	
	
	public static void login() throws Exception {
		Transactions transaction = new Transactions();
		System.out.println("acc no and password required for login");
		System.out.println("enter acc no");
		int ano=scan.nextInt();
System.out.println("enter password");
		String pass=scan.next();
		if(list!=null) {
		for(Customer cust10:list) {
			if((cust10.getAccNo()==ano)&&(cust10.getPassword().equals(pass))) 
				transaction.select();
			else
				System.out.println("username or password is wrong");
					}
		}
		else 
			System.out.println("no details in data base");
	}

/*	static void withdraw(int amont) {
		for(Customer cust3:list) {
			if(cust3.getBalance()<amont)
				System.out.println("insufficient balance");
			else {
				//double bal;
				double bal=cust3.getBalance();
				bal=bal-amont;
				System.out.println(bal);
			}
		}		
	}
	static int exit() {
	int  count=0;
		return count;
	}
	static void deposit(int amont1) {
		for(Customer cust5:list){
		//double bal;
		double bal=cust5.getBalance();
		bal=bal+amont1;
		System.out.println(bal);
		}
	}*/ 
	public static void choose() throws Exception {
		System.out.println("enter \n 1 for registration\n 2 for login");
		int option=scan.nextInt();
			switch(option) {
			case 1: register();
		//			break;
			case 2: login();
					break;
			default:System.exit(0);
			}

	}
	public static void main(String[] args)throws Exception {
		
		choose();
		}
}

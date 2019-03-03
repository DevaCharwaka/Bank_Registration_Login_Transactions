
package com.bank.login;

import com.bank.model.*;
import com.bank.view.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Transactions  {
 	static Customer obj1 = new Customer();
	//static AllProcess obj = new AllProcess();
 	private static double bal=0;
//	private static double bal = 0;
	//static Tranasctions  = new Tranasactions();
//	static ArrayList<Customer> array = obj.deserializeArray();
	static Scanner sc =new Scanner(System.in);
	public static void select()throws Exception{
			
		while(true) {
			System.out.println("1 for withdraw, 2 for deposit, 3 for exit");
		int choice =  sc.nextInt();
		switch(choice) {
		
		case 1: //System.out.println("Enter the amount u want to withdraw");
				
				withdraw();
				break;
		case 2: //System.out.println("Enter the amount u want to deposit");
				deposit();
				break;
		case 3: System.exit(0);
				break;
		default:{ 
				}
						}
		}
		}
	public static  ArrayList<Customer> deserializeArray() throws Exception {
			
			FileInputStream out=new FileInputStream("E:\\custdetails.txt");
			ObjectInputStream obj=new ObjectInputStream(out);
			ArrayList<Customer> array=(ArrayList<Customer>)obj.readObject();
			return array;
	 }
	
	 public static void withdraw() throws Exception {
		 int amount1;
			System.out.println("enter the amount to withdraw");
			amount1 = sc.nextInt();
			if(amount1>bal)
			System.out.println("insufficient balance");
			else {
				bal=bal-amount1;
				obj1.setBalance(bal);
				System.out.println(bal);
			}
		}
	
	static void exit() {
	System.out.println("you choosed to exit");
		System.exit(0);
	}
	
	public static void deposit() throws Exception {
		int amount;
		System.out.println("enter the amount to deposit ");
		amount = sc.nextInt();
//		ArrayList<Customer> array2 = deserializeArray();
		bal=bal+amount;
		obj1.setBalance(bal);
		System.out.println(bal);
		}
	}
	




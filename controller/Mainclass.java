package gaming.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import gaming.dao.HibernateLogic;
import gaming.dto.player;
import gaming.services.AES;

public class Mainclass {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		HibernateLogic h = new HibernateLogic();
		player p = new player();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Name : ");
			p.setName(new Scanner(System.in).nextLine());
			System.out.println("Enter Age :");
			int age = sc.nextInt();
			if (age < 18) {
				System.out.println("Ur not allowed to play");
			} 
			else 
			{
				p.setAge(age);
				System.out.println("Enter Phone Number :");
				p.setPhonenumber(sc.nextLong());
				System.out.println("Enter Email :");
				p.setEmail(sc.next());
				System.out.println("Enter Password :");
				p.setPassword(AES.encrypt(sc.next(),"77"));
				System.out.println("Enter Deposite Amount :");
				double deposite = sc.nextDouble();
				System.out.println("Deposite :" + deposite);
				double eachRound = deposite / 3;
				System.out.println("Each round :" + eachRound);
				double earn = 0;
				p.setDepositeamt(deposite);
				int[] arr = new GeneratorClass().generate();
				System.out.println(Arrays.toString(arr));
				for (int j = 1; j <= 3; j++) {
					int f = 0;
					System.out.println("Enter Your " + j + "Chance number :");
					int n = sc.nextInt();
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] == n) {
							f = 1;
						}
					}
					if (f == 1) {
						deposite = deposite + eachRound;
						earn = earn + eachRound;
					} else {
						System.out.println("Bad luck :Sorry Your Wrong Option");
						deposite = deposite - eachRound;
						earn = earn - eachRound;
					}
				}
				if (earn > 0) {
					p.setProfit(earn);
					p.setEarnedamt(deposite + earn);
				} else {
					p.setProfit(0);
					p.setEarnedamt(0);
				}
				System.out.println("After deposite :" + deposite);
				System.out.println("After earn :" + earn);
				System.out.println("enter path");
				String path = new Scanner(System.in).nextLine();
				FileInputStream stream = new FileInputStream(path);
				byte[] photo = new byte[stream.available()];
				stream.read(photo);
				p.setImage(photo);
				h.addObject(p);
			}
		}
	}
}
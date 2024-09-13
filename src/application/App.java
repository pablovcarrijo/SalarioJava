package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;
import model.enums.WorkerLevel;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter work data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level),baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			
			System.out.println("Enter contract number #" + i + " data: ");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			sc.nextLine();
			
			HourContract hr = new HourContract(date, valuePerHour, duration);
			worker.addContract(hr);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		double salary = worker.income(year, month);
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

}

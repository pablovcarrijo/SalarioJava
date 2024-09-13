package model.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private HourContract hourContract;
	private List<HourContract> listContract = new ArrayList<>();
	private int y = 0;
	private Department department;
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerLevel getLevel() {
		return level;
	}
	
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public List<HourContract> getListContract(){
		return this.listContract;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public void addContract(HourContract hourContract) {
		listContract.add(hourContract);
	}

	public void removeContract(HourContract hourContract) {
		listContract.remove(hourContract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : listContract){
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		
		}
		return sum;
	}

}

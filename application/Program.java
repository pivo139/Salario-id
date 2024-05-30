package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        
        List<Employee> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++) {
        	System.out.println();
        	System.out.printf("Employee #" + (i+1)+ ":\n");
        	System.out.print("Id: ");
        	Integer id = sc.nextInt();
        	System.out.print("Name: ");
        	sc.nextLine();
        	String name = sc.nextLine();
        	System.out.print("Salary: ");
        	double Salary = sc.nextDouble();
        	
        	Employee emp = new Employee(id, name, Salary);
        	
        	list.add(emp);
        }
        
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idsalary = sc.nextInt();
        Integer pos = position(list, idsalary);
        
        if(pos == null){
        	System.out.print("This id does not exist");
        }
        else {
        	System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            list.get(pos).IncreaseSalary(percentage);
        }
        
        System.out.println();
        System.out.println("List of employees: ");
        for(Employee emp: list){
        	System.out.println(emp);
        }
        
        sc.close();
	}

	public static int position(List<Employee> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId()== id) {
				return i;
			}
		}
		 
		return -1;
	
	}
	
}

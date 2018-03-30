package cn.w3cschool.struts2;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

public class Employee1 {
   private String name;
   private String department;

   public Employee1(){}
   public Employee1(String name,String department)
   {
      this.name = name;
      this.department = department;
   }
   private List employees;
   private List contractors;
	
   public String execute() {
      employees = new ArrayList();
      employees.add(new Employee1("George","Recruitment"));
      employees.add(new Employee1("Danielle","Accounts"));
      employees.add(new Employee1("Melissa","Recruitment"));
      employees.add(new Employee1("Rose","Accounts"));

      contractors = new ArrayList();
      contractors.add(new Employee1("Mindy","Database"));
      contractors.add(new Employee1("Vanessa","Network"));
      return "success";
   }

   public Decider getRecruitmentDecider() {
      return new Decider() {
         public boolean decide(Object element) throws Exception {
            Employee1 employee = (Employee1)element;
            return employee.getDepartment().equals("Recruitment");
         }
      };
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getDepartment() {
      return department;
   }
   public void setDepartment(String department) {
      this.department = department;
   }
   public List getEmployees() {
      return employees;
   }
   public void setEmployees(List employees) {
      this.employees = employees;
   }
   public List getContractors() {
      return contractors;
   }
   public void setContractors(List contractors) {
      this.contractors = contractors;
   }
}
package cn.w3cschool.struts2;

import java.util.Date;

public class HelloWorld3 {
	   private Date currentDate;
	   
	   public String execute() throws Exception{
	      setCurrentDate(new Date());
	      return "success";
	   }
	   public void setCurrentDate(Date date){
	      this.currentDate = date;
	   }
	   public Date getCurrentDate(){
	      return currentDate;
	   }
}
package cn.w3cschool.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class SystemDetails extends ActionSupport {
	  private Environment environment = new Environment("Development");
	   private String operatingSystem = "Windows 10";

	   public String execute()
	   {
	      return SUCCESS;
	   }
	   public Environment getEnvironment() {
	      return environment;
	   }
	   public void setEnvironment(Environment environment) {
	      this.environment = environment;
	   }
	   public String getOperatingSystem() {
	      return operatingSystem;
	   }
	   public void setOperatingSystem(String operatingSystem) {
	      this.operatingSystem = operatingSystem;
	   }
}

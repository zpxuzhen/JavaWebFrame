package cn.w3cschool.struts2;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class HelloWorld2{
   private String name;
   public String execute()
   {
      List names = new ArrayList();
      names.add("Robert");
      names.add("Page");
      names.add("Kate");
      ServletActionContext.getRequest().setAttribute("names", names);
      return "success";
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}

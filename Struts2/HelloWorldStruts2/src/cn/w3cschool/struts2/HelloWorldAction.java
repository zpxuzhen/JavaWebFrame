package cn.w3cschool.struts2;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloWorldAction{
	   private String name;

	   public String execute() throws Exception {
		   ValueStack stack = ActionContext.getContext().getValueStack();
		      Map<String, Object> context = new HashMap<String, Object>();

		      context.put("key1", new String("This is key1")); 
		      context.put("key2", new String("This is key2"));
		      stack.push(context);

		      System.out.println("Size of the valueStack: " + stack.size());
		      
		      /*打开注释,测试异常
		      //故意引入一个异常
		      String x = null;
		      x = x.substring(0);
		      */
		      
	      return "success";
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
}

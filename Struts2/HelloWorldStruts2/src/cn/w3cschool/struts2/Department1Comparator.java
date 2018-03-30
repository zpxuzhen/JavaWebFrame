package cn.w3cschool.struts2;

import java.util.Comparator;

public class Department1Comparator implements Comparator {
   public int compare(Employee1 e1, Employee1 e2) {
      return e1.getDepartment().compareTo(e2.getDepartment());
   }

   @Override
   public int compare(Object arg0, Object arg1) {
		return 0;
	}
}

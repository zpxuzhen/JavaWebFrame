package cn.w3cschool.struts2;

import java.util.Map;
/*类型转换器,需要全局注册xwork-conversion.properties或局部注册*/
import org.apache.struts2.util.StrutsTypeConverter;

   public class EnvironmentConverter extends StrutsTypeConverter {
      @Override
      public Object convertFromString(Map context, String[] values, Class clazz) {
	      Environment env = new Environment(values[0]);
	      return env;
      }

	   @Override
	   public String convertToString(Map context, Object value) {
	      Environment env  = (Environment) value;
	      return env == null ? null : env.getName();
	   }	
}

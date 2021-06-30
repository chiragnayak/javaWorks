package General.concepts.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
@ interface TesterInfo {
	
	int id() default 1;
	
	public enum Priority {
		HIGH,
		MEDIUM,
		LOW
	}
	
	Priority priority () default Priority.MEDIUM;
	String [] tags () default "";
	String createdBy () default "chirag";
	String lastModified () default "1/1/2011";

}

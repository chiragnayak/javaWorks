package General.concepts.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("Testing Suite");

		Class<SomeTest> obj = SomeTest.class;
		
		if(obj.isAnnotationPresent(TesterInfo.class)) {
			
			Annotation annotation = obj.getAnnotation(TesterInfo.class);
			TesterInfo annoData = (TesterInfo) annotation;
			
			System.out.println("Execute -> Test ID : "+ annoData.id());
			System.out.println("Priority : "+ annoData.priority().toString());
			System.out.println("Tags :  ");
			Arrays.asList(annoData.tags()).stream().forEach(System.out::println);
			System.out.println("Created BY : "+ annoData.createdBy());
			System.out.println("last modified : "+ annoData.lastModified());
			
			long enabled = Arrays.asList(obj.getMethods()).stream().filter(x -> {
				if(x.isAnnotationPresent(Test.class)) {
					Test anno = x.getAnnotation(Test.class);
					if(anno.enabled()) {
						try {
							((Method)x).invoke(obj.newInstance());
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (InstantiationException e) {
							e.printStackTrace();
						}
						return true;
					}else {
						return false;
					}
					
				}else {
					return false;				
				}
			}).count();
			
			System.out.println("Tests enabled : "+enabled);
			
		}
		
	}

}

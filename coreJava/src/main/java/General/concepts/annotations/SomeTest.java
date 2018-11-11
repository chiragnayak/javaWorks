package General.concepts.annotations;

import General.concepts.annotations.TesterInfo.Priority;

@TesterInfo(
		id = 1,
		priority = Priority.HIGH,
		createdBy = "chirag nayak",
		tags = {"infra", "serialize"},
		lastModified = "17/12/1985"
		)
public class SomeTest {
	
	@Test(enabled=true)
	public void method1() {
		System.out.println("This is method 1 -> ");
	}
	
	@Test(enabled=true)
	public void method2() {
		System.out.println("This is method 2 -> ");
	}
	
	@Test(enabled=false)
	public void method3() {
		System.out.println("This is method 3 -> ");
	}
	
	@Test(enabled=true)
	public void method4() {
		System.out.println("This is method 4 -> ");
	}
}

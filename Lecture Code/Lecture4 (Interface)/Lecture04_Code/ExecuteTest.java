
public class ExecuteTest {

	public static void main(String[] args) {
		Execute e = new Execute() {
			
			@Override
			public void doIt() {
				System.out.println("Anonymous inner class");
			}
		};
		
		Execute f = () -> System.out.println("Functional interface");
		
		e.doIt();
		f.doIt();
	}

}

package pakage10.테스트;

public class D22 {

	public class Main {
	    public static void main(String[] args) {
	        MyClass obj = new MyClass(); // 객체 생성
	        
	        Class<? extends MyClass> objClass = obj.getClass(); // 객체의 타입을 변수에 담음
	        
	        String className = objClass.getSimpleName(); // 간단한 클래스 이름만 담음
	        System.out.println(className); // 간단한 클래스 이름 출력
	    }
	}
}

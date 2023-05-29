package may28;
public class StringtoIntegerandIntegertoString {
	public static void main(String[] args) {
		String str1 = "345";
		String str2 = "456";
		int x = Integer.parseInt(str1);
		int y = Integer.parseInt(str2);
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x%y);
		System.out.println(x/y);
		System.out.println(x*y);
		int a=100;
		int b=300;
		String st1 = String.valueOf(a);
		String st2 = String.valueOf(b);
		System.out.println(st1.concat(str2));
	}

}

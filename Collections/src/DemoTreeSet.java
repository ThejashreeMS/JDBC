import java.util.TreeSet;

public class DemoTreeSet {
public static void main(String[] args) {
	TreeSet ts=new TreeSet();
	Student s1=new Student("ABC",11);
	Student s2=new Student("ABC",39);
	Student s3=new Student("ABC",19);
	Student s4=new Student("ABC",25);
	Student s5=new Student("ABC",7);
	Student s6=new Student("ABC",31);
	ts.add(s1);
	ts.add(s2);
	ts.add(s3);
	ts.add(s4);
	ts.add(s5);
	ts.add(s6);
for (Object obj : ts) {
	System.out.println("***** "+obj+" *****");
}
}
}

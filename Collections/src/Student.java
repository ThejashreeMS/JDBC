
public class Student implements Comparable
{
String name;
int id;
Student(String name, int id)
{
	this.id=id;
	this.name=name;
}
@Override
public String toString()
{
	return this.id+" "+this.name;
}
@Override
public int compareTo(Object o)
{
	Student st=(Student)o;
	System.out.println(this.id+"-"+st.id);
	return this.id-st.id;
}
}

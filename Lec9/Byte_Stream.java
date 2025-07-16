package Lec9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Byte_Stream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student s = new Student();
		s.name = "raju";
		s.age = 17;
		String file="/Users/codingblocks/Desktop/output.txt";
		FileOutputStream f = new FileOutputStream(file);
		ObjectOutputStream o= new ObjectOutputStream(f);
		o.writeObject(s);
		FileInputStream f1 = new FileInputStream(file);
		ObjectInputStream o1 = new ObjectInputStream(f1);
		Student s1=(Student) o1.readObject();
		System.out.println(s1.hashCode());
		System.out.println(s.hashCode());
	}

}

class Student implements Serializable {
	String name;
	int age;
	
}









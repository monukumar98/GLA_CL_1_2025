package Lec9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;


public class Singleton_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Singleton s1 = new  Singleton();
//		Singleton s2 = new  Singleton();
//		Singleton s3 = new  Singleton();
//		Singleton s4 = new  Singleton();
		Singleton s1 = Singleton.getSingleton();
//		Singleton s2 = Singleton.getSingleton();
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());

		// Singleton break
//		Constructor<Singleton> singleton = Singleton.class.getDeclaredConstructor();
//		singleton.setAccessible(true);
//		Singleton s3 =singleton.newInstance();
//		System.out.println(s1.hashCode());
//		System.out.println(s3.hashCode());
		
		String file="/Users/codingblocks/Desktop/output.txt";
		FileOutputStream f = new FileOutputStream(file);
		ObjectOutputStream o= new ObjectOutputStream(f);
		o.writeObject(s1);
		FileInputStream f1 = new FileInputStream(file);
		ObjectInputStream o1 = new ObjectInputStream(f1);
		Singleton s2=(Singleton) o1.readObject();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		

	}

}








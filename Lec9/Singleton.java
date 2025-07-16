package Lec9;

import java.io.Serializable;

public class Singleton implements Serializable {
//// Eager 
//	private static Singleton s = new Singleton();
//
//	private Singleton() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static Singleton getSingleton() {
//		return s;
//	}
// Lazy

//	private static Singleton s;
//
//	private Singleton() {
//		// TODO Auto-generated constructor stub
//	}
//
//  public static Singleton getSingleton() {
//		if (s == null) {
//			s = new Singleton();
//
//		}
//		return s;
//	}

//	// synchronized
//	private static Singleton s;
//
//	private Singleton() {
//		// TODO Auto-generated constructor stub
//	}
//
//	synchronized public static Singleton getSingleton() {
//		if (s == null) {
//			s = new Singleton();
//
//		}
//		return s;
//	}

//	synchronized
	private volatile static Singleton s;

	private Singleton() throws Exception {
		// TODO Auto-generated constructor stub
		if (s != null) {
			throw new Exception("Bklol object created hai");
		}
//		getSingleton();
	}

	public static Singleton getSingleton() throws Exception {
		if (s == null) {
			synchronized (Singleton.class) {
				if (s == null) {
					s = new Singleton();
				}
			}
		}
		return s;
	}
	
	public Object readResolve() {
		
		return s;
		 
	}

	// Bill PUGH

//	private Singleton() {
//		// TODO Auto-generated constructor stub
//	}
//
//	private static class Singleton_Create {
//		private static final Singleton s = new Singleton();
//	}
//
//	public static Singleton getSingleton() {
//		return Singleton_Create.s;
//	}
}

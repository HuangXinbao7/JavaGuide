package com.xinbao.javase.chap04oop.Intermediate.polymorphism;


/*
 * 面向对象特征之三：多态性
 * 
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 *   对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 *   
 * 3. 多态的使用：虚拟方法调用
 *   有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
 *   总结：编译，看左边；运行，看右边。
 *   
 * 4.多态性的使用前提：  ① 类的继承关系  ② 方法的重写
 * 
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
 */
public class PersonTest {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.eat();
		
		Man man = new Man();
		man.eat();
		man.age = 25;
		man.earnMoney();
		
		//*************************************************
		System.out.println("*******************");
		//对象的多态性：父类的引用指向子类的对象
		Person p2 = new Man();
//		Person p3 = new Woman();
		//多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 ---虚拟方法调用
		p2.eat();
		p2.walk();
		
//		p2.earnMoney();
		
		System.out.println(p2.id);//1001
	}


	public static class Person {
		String name;
		int age;

		int id = 1001;

		public void eat(){
			System.out.println("人：吃饭");
		}

		public void walk(){
			System.out.println("人：走路");
		}
	}


	public static class Man extends Person{

		boolean isSmoking;

		int id = 1002;

		public void earnMoney(){
			System.out.println("男人负责挣钱养家");
		}

		public void eat(){
			System.out.println("男人多吃肉，长肌肉");
		}

		public void walk(){
			System.out.println("男人霸气的走路");
		}
	}


	public static class Woman extends Person{

		boolean isBeauty;

		public void goShopping(){
			System.out.println("女人喜欢购物");
		}

		public void eat(){
			System.out.println("女人少吃，为了减肥");
		}

		public void walk(){
			System.out.println("女人窈窕的走路");
		}
	}

}

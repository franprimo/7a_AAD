import org.hibernate.Session;


public class Program {

	public static void main(String[] args) {
		
		Session session = HibernateUtilities.getSessionFactory().openSession();	
		
		//Para empezar, tenemos que abrir una transaccion.
		session.beginTransaction();
		
		//CREACION DE OBJETOS
		//Creamos un par de empresas.
		Empresas emp = new Empresas();
		emp.setNombre("Ford");
		emp.setEmpleados(9000);
		emp.setDireccion("Almusafes");
		
		session.save(emp);
		
		Empresas emp2 = new Empresas();
		emp2.setNombre("Apple");
		emp2.setEmpleados(3000);
		emp2.setDireccion("Cupertino");
		
		session.save(emp2);
		
		
		//Creamos un par de pedidos.
		Pedidos p1 = new Pedidos();
		p1.setFecha("2016-01-10");
		
		session.save(p1);
		
		Pedidos p2 = new Pedidos();
		p2.setFecha("2016-01-23");
		
		session.save(p2);
		
		//Creamos un par de items.
		Items i1 = new Items();
		i1.setNombre("iphone");
		i1.setCantidad(4500);
		
		session.save(i1);
		
		Items i2 = new Items();
		i2.setNombre("Mondeo");
		i2.setCantidad(10000);
		
		session.save(i2);
		//---------------------
		
		session.getTransaction().commit();
		
		session.close();
		//HibernateUtilities.getSessionFactory().close();
		

	}

}

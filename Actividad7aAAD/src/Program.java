import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class Program {
	
	private static Session session;

	public static void main(String[] args) {
		
		session = HibernateUtilities.getSessionFactory().openSession();
		
		//Para empezar, tenemos que abrir una transaccion.
		//session.beginTransaction();
		
		introducirDatos(session);
		recuperarEmpresaPorCif(1);
		recuperarPedidoPorCifEmpresa(1);
		recuperarEmpresaPorStringDado("Yo");
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		
	
	}
	
	public static void introducirDatos(Session session){
			
		session.beginTransaction();
		
		Empresas e;
		
		e = creaEmpresa("Yoigo", 550, "Calle Mayor", "Calle mayor", "Madrid", 28020, "11-02-2016");
		e.addPedido(new Pedidos("15-02-2015"));
		session.save(e);
		
		e = creaEmpresa("Yogurteria", 50, "Hermanos Antich", "hermanos antich", "Silla", 46460, "14-02-2016");
		session.save(e);
		
		e = creaEmpresa("Seidor", 3456, "Ernesto Vilamayor", "ernesto vilamayor", "Valencia", 46046, "14-02-2016");
		session.save(e);
		
		e = creaEmpresa("Mercadona", 7654, "Aragon", "aragon", "Valencia", 46010, "05-01-2016");
		session.save(e);
		
		session.getTransaction().commit();
		
	}
	
	public static Empresas creaEmpresa(String nombre, int empleados, String calle, String calle2, String pueblo, int cp, String fecha){
		Empresas e = new Empresas();
		
		e.setNombre(nombre);
		e.setEmpleados(empleados);
		
		e.getDir().setCalle(calle2);
		e.getDir().setPoblacion(pueblo);
		e.getDir().setCp(cp);
		e.addPedido(new Pedidos(fecha));
		
		return e;
	}
	
	public static List<Empresas> recuperarEmpresaPorCif(int cif){
		
		List<Empresas> empresas = new ArrayList<Empresas>();
		
		session.beginTransaction();
		Query query = session.createQuery("from Empresas as empresas where empresas.cif='"+cif+"'");
		empresas = query.list();
		
		for(Empresas e: empresas){
			System.out.println(e.getCif()+" "+e.getNombre());
		}
		
		
		return empresas;
	}
	
	public static List<Pedidos> recuperarPedidoPorCifEmpresa(int cif){
		
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		session.beginTransaction();
		Query query = session.createQuery("from Pedidos as pedidos where pedidos.empresa.cif='"+cif+"'");
		pedidos = query.list();
		
		for(Pedidos p: pedidos){
			System.out.println(p.getId()+" "+p.getFecha()+" "+p.getEmpresa().getCif());
		}
		
		
		return pedidos;
	}
	
	public static List<Empresas> recuperarEmpresaPorStringDado(String stringInicio){
		
		List<Empresas> empresas = new ArrayList<Empresas>();
		
		session.beginTransaction();
		Query query = session.createQuery("from Empresas as empresas where empresas.nombre like '"+stringInicio+"%'");
		empresas = query.list();
		
		for(Empresas e: empresas){
			System.out.println(e.getCif()+" "+e.getNombre());
		}
		
		return empresas;
	}

}

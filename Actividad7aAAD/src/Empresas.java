import java.util.ArrayList;
import java.util.List;


public class Empresas {
	
	private int cif = 0;
	private String nombre = null;
	private int empleados = 0;
	//private String direccion = null;
	private Direccion dir;
	
	private List<Pedidos> pedidos = new ArrayList<Pedidos>();

	public Empresas(){
		setDir(new Direccion());
	}

	public int getCif() {
		return cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	/*
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	*/
	
	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
		dir.setEmpresa(this);
	}
	
	public List<Pedidos> getPedidos(){
		return pedidos;
	}
	
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedidos pedido){
		pedido.setEmpresa(this);
		this.pedidos.add(pedido);
	}

}

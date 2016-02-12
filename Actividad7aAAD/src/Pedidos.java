import java.util.Date;


public class Pedidos {

	private int id = 0;
	private String fecha = null;
	private Empresas empresa;

	public Pedidos(){
		
	}
	
	public Pedidos(String fecha){
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}
}

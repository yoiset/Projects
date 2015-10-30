package es.dgoj.rgiaj.business.beans;


public class UsuarioQueryBean  extends ComunidadQueryBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Long id;
	private String usuario;
	private String descripcion;
	
	public UsuarioQueryBean() {
		super();
	}
	
	public UsuarioQueryBean(String usuario) {
		super();
		this.usuario = usuario;
	}
	
		

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static UsuarioQueryBean toBean(es.dgoj.rgiaj.UsuarioQueryRequest request){
		UsuarioQueryBean result= new UsuarioQueryBean();
		if(request!=null){
			if(request.getIdComunidad()!=0)
			  result.setIdComunidad(request.getIdComunidad());
			result.setUsuario(request.getUsuario());
			result.setId(request.getId());
			result.setDescripcion(request.getDescripcion());
			result.setActivo(request.getActivo());
			
		}
		
		return result;
	}

	

}

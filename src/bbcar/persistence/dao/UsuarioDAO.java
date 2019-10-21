package bbcar.persistence.dao;
import java.sql.Date;

import bbcar.persistence.bean.Usuario;
import bbcar.persistence.dao.DAOException;

public interface UsuarioDAO {

	public Usuario createUsuario(String usuario, String clave, String profesion, String mail, String nombre,
			String apellidos, Date fechaNacimiento) throws DAOException;

	public Usuario findUsuarioByUsuario(String usuario) throws DAOException;

	@SuppressWarnings("rawtypes")
	public java.util.Collection findAll() throws DAOException;

	public void update(Usuario c) throws DAOException;
}

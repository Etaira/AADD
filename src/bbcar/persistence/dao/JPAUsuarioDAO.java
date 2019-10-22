package bbcar.persistence.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.Coche;
import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Reserva;
import bbcar.persistence.bean.Usuario;
import bbcar.persistence.bean.Valoracion;

public class JPAUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario createUsuario(String usuario, String clave, String profesion, String mail, String nombre,
			String apellidos, Date fechaNacimiento) throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Usuario user = new Usuario();
		user.setApellidos(apellidos);
		user.setClave(clave);
		user.setEmail(mail);
		user.setFechaNacimiento(fechaNacimiento);
		user.setNombre(nombre);
		user.setProfesion(profesion);
		user.setUsuario(usuario);
		user.setValoracionesEmitidas(new ArrayList<Valoracion>());
		user.setValoracionesRecibidas(new ArrayList<Valoracion>());
		user.setReservas(new ArrayList<Reserva>());
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public Usuario findUsuarioByUsuario(Integer usuario) throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Usuario user = em.find(Usuario.class, usuario);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public Collection findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario u) throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

}

package bbcar.persistence.dao;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.EstadoReserva;
import bbcar.persistence.bean.Reserva;
import bbcar.persistence.bean.Usuario;
import bbcar.persistence.bean.Viaje;

public class JPAReservaDAO implements ReservaDAO {

	@Override
	public Reserva createReserva(String comentario, EstadoReserva estado, Integer viaje ,Integer usuario) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Reserva reserva = new Reserva();
		reserva.setComentario(comentario);
		reserva.setEstado(estado);
		Usuario user = (Usuario) em.find(Usuario.class, usuario);
		reserva.setUsuario(user);
		Viaje travel = (Viaje) em.find(Viaje.class, viaje);
		reserva.setViaje(travel);
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();
		return reserva;
	}

	@Override
	public void update(Reserva r) throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.remove(r);
		em.persist(r);
	}

}

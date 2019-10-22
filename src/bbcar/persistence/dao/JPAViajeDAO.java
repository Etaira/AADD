package bbcar.persistence.dao;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.Coche;
import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Reserva;
import bbcar.persistence.bean.Viaje;

public class JPAViajeDAO implements ViajeDAO {

	public Viaje createViaje(Integer plazas, Double precio, Integer coche) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Viaje viaje = new Viaje();
		viaje.setNumPlazas(plazas);
		viaje.setPrecio(precio);
		viaje.setNotasViaje(new ArrayList<String>());
		viaje.setReservas(new ArrayList<Reserva>());
		Coche car = em.find(Coche.class, coche);
		viaje.setCoche(car);
		car.getViajes().add(viaje);
		em.persist(viaje);
		em.getTransaction().commit();
		em.close();
		return viaje;
	}

	@Override
	public void update(Viaje v) throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
}

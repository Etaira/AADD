package bbcar.persistence.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.Direccion;
import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Parada;
import bbcar.persistence.bean.Viaje;

public class JPAParadaDAO implements ParadaDAO {

	public Parada createParadaOrigen(Integer idViaje, String ciudad, String calle, Integer numero, Integer CP,
			Date fecha) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Parada parada = new Parada();
		parada.setCiudad(ciudad);
		parada.setFecha(fecha);
		Direccion dir = new Direccion();
		dir.setCalle(calle);
		dir.setCP(CP);
		dir.setNumero(numero);
		parada.setDireccion(dir);
		Viaje viaje = em.find(Viaje.class, idViaje);
		viaje.setOrigen(parada);
		em.persist(parada);
		em.getTransaction().commit();
		em.close();
		return parada;
	}
	
	public Parada createParadaDestino(Integer idViaje, String ciudad, String calle, Integer numero, Integer CP,
			Date fecha) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Parada parada = new Parada();
		parada.setCiudad(ciudad);
		parada.setFecha(fecha);
		Direccion dir = new Direccion();
		dir.setCalle(calle);
		dir.setCP(CP);
		dir.setNumero(numero);
		parada.setDireccion(dir);
		Viaje viaje = em.find(Viaje.class, idViaje);
		viaje.setOrigen(parada);
		em.persist(parada);
		em.getTransaction().commit();
		em.close();
		return parada;
	}
}

package bbcar.persistence.dao;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Viaje;

public class JPAViajeDAO extends ViajeDAO {

	@Override
	public Viaje createViaje(Integer plazas, Double precio) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Viaje viaje = new Viaje();
		viaje.setNumPlazas(plazas);
		viaje.setPrecio(precio);
		ArrayList<String> notas = new ArrayList<String>(Arrays.asList("Nota1", "Nota2"));
		viaje.setNotasViaje(notas);
		em.persist(viaje);
		em.getTransaction().commit();
		em.close();
		return viaje;
	}
}

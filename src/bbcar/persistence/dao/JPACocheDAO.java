package bbcar.persistence.dao;

import javax.persistence.EntityManager;

import bbcar.persistence.bean.Coche;
import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Usuario;

public class JPACocheDAO implements CocheDAO {

	@Override
	public Coche createCoche(String matricula, String modelo, int anyo, int confort, Integer propietario)
			throws DAOException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		Coche coche = new Coche();
		coche.setAnyo(anyo);
		coche.setConfort(confort);
		coche.setMatricula(matricula);
		coche.setModelo(modelo);
		Usuario user = (Usuario) em.find(Usuario.class, propietario);
		coche.setPropietario(user);
		em.persist(coche);
		em.getTransaction().commit();
		em.close();
		return coche;
	}

	@Override
	public Coche findCocheByMatricula(String matricula) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Coche c) throws DAOException {
		// TODO Auto-generated method stub

	}

}

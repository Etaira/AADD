package bbcar.persistence.dao;

import bbcar.persistence.bean.Coche;

public interface CocheDAO {

	public Coche createCoche(String matricula, String modelo, int anyo, int confort, String propietario)
			throws DAOException;

	public Coche findCocheByMatricula(String matricula) throws DAOException;

	public void update(Coche c) throws DAOException;
}

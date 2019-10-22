package bbcar.persistence.dao;

import bbcar.persistence.bean.Viaje;

public interface ViajeDAO {

	public Viaje createViaje(Integer plazas, Double precio, Integer coche);

	public void update(Viaje v) throws DAOException;;
}

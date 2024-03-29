package bbcar.persistence.dao;

import bbcar.persistence.bean.EstadoReserva;
import bbcar.persistence.bean.Reserva;

public interface ReservaDAO {

	public Reserva createReserva(String comentario, EstadoReserva estado, Integer viaje ,Integer usuario);

	public void update(Reserva r) throws DAOException;
}

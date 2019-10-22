package bbcar.persistence.dao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import bbcar.persistence.bean.EstadoReserva;
import bbcar.persistence.bean.Reserva;
import bbcar.persistence.bean.Usuario;

public interface ReservaDAO {

	public Reserva createReserva(String comentario, EstadoReserva estado, Integer viaje ,Integer usuario);

	public void update(Reserva r) throws DAOException;
}

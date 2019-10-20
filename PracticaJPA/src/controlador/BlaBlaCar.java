package controlador;

import java.util.Date;

import bbcar.persistence.bean.Parada;
import bbcar.persistence.bean.Viaje;
import bbcar.persistence.dao.DAOException;
import bbcar.persistence.dao.DAOFactoria;
import bbcar.persistence.dao.ParadaDAO;
import bbcar.persistence.dao.ViajeDAO;

public class BlaBlaCar {

	public static Integer registrarViaje(Integer plazas, Double precio) {
		try {
			ViajeDAO viajeDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getViajeDAO();
			Viaje viaje = viajeDAO.createViaje(plazas, precio);
			return viaje.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static Integer registrarParadaOrigen(Integer idViaje, String ciudad, String calle, Integer numero,
			Integer CP, Date fecha) {
		try {
			ParadaDAO paradaDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getParadaDAO();
			Parada parada = paradaDAO.createParadaOrigen(idViaje, ciudad, calle, numero, CP, fecha);
			return parada.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}

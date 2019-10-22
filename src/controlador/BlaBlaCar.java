package controlador;

import java.util.Date;

import bbcar.persistence.bean.*;
import bbcar.persistence.dao.*;

public class BlaBlaCar {

	public static Integer registrarViaje(Integer plazas, Double precio, Integer coche) {
		try {
			ViajeDAO viajeDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getViajeDAO();
			Viaje viaje = viajeDAO.createViaje(plazas, precio, coche);
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

	public static Integer registrarParadaDestino(Integer idViaje, String ciudad, String calle, Integer numero,
			Integer CP, Date fecha) {
		try {
			ParadaDAO paradaDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getParadaDAO();
			Parada parada = paradaDAO.createParadaDestino(idViaje, ciudad, calle, numero, CP, fecha);
			return parada.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static Integer registrarUsuario(String usuario, String clave, String profesion, String mail, String nombre,
			String apellidos, Date fechaNacimiento) {
		try {
			UsuarioDAO usuarioDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getUsuarioDAO();
			Usuario user = usuarioDAO.createUsuario(usuario, clave, profesion, mail, nombre, apellidos,
					fechaNacimiento);
			return user.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static Integer registrarCocheUsuario(String matricula, String modelo, int anyo, int confort,
			Integer propietario) {
		try {
			CocheDAO cocheDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getCocheDAO();
			Coche coche = cocheDAO.createCoche(matricula, modelo, anyo, confort, propietario);
			UsuarioDAO usuarioDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getUsuarioDAO();
			Usuario user = usuarioDAO.findUsuarioByUsuario(propietario);
			user.setCoche(coche);
			usuarioDAO.update(user);
			return coche.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static Integer registrarReservaUsuario(String comentario, EstadoReserva estado, Integer viaje,
			Integer usuario) {
		try {
			ReservaDAO reservaDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getReservaDAO();
			Reserva reserva = reservaDAO.createReserva(comentario, estado, viaje, usuario);
			return reserva.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static Integer registrarValoracion(String comentario, Integer puntuacion, Integer reserva,
			Integer usuarioEmisor, Integer usuarioReceptor) {
		try {
			ValoracionDAO valoracionDAO = DAOFactoria.getDAOFactoria(DAOFactoria.JPA).getValoracionDAO();
			Valoracion valoracion = valoracionDAO.createValoracion(comentario, puntuacion, reserva, usuarioEmisor,
					usuarioReceptor);
			return valoracion.getId();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;

	}
}

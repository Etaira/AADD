package bbcar.persistence.dao;

import java.util.Date;

import bbcar.persistence.bean.Parada;

public interface ParadaDAO {

	public Parada createParadaOrigen(Integer idViaje, String ciudad, String calle, Integer numero, Integer CP,
			Date fecha);

}

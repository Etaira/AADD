package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import bbcar.persistence.bean.EntityManagerHelper;
import bbcar.persistence.bean.Viaje;
import controlador.BlaBlaCar;

public class TestJPA {
	@Test
	public void testRegistroViaje() {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fecha = null;
		try {
			fecha = formatoDelTexto.parse("01/01/2020");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		Integer idViaje = BlaBlaCar.registrarViaje(3, 125.0);
		BlaBlaCar.registrarParadaOrigen(idViaje, "Murcia", "C/Mayorazgo", 25, 30001, fecha);
		EntityManager em = EntityManagerHelper.getEntityManager();
		Viaje viajeJPA = em.find(Viaje.class, idViaje);
		assertNotNull(viajeJPA);
	}
}

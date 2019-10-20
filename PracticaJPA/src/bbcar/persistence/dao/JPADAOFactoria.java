package bbcar.persistence.dao;

public class JPADAOFactoria extends DAOFactoria {
	@Override
	public ParadaDAO getParadaDAO() {
		return (ParadaDAO) new JPAParadaDAO();
	}

	@Override
	public ViajeDAO getViajeDAO() {
		return (ViajeDAO) new JPAViajeDAO();
	}
}
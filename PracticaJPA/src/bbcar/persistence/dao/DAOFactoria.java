package bbcar.persistence.dao;

public abstract class DAOFactoria {

	public final static int MYSQL = 1;
	public final static int JPA = 2;
	private static DAOFactoria unicaInstancia;

	/**
	 * Crea un tipo de factoria DAO. Solo existe el tipo TDSFactoriaDAO
	 */
	public static DAOFactoria getDAOFactoria(int jpa2) throws DAOException {
		switch (jpa2) {
		case JPA:
			try {
				return new JPADAOFactoria();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

	/* Constructor */
	protected DAOFactoria() {
	}

	/* Nuevas entidades DAO */
	public abstract ParadaDAO getParadaDAO();
	public abstract ViajeDAO getViajeDAO();

}

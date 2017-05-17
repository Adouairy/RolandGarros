package metier;

import dao.BaseDAO;
import entite.Organisateur;

public class AdminServiceImpl implements IAdminService{


	
	@Override
	public Boolean trouverOrganisateur(Organisateur orga) {
		return BaseDAO.getInstance().verifConnection(orga);
	}
	
}

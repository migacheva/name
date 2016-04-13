package ejb;

import dao.FlowDocDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.Role;
import models.DocUser;
import models.Office;

@LocalBean
@Stateless
public class AdminService {

    @EJB
    private FlowDocDAOLocal dao;

    public List<Office> getAllOffices() {
        return null;
    }

    public List<DocUser> getAllUsers() {
        return null;
    }

    public List<Role> getAllRoles() {
        return null;
    }

    public DocUser getUserById(int id) {
        return dao.getUserById(id);
    }

    public Office getOfficeById(int id) {
        return dao.getOfficeById(id);
    }

    public void createOffice(Office office) {

    }

    public void createUser(DocUser user) {

    }

    public void removeOffice(Office office) {

    }

    public void removeUser(DocUser user) {

    }

    public void updateUser(DocUser user) {

    }

    public void updateOffice(Office office) {

    }
}

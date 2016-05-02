package ejb;

import dao.FlowDocDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.DocUser;
import models.Office;
import models.Role;
import util.UsersStatistics;

@LocalBean
@Stateless
public class AdminService {

    @EJB
    private FlowDocDAOLocal dao;

    public List<Office> getAllOffices() {
        return dao.getAllOffice();
    }

    public List<DocUser> getAllUsers() {
        return dao.getAllUsers();
    }

    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }

    public DocUser getUserById(int id) {
        return dao.getUserById(id);
    }

    public Office getOfficeById(int id) {
        return dao.getOfficeById(id);
    }

    public void createOffice(Office office) {
        dao.createOffice(office);
    }

    public void createUser(DocUser user, int roleId) {
        Role role = dao.getRoleById(roleId);
        user.setRole(role);
        dao.createUser(user);
    }

    public void removeOffice(Office office) {
        dao.removeOffice(office);
    }

    public void removeUser(DocUser user) {
        dao.removeUser(user);
    }

    public void changeUserRole(DocUser user, int roleId) {
        Role role = dao.getRoleById(roleId);
        user.setRole(role);
        dao.updateUser(user);
    }

    public void changeUserOffice(DocUser user, int officeId) {
        if (user.getOffice() != null) {
            Office oldOffice = dao.getOfficeById(user.getOffice().getId());
            oldOffice.getUsers().remove(user);
        }
        Office office = dao.getOfficeById(officeId);
        office.getUsers().add(user);
        user.setOffice(office);
        dao.updateUser(user);
        dao.updateOffice(office);
    }

    public void updateOffice(Office office) {
        dao.updateOffice(office);
    }

    public UsersStatistics geUsersStatistics() {
        return dao.getUsersStatistics();
    }
    
    public long getOfficesCount() {
        return dao.getOfficesCount();
    }
}

package ejb;

import dao.FlowDocDAOLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import models.DocUser;
import models.Role;

@Stateless
public class AuthService implements AuthServiceLocal {

    @EJB
    private FlowDocDAOLocal flowDocDAO;
    @Resource
    private SessionContext sc;
    
    @Override
    public DocUser getCurrentUser() {
        return flowDocDAO.getUserByName(sc.getCallerPrincipal().getName());
    }

    @Override
    public List<Role> getAllRoles() {
        return flowDocDAO.getAllRoles();
    }
    
    @Override
    public void register(String name, String password, String roleName) {
        Role role = flowDocDAO.getRoleByName(roleName);
        DocUser user = new DocUser();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        flowDocDAO.createUser(user);
    }
}
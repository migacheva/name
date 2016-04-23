package ejb;

import java.util.List;
import javax.ejb.Local;
import models.DocUser;
import models.Role;

@Local
public interface AuthServiceLocal {
    public DocUser getCurrentUser();
    public List<Role> getAllRoles();
    public void register(String name, String password, String roleName);
}

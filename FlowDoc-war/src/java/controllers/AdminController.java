package controllers;

import ejb.AdminService;
import ejb.AuthServiceLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DocUser;
import models.Office;
import models.Role;
import util.UsersStatistics;

@Named
@SessionScoped
public class AdminController implements Serializable {

    @EJB
    private AuthServiceLocal authService;

    @EJB
    private AdminService adminService;
    
    private Office currentOffice;
    private DocUser user;
    private int roleId;
    private int officeId;


    public Office getCurrentOffice() {
        return currentOffice;
    }

    public void setCurrentOffice(Office currentOffice) {
        this.currentOffice = currentOffice;
    }

    public DocUser getUser() {
        return user;
    }

    public void setUser(DocUser user) {
        this.user = user;
    }

    public DocUser getCurrentUser() {
        return authService.getCurrentUser();
    }
    
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public List<Office> getAllOffices() {
        return adminService.getAllOffices();
    }

    public List<DocUser> getAllUsers() {
        return adminService.getAllUsers();
    }

    public List<Role> getAllRoles() {
        return adminService.getAllRoles();
    }

    public String createUser() {
        user = new DocUser();
        return "create_user";
    }

    public String createUserConfirm() {
        adminService.createUser(user, roleId);
        user = null;
        return "index";
    }

    public String createOffice() {
        currentOffice = new Office();
        return "create_office";
    }

    public String createOfficeConfirm() {
        adminService.createOffice(currentOffice);
        currentOffice = null;
        return "index";
    }

    public String changeUserRole(int id) {
        user = adminService.getUserById(id);
        roleId = user.getRole().getId();
        return "change_role";
    }

    public String changeUserRoleConfirm() {
        adminService.changeUserRole(user, roleId);
        user = null;
        return "index";
    }

    public String changeUserOffice(int id) {
        user = adminService.getUserById(id);
        if (user.getOffice() != null) {
            officeId = user.getOffice().getId();
        }
        return "change_office";
    }

    public String changeUserOfficeConfirm() {
        adminService.changeUserOffice(user, officeId);
        user = null;
        return "index";
    }

    public String updateOffice(int id) {
        currentOffice = adminService.getOfficeById(id);
        return "update_office";
    }

    public String updateOfficeConfirm() {
        adminService.updateOffice(currentOffice);
        currentOffice = null;
        return "index";
    }

    public String removeUser(int id) {
        user = adminService.getUserById(id);
        return "remove_user";
    }

    public String removeUserConfirm() {
        adminService.removeUser(user);
        user = null;
        return "index";
    }

    public String removeOffice(int id) {
        currentOffice = adminService.getOfficeById(id);
        return "remove_office";
    }

    public String removeOfficeConfirm() {
        adminService.removeOffice(currentOffice);
        currentOffice = null;
        return "index";
    }

    public UsersStatistics getUsersStatistics() {
        return adminService.geUsersStatistics();
    }

    public long getOfficesCount() {
        return adminService.getOfficesCount();
    }
}

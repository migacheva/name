package controllers;

import ejb.AdminService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DocUser;
import models.Office;
import models.Role;

@Named
@SessionScoped
public class AdminController implements Serializable {

    @EJB
    private AdminService adminService;
    private Office currentOffice;
    private DocUser currentUser;

    public Office getCurrentOffice() {
        return currentOffice;
    }

    public void setCurrentOffice(Office currentOffice) {
        this.currentOffice = currentOffice;
    }

    public DocUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(DocUser currentUser) {
        this.currentUser = currentUser;
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
        currentUser = new DocUser();
        return "create_user";
    }

    public String createUserConfirm() {
        adminService.createUser(currentUser);
        currentUser = null;
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

    public String updateUser(int id) {
        currentUser = adminService.getUserById(id);
        return "update_user";
    }

    public String updateUserConfirm() {
        adminService.updateUser(currentUser);
        currentUser = null;
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
        currentUser = adminService.getUserById(id);
        return "remove_user";
    }

    public String removeUserConfirm() {
        adminService.removeUser(currentUser);
        currentUser = null;
        return "index";
    }

    public String removeOffice(int id) {
        currentOffice = adminService.getOfficeById(id);
        return "create_user";
    }

    public String removeOfficeConfirm() {
        adminService.removeOffice(currentOffice);
        currentOffice = null;
        return "index";
    }
}
package controllers;

import ejb.AuthServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.DocUser;
import models.Role;
import models.UserData;

@Named
@RequestScoped
public class AuthController {

    @EJB
    private AuthServiceLocal authService;
    private UserData userData;

    public AuthController() {
        userData = new UserData();
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Role> getAllRoles() {
        return authService.getAllRoles();
    }

    public String login(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.login(userData.getName(), userData.getPassword());
            DocUser user = authService.getCurrentUser();
            switch (user.getRole().getName()) {
                case "Администратор":
                    return "admin";
                case "Утверждающий":
                    return "approver";
                case "Пользователь":
                    return "plankton";
                default:
                    return "login";
            }
        } catch (Exception e) {
            return "login";
        }
    }

    public String logout() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.invalidate();
            request.logout();
            return "logout";
        } catch (Exception e) {
            return "index";
        }
    }

    public String register() {
        try {
            authService.register(userData.getName(), userData.getPassword(), userData.getRoleName());
            return "login";
        } catch (Exception e) {
            return "register";
        }
    }
}

package controllers;

import ejb.ApproverService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DocUser;
import models.Document;

@Named
@SessionScoped
public class ApproverController implements Serializable{

    @EJB
    private ApproverService approverService;
    private DocUser currentUser;
    private Document currentDocument;

    @PostConstruct
    private void onCreate() {
        currentUser = new DocUser();
    }
    
    public DocUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(DocUser currentUser) {
        this.currentUser = currentUser;
    }

    public Document getCurrentDocument() {
        return currentDocument;
    }

    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
    }

    public List<Document> getDocumets() {
        return approverService.getDocumetsByApprover(currentUser);
    }
    
    public String showDocument(int id) {
        currentDocument = approverService.getDocumetsByApprover(currentUser).get(0);
        return "show";
    }

    public void approve(int id) {
        approverService.approve(id);
    }

    public void reject(int id) {
        approverService.reject(id);
    }
    
    
    
}

package controllers;

import ejb.AuthServiceLocal;
import ejb.PlanktonService;
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
public class PlanktonController implements Serializable {

    @EJB
    private AuthServiceLocal authService;

    @EJB
    private PlanktonService planktonService;
    
    private DocUser currentUser;
    private Document currentDocument;
    private int chosenApproverId;

    @PostConstruct
    private void onCreate() {
        currentUser = authService.getCurrentUser();
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

    public int getChosenApproverId() {
        return chosenApproverId;
    }

    public void setChosenApproverId(int chosenApproverId) {
        this.chosenApproverId = chosenApproverId;
    }
    
    public List<Document> getDocuments() {
        return planktonService.getDocumentsByAuthor(currentUser.getId());
    }

    public List<DocUser> getAllApprovers() {
        return planktonService.getAllApprovers();
    }
    
    public String showDocument(int id) {
        currentDocument = planktonService.getDocumentById(id);
        return "show";
    }
    
    //Создание нового экземпляра документа и переадресация на страницу заполнения данных
    public String createDocument() {
        this.currentDocument = new Document();
        currentDocument.setAuthor(currentUser);
        return "create";
    }

    //Запись созданного документа в базу данных
    public String createDocumentConfirm() {
        planktonService.createDocument(currentDocument);
        this.currentDocument = null;
        return "index";
    }

    public String upateDocument(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "update";
    }

    public String upateDocumentConfirm() {
        planktonService.upateDocument(currentDocument);
        this.currentDocument = null;
        return "index";
    }
    
    public String setApprover(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "set_approver";
    }
    
    public String setApproverConfirm() {
        planktonService.setApprover(currentDocument, chosenApproverId);
        return "index";
    }

    public String removeDocument(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "remove";
    }

    public String removeDocumentConfirm() {
        planktonService.removeDocument(currentDocument);
        this.currentDocument = null;
        return "index";
    }
}

package controllers;

import ejb.AuthServiceLocal;
import ejb.PlanktonService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DocUser;
import models.Document;
import util.UserDocumentsStatistics;

@Named
@SessionScoped
public class PlanktonController implements Serializable {

    @EJB
    private AuthServiceLocal authService;

    @EJB
    private PlanktonService planktonService;

    private Document currentDocument;
    private List<Document> documents;
    private int chosenApproverId;
    private String searchText;

    public DocUser getCurrentUser() {
        return authService.getCurrentUser();
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

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Document> getDocuments() {
        if (documents == null) {
            loadDocumetns();
        }
        return documents;
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
        currentDocument.setAuthor(authService.getCurrentUser());
        return "create";
    }

    //Запись созданного документа в базу данных
    public String createDocumentConfirm() {
        planktonService.createDocument(currentDocument);
        this.currentDocument = null;
        loadDocumetns();
        return "index";
    }

    public String upateDocument(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "update";
    }

    public String upateDocumentConfirm() {
        planktonService.upateDocument(currentDocument);
        this.currentDocument = null;
        loadDocumetns();
        return "index";
    }

    public String setApprover(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "set_approver";
    }

    public String setApproverConfirm() {
        planktonService.setApprover(currentDocument, chosenApproverId);
        loadDocumetns();
        return "index";
    }

    public String removeDocument(int id) {
        this.currentDocument = planktonService.getDocumentById(id);
        return "remove";
    }

    public String removeDocumentConfirm() {
        planktonService.removeDocument(currentDocument);
        this.currentDocument = null;
        loadDocumetns();
        return "index";
    }

    public UserDocumentsStatistics getStatistics() {
        return planktonService.getStatisticsByUser(authService.getCurrentUser().getId());
    }

    public List<String> completeDocumentName(String searchText) {
        return planktonService.getDocumentsNamesByAuthor(authService.getCurrentUser().getId(), searchText);
    }
    
    public void searchDocuments() {
        documents = planktonService.searchDocumentsByAuthor(authService.getCurrentUser().getId(), searchText);
    }

    private void loadDocumetns() {
        documents = planktonService.getDocumentsByAuthor(authService.getCurrentUser().getId());
    }
}

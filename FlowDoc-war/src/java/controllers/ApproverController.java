package controllers;

import ejb.ApproverService;
import ejb.AuthServiceLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DocUser;
import models.Document;
import util.OfficeDocumentsStatistics;

@Named
@SessionScoped
public class ApproverController implements Serializable {

    @EJB
    private AuthServiceLocal authService;

    @EJB
    private ApproverService approverService;

    private Document currentDocument;
    private List<Document> documents;

    public DocUser getCurrentUser() {
        return authService.getCurrentUser();
    }

    public Document getCurrentDocument() {
        return currentDocument;
    }

    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
    }

    public List<Document> getDocumets() {
        if (documents == null) {
            loadDocuments();
        }
        return documents;
    }

    public String showDocument(int id) {
        currentDocument = approverService.getDocumentById(id);
        return "show";
    }

    public void approve(int id) {
        approverService.approve(id);
        loadDocuments();
    }

    public void reject(int id) {
        approverService.reject(id);
        loadDocuments();
    }

    public List<OfficeDocumentsStatistics> getAproverDocumentsStatistics() {
        return approverService.getAproverDocumentsStatisticsByAproverId(authService.getCurrentUser().getId()).getOfficeDocumentsStatistics();
    }

    private void loadDocuments() {
        documents = approverService.getDocumetsByApprover(authService.getCurrentUser().getId());
    }
}

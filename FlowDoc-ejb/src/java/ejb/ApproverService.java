package ejb;

import dao.FlowDocDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.DocUser;
import models.Document;
import models.DocumentStatus;
import util.AproverDocumentsStatistics;

@Stateless
@LocalBean
public class ApproverService {

    @EJB
    private FlowDocDAOLocal dao;

    public DocUser getUserById(int id) {
        return dao.getUserById(id);
    }
    
    public List<Document> getDocumetsByApprover(int id) {
        return dao.getDocumentsByApprover(id);
    }

    public Document getDocumentById(int id) {
        return dao.getDocumentById(id);
    }
    
    public void approve(int id) {
        changeDocumentStatus(id, "Подтвержден");
    }
    
    public void reject(int id) {
        changeDocumentStatus(id, "Отклонен");
    }
    
    private void changeDocumentStatus(int id, String statusName) {
        Document document = dao.getDocumentById(id);
        DocumentStatus status = dao.getDocumentStatusByName(statusName);
        document.setStatus(status);
        dao.updateDocument(document);
    }

    public AproverDocumentsStatistics getAproverDocumentsStatisticsByAproverId(int id) {
        return dao.getAproverDocumentsStatisticsByAproverId(id);
    }
}

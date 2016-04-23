package ejb;

import dao.FlowDocDAOLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.DocUser;
import models.Document;
import models.DocumentHistory;
import models.DocumentStatus;
import util.DocStatistics;

@Stateless
@LocalBean
public class PlanktonService {

    @EJB
    private FlowDocDAOLocal dao;

    public DocUser getUserById(int id) {
        return dao.getUserById(id);
    }

    public List<Document> getDocumentsByAuthor(int id) {
        return dao.getDocumentsByAuthor(id);
    }

    public Document getDocumentById(int id) {
        return dao.getDocumentById(id);
    }

    public List<DocUser> getAllApprovers() {
        return dao.getAllApprovers();
    }

    public void createDocument(Document document) {
        document.setCreateDate(new Date());
        document.setStatus(dao.getDocumentStatusByName("Создан"));
        dao.createDocument(document);
    }

    public void upateDocument(Document document) {
        DocumentHistory history = new DocumentHistory();
        history.setEditDate(new Date());
        document.getHistorys().add(history);
        DocumentStatus status = dao.getDocumentStatusByName(document.getApprover() == null ? "Создан" : "На утверждении");
        document.setStatus(status);
        dao.updateDocument(document);
    }

    public void removeDocument(Document document) {
        dao.removeDocument(document);
    }

    public void setApprover(Document document, int idApprover) {
        DocUser approver = dao.getUserById(idApprover);
        document.setApprover(approver);
        DocumentStatus status = dao.getDocumentStatusByName("На утверждении");
        document.setStatus(status);
        dao.updateDocument(document);
    }

    public DocStatistics getStatisticsByUser(int id) {
        return dao.getStatisticsByUser(id);
    }
}

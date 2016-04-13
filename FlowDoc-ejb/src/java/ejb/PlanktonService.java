package ejb;

import dao.FlowDocDAOLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import models.DocUser;
import models.Document;
import models.DocumentStatus;

@Stateless
@LocalBean
public class PlanktonService {

    @EJB
    private FlowDocDAOLocal dao;

    public List<Document> getDocumentsByAuthor(DocUser author) {
        author = new DocUser();
        author.setName("Аня");
        DocumentStatus status = new DocumentStatus();
        status.setName("");
        Document d = new Document();
        d.setName("Поиходная накладная");
        d.setContent("Пельмешки 10 шутк, вах");
        d.setHistorys(new ArrayList<>());
        d.setAuthor(author);
        d.setCreateDate(new Date());
        d.setStatus(status);
        List<Document> docs = new ArrayList<>();
        docs.add(d);
        return docs;
    }

    public Document getDocumentById(int id, DocUser author) {
        return getDocumentsByAuthor(author).get(0);
    }

    public List<DocUser> getAllApprovers() {
        return dao.getAllApprovers();
    }

    public void createDocument(Document document) {

    }

    public void upateDocument(Document document) {

    }

    public void removeDocument(Document document) {

    }

    public void setApprover(Document document, int idApprover) {

    }
}

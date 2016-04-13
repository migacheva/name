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
public class ApproverService {

    @EJB
    private FlowDocDAOLocal dao;
    
    public List<Document> getDocumetsByApprover(DocUser approver) {
        DocUser author = new DocUser();
        author.setName("Аня");
        DocumentStatus status = new DocumentStatus();
        status.setName("На утверждении");
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
    
    public void approve(int id) {
        
    }
    
    public void reject(int id) {
        
    }
}

package dao;

import java.util.List;
import javax.ejb.Local;
import models.DocUser;
import models.Document;
import models.Office;
import models.Role;

@Local
public interface FlowDocDAOLocal {
    List<DocUser> getAllUsers();
    List<DocUser> getAllApprovers();
    List<Role> getAllRoles();
    DocUser getUserById(int id);
    void createUser(DocUser user);
    void updateUser(DocUser user);
    void removeUser(DocUser user);
    
    List<Office> getAllOffice();
    Office getOfficeById(int id);
    void createOffice(Office office);
    void updateOffice(Office office);
    void removeOffice(Office office);
    
    List<Document> getAllDocuments();
    Document getDocumentById(int id);
    void createDocument(Document document);
    void updateDocument(Document document);
    void removeDocument(Document document);
}

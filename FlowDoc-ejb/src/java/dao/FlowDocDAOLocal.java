package dao;

import java.util.List;
import javax.ejb.Local;
import models.DocUser;
import models.Document;
import models.DocumentStatus;
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
    Role getRoleById(int id);
    
    List<Office> getAllOffice();
    Office getOfficeById(int id);
    void createOffice(Office office);
    void updateOffice(Office office);
    void removeOffice(Office office);
    
    List<Document> getDocumentsByAuthor(int id);
    List<Document> getDocumentsByApprover(int id);
    Document getDocumentById(int id);
    void createDocument(Document document);
    void updateDocument(Document document);
    void removeDocument(Document document);
    DocumentStatus getDocumentStatusByName(String name);
}

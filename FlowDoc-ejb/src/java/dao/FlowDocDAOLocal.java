package dao;

import java.util.List;
import javax.ejb.Local;
import models.DocUser;
import models.Document;
import models.DocumentStatus;
import models.Office;
import models.Role;
import util.AproverDocumentsStatistics;
import util.UserDocumentsStatistics;
import util.UsersStatistics;

@Local
public interface FlowDocDAOLocal {
    List<DocUser> getAllUsers();
    List<DocUser> getAllApprovers();
    List<Role> getAllRoles();
    DocUser getUserById(int id);
    DocUser getUserByName(String name);
    void createUser(DocUser user);
    void updateUser(DocUser user);
    void removeUser(DocUser user);
    Role getRoleById(int id);
    Role getRoleByName(String name);
    
    List<Office> getAllOffice();
    Office getOfficeById(int id);
    void createOffice(Office office);
    void updateOffice(Office office);
    void removeOffice(Office office);
    
    List<Document> getDocumentsByAuthor(int id);
    List<String> getDocumentsNamesByAuthor(int id, String searchText);
    List<Document> searchDocumentsByAuthor(int id, String searchText);
    List<Document> getDocumentsByApprover(int id);
    Document getDocumentById(int id);
    void createDocument(Document document);
    void updateDocument(Document document);
    void removeDocument(Document document);
    DocumentStatus getDocumentStatusByName(String name);
    
    UserDocumentsStatistics getStatisticsByUser(int id);
    UsersStatistics getUsersStatistics();
    long getOfficesCount();
    AproverDocumentsStatistics getAproverDocumentsStatisticsByAproverId(int id);
}
package dao;

import java.util.List;
import javax.ejb.Stateless;
import models.DocUser;
import models.Document;
import models.Office;
import models.Role;

@Stateless
public class FlowDocDAO implements FlowDocDAOLocal {

    @Override
    public List<Office> getAllOffice() {
        return null;
    }

    @Override
    public Office getOfficeById(int id) {
        return null;
    }

    @Override
    public Office createOffice(Office office) {
        return null;
    }

    @Override
    public void updateOffice(Office office) {
    }

    @Override
    public void removeOffice(Office office) {
    }

    @Override
    public List<DocUser> getAllDocUsers() {
        return null;
    }

    @Override
    public DocUser getDocUserById(int id) {
        return null;
    }

    @Override
    public DocUser createDocUser(DocUser user) {
        return null;
    }

    @Override
    public void updateDocUser(DocUser user) {
    }

    @Override
    public void removeDocUser(DocUser user) {
    }

    @Override
    public List<Document> getAllDocuments() {
        return null;
    }

    @Override
    public Document getDocumentById(int id) {
        return null;
    }

    @Override
    public Document createDocument(Document document) {
        return null;
    }

    @Override
    public void updateDocument(Document document) {
    }

    @Override
    public void removeDocument(Document document) {
    }

    @Override
    public List<DocUser> getAllUsers() {
        return null;
    }

    @Override
    public DocUser getUserById(int id) {
        return null;
    }

    @Override
    public DocUser createUser(DocUser user) {
        return null;
    }

    @Override
    public void updateUser(DocUser user) {
    }

    @Override
    public void removeUser(DocUser user) {
    }

    @Override
    public List<DocUser> getAllApprovers() {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }
}
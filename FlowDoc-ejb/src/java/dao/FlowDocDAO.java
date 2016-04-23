package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.DocUser;
import models.Document;
import models.DocumentStatus;
import models.Office;
import models.Role;

@Stateless
public class FlowDocDAO implements FlowDocDAOLocal {
    
    @PersistenceContext(unitName = "FlowDoc-ejbPU")
    private EntityManager em;

    @Override
    public List<DocUser> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM DocUser u", DocUser.class);
        return query.getResultList();
    }

    @Override
    public List<DocUser> getAllApprovers() {
        Query query = em.createQuery("SELECT a FROM DocUser a WHERE a.role.name='Утверждающий'", DocUser.class);
        return query.getResultList();
    }

    @Override
    public List<Role> getAllRoles() {
        Query query = em.createQuery("SELECT r FROM Role r", Role.class);
        return query.getResultList();
    }

    @Override
    public DocUser getUserById(int id) {
        return em.find(DocUser.class, id);
    }

    @Override
    public DocUser getUserByName(String name) {
        try {
            Query query = em.createQuery("SELECT u FROM DocUser u WHERE u.name=?1", DocUser.class);
            query.setParameter(1, name);
            return (DocUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void createUser(DocUser user) {
        em.persist(user);
    }

    @Override
    public void updateUser(DocUser user) {
        em.merge(user);
    }

    @Override
    public void removeUser(DocUser user) {
        em.remove(em.merge(user));
    }

    @Override
    public Role getRoleById(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.name=?1", Role.class);
        query.setParameter(1, name);
        return (Role) query.getSingleResult();
    }
    
    @Override
    public List<Office> getAllOffice() {
        Query query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getOfficeById(int id) {
        return em.find(Office.class, id);
    }

    @Override
    public void createOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }

    @Override
    public void removeOffice(Office office) {
        em.remove(em.merge(office));
    }

    @Override
    public List<Document> getDocumentsByAuthor(int id) {
        Query query = em.createQuery("SELECT d FROM Document d WHERE d.author.id=?1", Document.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public List<Document> getDocumentsByApprover(int id) {
        Query query = em.createQuery("SELECT d FROM Document d WHERE d.approver.id=?1", Document.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public Document getDocumentById(int id) {
        return em.find(Document.class, id);
    }

    @Override
    public void createDocument(Document document) {
        em.persist(document);
    }

    @Override
    public void updateDocument(Document document) {
        em.merge(document);
    }

    @Override
    public void removeDocument(Document document) {
        em.remove(em.merge(document));
    }

    @Override
    public DocumentStatus getDocumentStatusByName(String name) {
        Query query = em.createQuery("SELECT s FROM DocumentStatus s WHERE s.name=?1", DocumentStatus.class);
        query.setParameter(1, name);
        return (DocumentStatus) query.getSingleResult();
    }
}
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "documents")
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String content;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @ManyToOne
    private DocumentStatus status;
    @ManyToOne
    private DocUser author;
    @ManyToOne
    private DocUser approver;
    @OneToMany
    private List<DocumentHistory> historys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public DocUser getAuthor() {
        return author;
    }

    public void setAuthor(DocUser author) {
        this.author = author;
    }

    public DocUser getApprover() {
        return approver;
    }

    public void setApprover(DocUser approver) {
        this.approver = approver;
    }

    public List<DocumentHistory> getHistorys() {
        return historys;
    }

    public void setHistorys(List<DocumentHistory> historys) {
        this.historys = historys;
    }
}

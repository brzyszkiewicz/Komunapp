/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.flatmates.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "thread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thread.findAll", query = "SELECT t FROM Thread t")})
public class Thread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "thread_generator")
    @SequenceGenerator(name="thread_generator", sequenceName = "thread_seq", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "threadid")
    private Integer threadid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "title")
    private String title;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdby")
    private int createdby;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "threadid")
    private Collection<Comment> commentCollection;
    @JoinColumn(name = "flatid", referencedColumnName = "flatid")
    @ManyToOne(optional = false)
    private Flat flatid;

    public Thread() {
    }

    public Thread(Integer threadid) {
        this.threadid = threadid;
    }

    public Thread(Integer threadid, String title, int createdby) {
        this.threadid = threadid;
        this.title = title;
        this.createdby = createdby;
    }

    public Integer getThreadid() {
        return threadid;
    }

    public void setThreadid(Integer threadid) {
        this.threadid = threadid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Flat getFlatid() {
        return flatid;
    }

    public void setFlatid(Flat flatid) {
        this.flatid = flatid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (threadid != null ? threadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thread)) {
            return false;
        }
        Thread other = (Thread) object;
        if ((this.threadid == null && other.threadid != null) || (this.threadid != null && !this.threadid.equals(other.threadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Thread[ threadid=" + threadid + " ]";
    }
    
}

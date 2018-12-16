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
@Table(name = "flat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flat.findAll", query = "SELECT f FROM Flat f")})
public class Flat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "flat_generator")
    @SequenceGenerator(name="flat_generator", sequenceName = "flat_seq", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "flatid")
    private Integer flatid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "flatname")
    private String flatname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "flatpasshash")
    private String flatpasshash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdby")
    private int createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flatid")
    private Collection<Task> taskCollection;
    @OneToMany(mappedBy = "flatid")
    private Collection<Shoppinglist> shoppinglistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flatid")
    private Collection<Thread> threadCollection;
    @OneToMany(mappedBy = "flatid")
    private Collection<User> userCollection;

    public Flat() {
    }

    public Flat(Integer flatid) {
        this.flatid = flatid;
    }

    public Flat(Integer flatid, String flatname, String flatpasshash, int createdby, Date createdate) {
        this.flatid = flatid;
        this.flatname = flatname;
        this.flatpasshash = flatpasshash;
        this.createdby = createdby;
        this.createdate = createdate;
    }

    public Integer getFlatid() {
        return flatid;
    }

    public void setFlatid(Integer flatid) {
        this.flatid = flatid;
    }

    public String getFlatname() {
        return flatname;
    }

    public void setFlatname(String flatname) {
        this.flatname = flatname;
    }

    public String getFlatpasshash() {
        return flatpasshash;
    }

    public void setFlatpasshash(String flatpasshash) {
        this.flatpasshash = flatpasshash;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    @XmlTransient
    public Collection<Shoppinglist> getShoppinglistCollection() {
        return shoppinglistCollection;
    }

    public void setShoppinglistCollection(Collection<Shoppinglist> shoppinglistCollection) {
        this.shoppinglistCollection = shoppinglistCollection;
    }

    @XmlTransient
    public Collection<Thread> getThreadCollection() {
        return threadCollection;
    }

    public void setThreadCollection(Collection<Thread> threadCollection) {
        this.threadCollection = threadCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flatid != null ? flatid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flat)) {
            return false;
        }
        Flat other = (Flat) object;
        if ((this.flatid == null && other.flatid != null) || (this.flatid != null && !this.flatid.equals(other.flatid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flat[ flatid=" + flatid + " ]";
    }
    
}

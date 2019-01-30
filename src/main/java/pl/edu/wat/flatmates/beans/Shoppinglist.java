/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.flatmates.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "shoppinglist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppinglist.findAll", query = "SELECT s FROM Shoppinglist s")})
public class Shoppinglist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "slist_generator")
    @SequenceGenerator(name="slist_generator", sequenceName = "slist_seq", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "shoppinglistid")
    private Integer shoppinglistid;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @JoinColumn(name = "flatid", referencedColumnName = "flatid")
    @ManyToOne
    @JsonIgnore
    private Flat flatid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppinglistid")
    @JsonIgnore
    private Collection<Shoppingitem> shoppingitemCollection;

    public Shoppinglist() {
    }

    public Shoppinglist(Integer shoppinglistid) {
        this.shoppinglistid = shoppinglistid;
    }

    public Shoppinglist(Integer shoppinglistid, Date createdate) {
        this.shoppinglistid = shoppinglistid;
        this.createdate = createdate;
    }

    public Integer getShoppinglistid() {
        return shoppinglistid;
    }

    public void setShoppinglistid(Integer shoppinglistid) {
        this.shoppinglistid = shoppinglistid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Flat getFlatid() {
        return flatid;
    }

    public void setFlatid(Flat flatid) {
        this.flatid = flatid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Shoppingitem> getShoppingitemCollection() {
        return shoppingitemCollection;
    }

    public void setShoppingitemCollection(Collection<Shoppingitem> shoppingitemCollection) {
        this.shoppingitemCollection = shoppingitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppinglistid != null ? shoppinglistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppinglist)) {
            return false;
        }
        Shoppinglist other = (Shoppinglist) object;
        if ((this.shoppinglistid == null && other.shoppinglistid != null) || (this.shoppinglistid != null && !this.shoppinglistid.equals(other.shoppinglistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shoppinglist[ shoppinglistid=" + shoppinglistid + " ]";
    }
    
}

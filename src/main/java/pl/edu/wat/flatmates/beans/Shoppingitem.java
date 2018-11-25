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
import java.io.Serializable;


@Entity
@Table(name = "shoppingitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingitem.findAll", query = "SELECT s FROM Shoppingitem s")})
public class Shoppingitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shoppingitemid")
    private Integer shoppingitemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "shoppinglistid", referencedColumnName = "shoppinglistid")
    @ManyToOne(optional = false)
    private Shoppinglist shoppinglistid;

    public Shoppingitem() {
    }

    public Shoppingitem(Integer shoppingitemid) {
        this.shoppingitemid = shoppingitemid;
    }

    public Shoppingitem(Integer shoppingitemid, String description, double price) {
        this.shoppingitemid = shoppingitemid;
        this.description = description;
        this.price = price;
    }

    public Integer getShoppingitemid() {
        return shoppingitemid;
    }

    public void setShoppingitemid(Integer shoppingitemid) {
        this.shoppingitemid = shoppingitemid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shoppinglist getShoppinglistid() {
        return shoppinglistid;
    }

    public void setShoppinglistid(Shoppinglist shoppinglistid) {
        this.shoppinglistid = shoppinglistid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingitemid != null ? shoppingitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingitem)) {
            return false;
        }
        Shoppingitem other = (Shoppingitem) object;
        if ((this.shoppingitemid == null && other.shoppingitemid != null) || (this.shoppingitemid != null && !this.shoppingitemid.equals(other.shoppingitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shoppingitem[ shoppingitemid=" + shoppingitemid + " ]";
    }
    
}

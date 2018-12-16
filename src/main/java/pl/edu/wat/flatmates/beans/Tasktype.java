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


@Entity
@Table(name = "tasktype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasktype.findAll", query = "SELECT t FROM Tasktype t")})
public class Tasktype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "tasktype_generator")
    @SequenceGenerator(name="tasktype_generator", sequenceName = "tasktype_seq", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasktypeid")
    private Integer tasktypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tasktype")
    private String tasktype;
    @OneToMany(mappedBy = "tasktypeid")
    private Collection<Task> taskCollection;

    public Tasktype() {
    }

    public Tasktype(Integer tasktypeid) {
        this.tasktypeid = tasktypeid;
    }

    public Tasktype(Integer tasktypeid, String tasktype) {
        this.tasktypeid = tasktypeid;
        this.tasktype = tasktype;
    }

    public Integer getTasktypeid() {
        return tasktypeid;
    }

    public void setTasktypeid(Integer tasktypeid) {
        this.tasktypeid = tasktypeid;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tasktypeid != null ? tasktypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasktype)) {
            return false;
        }
        Tasktype other = (Tasktype) object;
        if ((this.tasktypeid == null && other.tasktypeid != null) || (this.tasktypeid != null && !this.tasktypeid.equals(other.tasktypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tasktype[ tasktypeid=" + tasktypeid + " ]";
    }
    
}

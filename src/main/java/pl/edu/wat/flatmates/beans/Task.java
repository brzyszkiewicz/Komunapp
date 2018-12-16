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
import java.util.Date;


@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "task_generator")
    @SequenceGenerator(name="task_generator", sequenceName = "task_seq", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "taskid")
    private Integer taskid;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duetime")
    @Temporal(TemporalType.DATE)
    private Date duetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignee")
    private int assignee;
    @Column(name = "confirmedby")
    private Integer confirmedby;
    @Column(name = "rejectedby")
    private Integer rejectedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdone")
    private boolean isdone;
    @JoinColumn(name = "flatid", referencedColumnName = "flatid")
    @ManyToOne(optional = false)
    private Flat flatid;
    @JoinColumn(name = "tasktypeid", referencedColumnName = "tasktypeid")
    @ManyToOne
    private Tasktype tasktypeid;

    public Task() {
    }

    public Task(Integer taskid) {
        this.taskid = taskid;
    }

    public Task(Integer taskid, Date duetime, int assignee, boolean isdone) {
        this.taskid = taskid;
        this.duetime = duetime;
        this.assignee = assignee;
        this.isdone = isdone;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuetime() {
        return duetime;
    }

    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public Integer getConfirmedby() {
        return confirmedby;
    }

    public void setConfirmedby(Integer confirmedby) {
        this.confirmedby = confirmedby;
    }

    public Integer getRejectedby() {
        return rejectedby;
    }

    public void setRejectedby(Integer rejectedby) {
        this.rejectedby = rejectedby;
    }

    public boolean getIsdone() {
        return isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }

    public Flat getFlatid() {
        return flatid;
    }

    public void setFlatid(Flat flatid) {
        this.flatid = flatid;
    }

    public Tasktype getTasktypeid() {
        return tasktypeid;
    }

    public void setTasktypeid(Tasktype tasktypeid) {
        this.tasktypeid = tasktypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskid != null ? taskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskid == null && other.taskid != null) || (this.taskid != null && !this.taskid.equals(other.taskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task[ taskid=" + taskid + " ]";
    }
    
}

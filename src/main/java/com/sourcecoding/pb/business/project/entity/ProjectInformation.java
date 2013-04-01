/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sourcecoding.pb.business.project.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Matthias
 */
@Entity
@NamedQueries({
    @NamedQuery(name = ProjectInformation.findByKey, query = "SELECT pi FROM ProjectInformation pi WHERE pi.projectKey= :"+ ProjectInformation.findByKey_Param_Key),
})
public class ProjectInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String findByKey = "ProjectInformation#findByKey";
    public static final String findByKey_Param_Key = "key";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projectKey;
    private String name;
    @OneToMany(mappedBy = "projectInformation")
    private Set<WorkPackage> workPackages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }


    public Set<WorkPackage> getWorkPackages() {
        return workPackages;
    }

    public void setWorkPackages(Set<WorkPackage> workPackages) {
        this.workPackages = workPackages;
    }
}
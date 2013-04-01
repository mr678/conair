/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sourcecoding.pb.business.project.boundary;

import com.sourcecoding.pb.business.project.entity.ProjectInformation;
import com.sourcecoding.pb.business.project.entity.WorkPackage;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Matthias
 */
@Path("projects")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectServices {

    @PersistenceContext
    EntityManager em;

    @PUT
    @Path("{key}")
    public ProjectInformation createOrUpdate(@PathParam("key") String key, ProjectInformation pi) {

        for (WorkPackage wp : pi.getWorkPackages())
            wp.setProjectInformation(pi);
        pi = em.merge(pi);

        return pi;
    }

    @GET
    @Path("{key}")
    public ProjectInformation getProject(@PathParam("key") String key) {
        return em.createNamedQuery(ProjectInformation.findByKey, ProjectInformation.class)
                .setParameter(ProjectInformation.findByKey_Param_Key, key)
                .getSingleResult();
    }

    @GET
    @Path("/dummy")
    public ProjectInformation getProject() {
        ProjectInformation pi = new ProjectInformation();

        pi.setProjectKey("E221");
        pi.setName("Direkt Line Deutschland");

        Set<WorkPackage> s = new HashSet<>();
        pi.setWorkPackages(s);
        WorkPackage wp = new WorkPackage();
        wp.setProjectInformation(pi);
        wp.setWpName("Analyse");
        s.add(wp);

        wp = new WorkPackage();
        wp.setWpName("Entwicklung");
        wp.setProjectInformation(pi);
        s.add(wp);
        
        return pi;

    }
}
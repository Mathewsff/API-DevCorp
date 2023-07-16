/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import static com.sun.mail.imap.Rights.Right.POST;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Nowll
 */
@Path("Espaco")
public class EspacoResource {

    @Context
    private UriInfo context;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("consultaEspaco")
    public Espaco consultaEspaco(long id){
        EspacoDAO edao = new EspacoDAO();
        return edao.consultaEspaco(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("cadastroEspaco")
    public void cadastroEspaco(Espaco e){
        EspacoDAO edao = new EspacoDAO();
        edao.cadastroEspaco(e);
    }
    
    
    @DELETE
    @Path("removeEspaco/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeEspaco(@PathParam("id") long id){
        EspacoDAO edao = new EspacoDAO();
        edao.removeEspaco(id);
    }
    
   
    @PUT 
    @Path("editEspaco/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void editEspaco(@PathParam("id") long id){
        EspacoDAO edao = new EspacoDAO();
        edao.editEspaco(edao.consultaEspaco(id));
    }
    /**
     * Creates a new instance of EspacoResource
     */
    public EspacoResource() {
    }

    /**
     * Retrieves representation of an instance of JPA.EspacoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EspacoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}

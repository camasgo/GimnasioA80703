/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.gimnasioa80703.application.action;

import cr.ac.ucr.gimnasioa80703.business.ClienteBusiness;
import cr.ac.ucr.gimnasioa80703.dominio.Cliente;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Asocia2
 */
public class InsertarRutinaAction extends DispatchAction {

    /*
     * forward name="success" path=""
     */
    private final static String SUCCESS = "success";
    LinkedList<Cliente> clientes;

    
    
    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ClienteBusiness clienteBus = new ClienteBusiness();
        clientes = clienteBus.getClientes();
        request.setAttribute("clientes", this.clientes);


        return mapping.getInputForward();//
    }

    /**
     * This is the Struts action method called on http://.../actionPath?method=myAction2, where
     * "method" is the value specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward myAction2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(SUCCESS);
    }
}

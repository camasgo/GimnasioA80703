/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.gimnasioa80703.application.action;

import cr.ac.ucr.gimnasioa80703.application.form.ClienteForm;
import cr.ac.ucr.gimnasioa80703.business.ClienteBusiness;
import cr.ac.ucr.gimnasioa80703.dominio.Cliente;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Carlos
 */
public class EditarClienteAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String ERROR = "error";
    private Cliente cliente;

    /**
     * This is the Struts action method called on http://.../actionPath?method=myAction1, where
     * "method" is the value specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClienteBusiness clienteBus = new ClienteBusiness();
        cliente = clienteBus.getCliente(Integer.parseInt(request.getParameter("codCliente")));
        request.setAttribute("cliente", cliente);

        return mapping.getInputForward();
    }

    /**
     * This is the Struts action method called on http://.../actionPath?method=myAction2, where
     * "method" is the value specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward salvar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClienteForm clienteForm = (ClienteForm) form;
        ActionErrors errors = clienteForm.validate(mapping, request);

        if (errors.isEmpty()) {
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(cliente, clienteForm);
            ClienteBusiness clienteBus = new ClienteBusiness();

            try {
                clienteBus.setCliente(cliente);
                request.setAttribute("titulo","titulo.editar.cliente");
                request.setAttribute("mensaje","mensaje.exito.cliente.editado");
                return mapping.findForward(SUCCESS);

            } catch (SQLException ex) {
                errors.add("errors", new ActionMessage("error.bd.cliente.no.editado"));
                this.saveErrors(request, errors);
            }
           

        } else {
            request.setAttribute("cliente", this.cliente);
            this.saveErrors(request, errors);
            
        }        
        return mapping.getInputForward();        
    }
}
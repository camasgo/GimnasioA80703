/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.gimnasioa80703.application.action;

import cr.ac.ucr.gimnasioa80703.application.form.RutinaForm;
import cr.ac.ucr.gimnasioa80703.business.ClienteBusiness;
import cr.ac.ucr.gimnasioa80703.business.MedidaCorporalBusiness;
import cr.ac.ucr.gimnasioa80703.dominio.Cliente;
import cr.ac.ucr.gimnasioa80703.dominio.ItemRutinaMedida;
import cr.ac.ucr.gimnasioa80703.dominio.MedidaCorporal;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Carlos
 */
public class InsetarRutinaAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private LinkedList<MedidaCorporal> medidasCorporales;
    private LinkedList<ItemRutinaMedida> itemesRutinaMedida;
    

    /**
     * This is the Struts action method called on http://.../actionPath?method=myAction1, where
     * "method" is the value specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward iniciar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ClienteBusiness clienteBus = new ClienteBusiness();
        LinkedList<Cliente> clientes = clienteBus.getClientes();
        request.setAttribute("clientes", clientes);
        MedidaCorporalBusiness medidaBus = new MedidaCorporalBusiness();
        medidasCorporales = medidaBus.getMedidasCorporales();
        request.setAttribute("medidas", this.medidasCorporales);
        itemesRutinaMedida = new LinkedList<ItemRutinaMedida>();
        request.setAttribute("itemesMedidas", itemesRutinaMedida);
        
        
        return mapping.getInputForward();
    }

    /**
     * This is the Struts action method called on http://.../actionPath?method=myAction2, where
     * "method" is the value specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward salvar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        
        
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward incluirMedida(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        request.setAttribute("clientes", request.getAttribute("clientes"));
        request.setAttribute("medidas", this.medidasCorporales);        
        
        return mapping.getInputForward();
    }
}
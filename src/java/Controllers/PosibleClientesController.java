/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.clsPosiblesClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PosibleClientesController", urlPatterns = {"/PosibleClientesController"})
public class PosibleClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnModificar") != null) {
                          btnModificar(request, response);
        } else if (request.getParameter("btnCancelar") != null) {
                       
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
        } 
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            List<Models.clsPosiblesClientes> lstclsPosiblesClienteses = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClienteses = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }
            int inposicion = 0;
            for (clsPosiblesClientes elem : lstclsPosiblesClienteses) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoModificar"))) {
                    break;
                }
                inposicion++;
            }

              Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            if (request.getParameter("txtEmpresa") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtSitioWeb") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStSitioWeb(request.getParameter("txtSitioWeb"));
            }

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                String stDescripcion = "";

                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    stDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    stDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    stDescripcion = "Recomendacion de empleado";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    stDescripcion = "Recomendacion externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    stDescripcion = "Tienda en linea";
                }

                obclsFuentePosibleCliente.setStDescripcion(stDescripcion);

                lstclsPosiblesClienteses.get(inposicion).setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                String stDescripcion = "";

                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    stDescripcion = "Intento de contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    stDescripcion = "Contactar en el futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    stDescripcion = "Contactado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    stDescripcion = "Posible cliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    stDescripcion = "Posible cliente perdido";
                }

                obclsEstadoPosibleCliente.setStDescription(stDescripcion);

                lstclsPosiblesClienteses.get(inposicion).setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                String stDescripcion = "";

                if (request.getParameter("ddlSector").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlSector").equals("2")) {
                    stDescripcion = "APS(Proveedor de servicios de aplicaciones)";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    stDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    stDescripcion = "ERP(Planificacion de recursos de empresa)";
                } else if (request.getParameter("ddlSector").equals("5")) {
                    stDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    stDescripcion = "Empresa grande";
                }

                obclsSector.setStDescription(stDescripcion);

                lstclsPosiblesClienteses.get(inposicion).setObclsSector(obclsSector);
            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                lstclsPosiblesClienteses.get(inposicion).setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                lstclsPosiblesClienteses.get(inposicion).setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }
            if (request.getParameter("ddlCalificacion") != null) {
                lstclsPosiblesClienteses.get(inposicion).setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                String stDescripcion = "";

                if (request.getParameter("ddlCalificacion").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    stDescripcion = "Adquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    stDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    stDescripcion = "Contactado";
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    stDescripcion = "Fallo de mercado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    stDescripcion = "Proyecto cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("7")) {
                    stDescripcion = "Apagar";
                }

                obclsCalificacion.setStDescription(stDescripcion);

                lstclsPosiblesClienteses.get(inposicion).setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                lstclsPosiblesClienteses.get(inposicion).setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                lstclsPosiblesClienteses.get(inposicion).setChNoParticipacionCorreoElectronico('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                lstclsPosiblesClienteses.get(inposicion).setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClienteses);

            request.setAttribute("stMensaje", "se realizo proceso con exito");
            request.setAttribute("stTipo", "success");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
            
            }catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
           
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }

        }

    

    public void btnEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            List<Models.clsPosiblesClientes> lstclsPosiblesClientesNueva = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
                lstclsPosiblesClientesNueva = lstclsPosiblesClientes;
            }

            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = item;
                    lstclsPosiblesClientesNueva.remove(item);
                    break;

                }

            }

            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientesNueva);
            request.setAttribute("stTipo", "success");
            request.setAttribute("stMensaje", "Se realizo proceso con exito.");
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }

            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = item;
                }
            }

            request.setAttribute("obclsPosiblesClientes", obclsPosiblesClientes);
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtSitioWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtSitioWeb"));
            }

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                String stDescripcion = "";

                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    stDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    stDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    stDescripcion = "Recomendacion de empleado";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    stDescripcion = "Recomendacion externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    stDescripcion = "Tienda en linea";
                }

                obclsFuentePosibleCliente.setStDescripcion(stDescripcion);

                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                String stDescripcion = "";

                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    stDescripcion = "Intento de contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    stDescripcion = "Contactar en el futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    stDescripcion = "Contactado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    stDescripcion = "Posible cliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    stDescripcion = "Posible cliente perdido";
                }

                obclsEstadoPosibleCliente.setStDescription(stDescripcion);

                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                String stDescripcion = "";

                if (request.getParameter("ddlSector").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlSector").equals("2")) {
                    stDescripcion = "APS(Proveedor de servicios de aplicaciones)";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    stDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    stDescripcion = "ERP(Planificacion de recursos de empresa)";
                } else if (request.getParameter("ddlSector").equals("5")) {
                    stDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    stDescripcion = "Empresa grande";
                }

                obclsSector.setStDescription(stDescripcion);

                obclsPosiblesClientes.setObclsSector(obclsSector);
            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }
            if (request.getParameter("ddlCalificacion") != null) {
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                String stDescripcion = "";

                if (request.getParameter("ddlCalificacion").equals("1")) {
                    stDescripcion = "Ninguno";
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    stDescripcion = "Adquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    stDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    stDescripcion = "Contactado";
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    stDescripcion = "Fallo de mercado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    stDescripcion = "Proyecto cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("7")) {
                    stDescripcion = "Apagar";
                }

                obclsCalificacion.setStDescription(stDescripcion);

                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }
            HttpSession session = request.getSession(true);

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }

            int inCodigo = lstclsPosiblesClientes.size() + 1;
            obclsPosiblesClientes.setInCodigo(inCodigo);

            lstclsPosiblesClientes.add(obclsPosiblesClientes);
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);

            request.setAttribute("stMensaje", "se realizo proceso con exito");
            request.setAttribute("stTipo", "success");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author FranciscoJosé
 */
@ManagedBean
@RequestScoped
public class CiudadanoBean {
    private Date fechaActual = new Date();

    public Date getFechaActual() {
        return fechaActual;
    }
}

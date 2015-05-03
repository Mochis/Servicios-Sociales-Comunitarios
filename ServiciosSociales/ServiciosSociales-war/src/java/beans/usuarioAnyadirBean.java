/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package beans;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


/**
 *
 * @author DarkDragon
 */

@ManagedBean
@SessionScoped
public class usuarioAnyadirBean{
    
    private String text;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String sexo;
    private String estado_civil;
    private Date fecha_nacimiento;
    private String localidad;
    private String nacionalidad;
    private String email;
    private String tipo_profesional;
    private String contrasenya;
    
    
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido1() {
        return apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    public String getApellido2() {
        return apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getEstado_civil() {
        return estado_civil;
    }
    
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    
    
    public String getLocalidad() {
        return localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTipo_profesional() {
        return tipo_profesional;
    }
    
    public void setTipo_profesional(String tipo_profesional) {
        this.tipo_profesional = tipo_profesional;
    }
    
    public String getContrasenya() {
        return contrasenya;
    }
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    private String calcularDNI(String s){
        String res="error";
        String letra="TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            int n=Integer.parseInt(s);
            if(n<0 || n>99999999){
                res="error";
            }else{
                n=n%23;
                res= letra.substring(n, n+1);
            }
            return res;
        } catch (NumberFormatException nfe){
            return "error";
        }
    }
    
    
    public void validarDni(FacesContext context,UIComponent component,Object input) throws ValidatorException {
        String var = (String)input;
        
        if(var.length() < 9){
            throw new ValidatorException(
                    new FacesMessage("Introduzca un DNI válido con una longitud igual a 9.", null));
        }
       if(!var.substring(8).equals(calcularDNI(var.substring(0,8)))){ 
        throw new ValidatorException(
        new FacesMessage("Introduzca un DNI válido.La letra no coincide", null));
        }
        
    }
    public String enviar() {
        return "usuarioAnyadirResultado.xhtml?faces-redirect=true";
    }
}
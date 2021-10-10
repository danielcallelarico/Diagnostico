
package Registro_Estudiantes;


 public class cAlumno{
    private int codigo;
    private String nombres;
    private Double practica;
    private Double exparcial;
    private Double exfinal;
    public Double calcular_promedio(){
        return ((practica*0.2)+(exparcial*0.4)+(exfinal*0.4));
    }
    public int getCodigo(){return codigo;}
    public void setCodigo(int codigo){this.codigo = codigo;}
    public Double getExfinal(){return exfinal;}
    public void setExfinal(Double exfinal){this.exfinal = exfinal;}
    public Double getExparcial(){return exparcial;}
    public void setExparcial(Double exparcial){this.exparcial = exparcial;}
    public String getNombres(){return nombres;}
    public void setNombres(String nombres){this.nombres = nombres;}
    public Double getPractica(){return practica;}
    public void setPractica(Double practica){this.practica = practica;}
}
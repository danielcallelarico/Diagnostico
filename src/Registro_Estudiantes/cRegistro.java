
package Registro_Estudiantes;

public class cRegistro {
    //atributos
    private cAlumno objAlumno[];
    private int contador;
    //constructor
    public cRegistro(int n) {
        objAlumno=new cAlumno[n];
        //
        objAlumno[0]=new cAlumno();
        objAlumno[0].setCodigo(6);
        objAlumno[0].setNombres("CARLOS");
        objAlumno[0].setPractica(18.0);
        objAlumno[0].setExparcial(15.5);
        objAlumno[0].setExfinal(12.0);
        objAlumno[1]=new cAlumno();
        objAlumno[1].setCodigo(3);
        objAlumno[1].setNombres("CARMEN");
        objAlumno[1].setPractica(15.0);
        objAlumno[1].setExparcial(15.0);
        objAlumno[1].setExfinal(12.0);
        //
        contador=2;
    }
    //operaciones
    public void agregar_alumno(int codigo,String nombres,Double practica,Double exparcial,Double exfinal){
        int flag=0;
        for(int i=0;i<contador;i++){
            if(codigo==objAlumno[i].getCodigo()){
                flag=1;
            }
        }
        if(flag==0){
            if(contador<objAlumno.length){
                objAlumno[contador]=new cAlumno();
                objAlumno[contador].setCodigo(codigo);
                objAlumno[contador].setNombres(nombres);
                objAlumno[contador].setPractica(practica);
                objAlumno[contador].setExparcial(exparcial);
                objAlumno[contador].setExfinal(exfinal);
                contador++;
            }
            else{
                System.out.println("NO SE PUEDE AGREGAR ALUMNO...VECTOR LLENO!!!");
            }
        }
        else{
            System.out.println("EL CODIGO INGRESADO ES REPETIDO...!!!");
        }
    }
    public String listar_alumnos(){
        String lista="LISTA DE ALUMNOS\n";
        for(int i=0;i<contador;i++){
            lista+=(i+1)+".-"+"\t"+objAlumno[i].getCodigo()+"\t"+objAlumno[i].getNombres()+"\t"+objAlumno[i].calcular_promedio()+"\n";
        }
        return lista;
    }
    public void buscar_alumno(int codigo)
    {
        int posicion=-1;
        for(int i=0;i<contador;i++){
            if(codigo==objAlumno[i].getCodigo())
                posicion=i;
        }
        if(posicion!=-1){
            System.out.println("EL ALUMNO DE CODIGO: "+codigo+" ES "+ objAlumno[posicion].getNombres());
        }
        else{
            System.out.println("EL ALUMNO DE CODIGO: "+codigo+" NO EXISTE");
        }
    }
    public void buscar_alumno(String nombres){
        int posicion=-1;
        for(int i=0;i<contador;i++){
            if(nombres.equals(objAlumno[i].getNombres()))
                posicion=i;
        }
        if(posicion!=-1){
            System.out.println("EL ALUMNO DE NOMBRE: "+nombres+" TIENE EL CODIGO "+objAlumno[posicion].getCodigo());
        }
        else{
            System.out.println("EL ALUMNO DE NOMBRE: "+nombres+" NO EXISTE");
        }
    }
    public void ordenar_codigo(){
        for (int i=0; i<contador-1; i++){
            for (int j=i+1;j<contador; j++){
                if(objAlumno[i].getCodigo() > objAlumno[j].getCodigo()){
                    cAlumno temp=objAlumno[i];
                    objAlumno[i]=objAlumno[j];
                    objAlumno[j]=temp;
                }
            }
        }
    }
    public void ordenar_nombres(){
        for (int i=0; i<contador-1; i++){
            for (int j=i+1; j<contador; j++){
                if(objAlumno[i].getNombres().compareTo(objAlumno[j].getNombres())>1){
                    cAlumno temp=objAlumno[i];
                    objAlumno[i]=objAlumno[j];
                    objAlumno[j]=temp;
                }
            }
        }
    }
    public void modificar_parcial(int codigo, double parcial){
        int index;
        index=encontrar_alumno(codigo);
        if (index==-1){
            System.out.println("EL ALUMNO DE CODIGO: "+codigo+" NO EXISTE");
        }
        else{
            objAlumno[index].setPractica(parcial);
        }
    }
    public int encontrar_alumno(int codigo)
    {
        int posicion=-1;
        for(int i=0;i<contador;i++){
            if(codigo == objAlumno[i].getCodigo()){
                posicion=i;
            }
        }
        return posicion;
    }
    public void eliminar_alumno(int codigo){
        int index;
        index=encontrar_alumno(codigo);
        if(index==-1){
            System.out.println("EL ALUMNO DE CODIGO: "+codigo+" NO EXISTE");
        }
        else{
            for(int i=index;i<contador;i++){
                objAlumno[i]=objAlumno[i+1];
            }
            contador--;
        }
    }
    public String listar_aprobados(){
        String lista="LISTA DE ALUMNOS APROBADOS\n";
        for(int i=0;i<contador;i++){
            if(10.5<=objAlumno[i].calcular_promedio()){
                lista+=(i+1)+".-"+"\t"+objAlumno[i].getCodigo()+"\t"+objAlumno[i].getNombres()+"\t"+objAlumno[i].calcular_promedio()+"\n";
            }
        }
        return lista;
    }
}

package progavefenix.reservaaulas;

public class Persona {
    int idnt; /*Identificador del usuario. Cambiar por UUID.*/
    String nombre; /*El "nombre" de la persona.*/
    String email; /*Así conoceremos a la persona.*/
    String mdp; /*Contraseña. Requiere codificación.*/
    boolean administrador; /*Recordar poner el primer usuario como administrador.*/

    public Persona(int idnt, String nombre, String email, String mdp, boolean administrador) {
        this.idnt = idnt;
        this.nombre = nombre;
        this.email = email;
        this.mdp = mdp;
        this.administrador = administrador;
    }

    public int obtIdnt() {
        return idnt;
    }

    public void metIdnt(int idnt) {
        this.idnt = idnt;
    }

    public String obtNombre() {
        return nombre;
    }

    public void metNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtEmail() {
        return email;
    }

    public void metEmail(String email) {
        this.email = email;
    }

    public String obtMdp() {
        return mdp;
    }

    public void metMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void metAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    
}

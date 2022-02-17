package progavefenix.reservaaulas;

import java.time.LocalDateTime;

public class Reserva {
    int idnt; /*Identificador del reserva. Cambiar por UUID.*/
    int idntUsuario; /*Autor de la reserva. Se enviará a través del constructor. Cambiar por UUID.*/
    int idntAula; /*Aula reservada. Se enviará a través del constructor. Cambiar por UUID.*/
    LocalDateTime inicio; /*Inicio reserva.*/
    LocalDateTime fin; /*Fin reserva.*/
    
    /*Por facilidad, solo se podrá incluir un aula por reserva. Reservar varias aulas supondrá varias reservas.*/

    public Reserva(int idnt, int idntUsuario, int idntAula, LocalDateTime inicio, LocalDateTime fin) {
        this.idnt = idnt;
        this.idntUsuario = idntUsuario;
        this.idntAula = idntAula;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int obtIdnt() {
        return idnt;
    }

    public void metIdnt(int idnt) {
        this.idnt = idnt;
    }

    public int obtIdntUsuario() {
        return idntUsuario;
    }

    public void metIdntUsuario(int idntUsuario) {
        this.idntUsuario = idntUsuario;
    }

    public int obtIdntAula() {
        return idntAula;
    }

    public void metIdntAula(int idntAula) {
        this.idntAula = idntAula;
    }

    public LocalDateTime obtInicio() {
        return inicio;
    }

    public void metInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime obtFin() {
        return fin;
    }

    public void metFin(LocalDateTime fin) {
        this.fin = fin;
    }
    
    
}

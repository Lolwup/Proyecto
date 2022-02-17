package progavefenix.reservaaulas;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Metodos {
    Scanner scanner = new Scanner(System.in);
    Aula aula; /*Placeholder*/
    int aulamaxima; /*Cambiar por el número real de aulas.*/
    int reservaActual = 0; /*Cambiar por el UUID.*/
    int idntUsuario = 10; /*Cambiar por el idnt del usuario. Esta variable debe desaparecer del programa final.*/
    LocalDateTime inicio;
    LocalDateTime fin;
    boolean valido = false;
    boolean reservaValida = false;
    public void CambiarAdministrador(Persona usuario, Persona persona) {
        if(usuario.idnt == 1)
            if(persona.administrador == false) {
                persona.administrador = true;
            }
            else if(persona.administrador == true) {
                persona.administrador = false;
            }
    }
    
    /*El usuario se crea en el momento de entrar por primera vez.
    Si está en la base, simplemente recurre a ese usuario.*/
    
    /*Introducir elegir aula en el bucle.*/
    while(reservaValida == false) { /*Proceso.*/
        reservaValida = false;
        while(aula.idnt <= 0 || aula.idnt > aulamaxima) {
            System.out.println("Introduzca el número de aula a reservar.");
            aula.idnt = scanner.nextInt();
            if(aula.idnt > aulamaxima) {
                System.out.println("Aula aún inexistente. Vuelva a intentarlo.");
            }
            else if(aula.idnt <= 0) {
                System.out.println("Error de introducción de datos. Vuelva a intentarlo.");
            }
        }
        while(valido == false) {
            valido = false;
            System.out.println("Introduzca la fecha y hora de inicio. Las reservas se harán solo para horas en punto.");
            System.out.println("Reservamos aulas todos los días del año. En caso de cerrar algún día, será notificado.");
            System.out.println("Si desea reservar el mismo aula varios días distintos, tendrá que hacer una reserva por día.");
            int numerohoras = 0;
            int hora = 0;
            int dia = 0;
            int mes = 0;
            int ciclo = 0; /*= Año. No voy a hacer chistes malos.*/
            while(hora < 8 || hora >= 22) {
                hora = 0;
                System.out.println("Introduzca la hora de inicio de su reserva. Las aulas estarán disponibles de 8 a 22.");
                hora = scanner.nextInt();
            }
            while(dia <= 0 || dia > 31) {
                dia = 0;
                System.out.println("Introduzca el día de su reserva.");
                dia = scanner.nextInt();
            }
            while(mes <= 0 || mes > 12) {
                mes = 0;
                System.out.println("Introduzca el mes de su reserva.");
                mes = scanner.nextInt();
            }
            Date cicloActual = new Date();
            while(ciclo < cicloActual.getYear()) { /*¿getYear está deprecado?*/
                ciclo = 0;
                System.out.println("Introduzca el año de su reserva.");
                ciclo = scanner.nextInt();
            }
            inicio = LocalDateTime.of(ciclo, mes, dia, hora, 0, 0);
            if(inicio.isBefore(LocalDateTime.now())) {
                valido = false; /*Prohibido reservar para antes de ahora mismo.*/
            }
            else if(dia == 31 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                valido = false; /*Prohibido resevar día 31 de los meses de 30 días.*/
            }
            else if(dia >= 30 && mes == 2) {
                valido = false; /*Prohibido reservar días 30 y 31 de febrero.*/
            }
            else if(dia >= 29 && mes == 2 && (ciclo % 4 != 0 || (ciclo % 100 == 0 && ciclo % 400 != 0))) {
                valido = false; /*Prohibido reservar el 29 de febrero de años no bisiesto.*/
            }
            else {
                valido = true;
            }
            if(valido == true) {
                while(numerohoras <= 0 || hora > 14) {
                    numerohoras = 0;
                    System.out.println("Introduzca cuántas horas quiere reservar. Las aulas estarán disponibles de 8 a 22.");
                    numerohoras = scanner.nextInt();
                    if(hora + numerohoras > 22) {
                        System.out.println("Cerramos a las 22:00. Deberá hacer una reserva más corta.");
                    }
                }
                fin = LocalDateTime.of(ciclo, mes, dia, hora + numerohoras, 0, 0);
            }
            if(valido == false) {
                System.out.println("Fecha de inicio no válida. Vuelva a intentarlo.");
            }
        }
        reservaActual = reservaActual + 1;
        Reserva reserva = new Reserva(reservaActual, idntUsuario, aula.idnt, inicio, fin);
        boolean reservaCopada = false;
        if(reservaCopada == true) {
            /*Lanzar excepción de hora copada. En ese caso, borra esta reserva.*/
            reservaValida = false;
        }
        if(reservaCopada == false) {
            /*Lanzar confirmación de reserva.*/
            reservaValida = true;
        }
    }
}

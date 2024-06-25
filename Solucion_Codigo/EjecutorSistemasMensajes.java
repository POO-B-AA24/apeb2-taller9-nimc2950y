package EjecutorSistemasMensajes;

import java.util.Scanner;

public class EjecutorSistemasMensajes {

    public static void main(String[] args) {
        Movil remitente = new Movil("0994462273", "Nathan");
        Movil destinatario = new Movil("0995678991", "Guido");

        SMS sms = new SMS(remitente, destinatario, "Hola, ¿cómo estás?");
        MMS mms = new MMS(remitente, destinatario, "Foto.jpg");
        sms.enviarMensaje();
        sms.visualizarMensaje();
        mms.enviarMensaje();
        mms.visualizarMensaje();
    }
}
class Movil {
    private String num;
    private String nomb;

    public Movil(String num) {
        this.num = num;
    }

    public Movil(String num, String nomb) {
        this.num = num;
        this.nomb = nomb;
    }

    public String getNum() {
        return num;
    }

    public String getNomb() {
        return nomb;
    }
}

class Mensaje {
    private Movil remitente;
    private Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Movil getRemitente() {
        return remitente;
    }

    public Movil getDestinatario() {
        return destinatario;
    }

    public void enviarMensaje() {
        System.out.println("Enviando mensaje de " + getRemitente().getNum() + " a " + getDestinatario().getNum());
    }

    public void visualizarMensaje() {
        System.out.println("Visualizando mensaje de " + getRemitente().getNum() + " a " + getDestinatario().getNum());
    }
}

class SMS extends Mensaje {
    private String caracteres;

    public SMS(Movil remitente, Movil destinatario, String caracteres) {
        super(remitente, destinatario);
        this.caracteres = caracteres;
    }
    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS de " + getRemitente().getNum() + " a " + getDestinatario().getNum() + ": " + caracteres);
    }
    @Override
    public void visualizarMensaje() {
        System.out.println("Visualizando SMS de " + getRemitente().getNum() + " a " + getDestinatario().getNum() + ": " + caracteres);
    }
}

class MMS extends Mensaje {
    private String nombFichero;

    public MMS(Movil remitente, Movil destinatario, String nombFichero) {
        super(remitente, destinatario);
        this.nombFichero = nombFichero;
    }
    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS de " + getRemitente().getNum() + " a " + getDestinatario().getNum() + " con fichero: " + nombFichero);
    }
    @Override
    public void visualizarMensaje() {
        System.out.println("Visualizando MMS de " + getRemitente().getNum() + " a " + getDestinatario().getNum() + " con fichero: " + nombFichero);
    }
}
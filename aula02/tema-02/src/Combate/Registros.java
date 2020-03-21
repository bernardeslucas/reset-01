package Combate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registros {

    public static List<Registros> listaRegistros = new ArrayList<>();
    private final LocalDateTime timeStamp;
    private final String nome;
    private final String nomeAlvo;
    private final String habilidade;
    private final int dano;
    private final String status;
    private static int contadorAtaques;

    public static int getContadorAtaques() {
        return contadorAtaques;
    }

    public Registros(String nome, String nomeAlvo, String habilidade, int dano, String status) {
        this.timeStamp = LocalDateTime.now();
        this.nome = nome;
        this.nomeAlvo = nomeAlvo;
        this.habilidade = habilidade;
        this.dano = dano;
        this.status = status;
    }

    public static void imprimirRegistros() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("=======================================================================================================");
        for (Registros listaRegistro : listaRegistros) {
            System.out.println("[" + dtf.format(listaRegistro.getTimeStamp()) + "] " + listaRegistro.getNome() + " atacou "
                    + listaRegistro.getNomeAlvo() + " com " + listaRegistro.getHabilidade() + " causando "
                    + listaRegistro.getDano() + " de dano" + listaRegistro.getStatus());
        }
    }

    public static void duracaoCombate() {
        try {
            LocalDateTime dataInicial = listaRegistros.get(0).getTimeStamp();
            LocalDateTime dataFinal = listaRegistros.get(listaRegistros.size() - 1).getTimeStamp();

            long millis = Duration.between(dataInicial, dataFinal).toMillis();

            String result = String.format("%02dh %02dm %02ds %03dms",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                    millis - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))
            );
            System.out.println("=======================================================================================================\n" +
                    "[Duração do combate: "+result+"]");
        } catch (Exception e) {
            System.out.println("=======================================================================================================\n" +
                    "Não houve combate nessa sessão.");
        }

    }

    public static void numeroAtaques(){
        contadorAtaques++;
    }




    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAlvo() {
        return nomeAlvo;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public int getDano() {
        return dano;
    }

    public String getStatus() {
        return status;
    }


}

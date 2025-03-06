package map.Ordenacao;


import map.OperacoesBasicas.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap =  new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.MARCH, 6), "Linkin Park: From Zero Tour", "Linkin Park");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.MARCH, 7), "Revela Samba Beach", "Grupo Revelação");
        agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Pagode do Exalta", "ExaltaSamba");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.MARCH, 7), "Feijoada do Thiago Soares", "Thiago Soares");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}

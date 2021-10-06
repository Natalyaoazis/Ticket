package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchBy(String departure, String arrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll(departure,arrival)) {
            if (matches(ticket, departure, arrival)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String departure, String arrival) {
        if (ticket.getDeparture().contains(departure) && ticket.getArrival().contains(arrival)) {
            return true;
        }
        return false;
    }
}

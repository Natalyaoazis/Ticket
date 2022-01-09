package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket ticket1 = new Ticket(1,2700,"DME","KRR",135);
    private Ticket ticket2 = new Ticket(2,2660,"DME","KRR",135);
    private Ticket ticket3 = new Ticket(3,3100,"DME","KRR",135);
    private Ticket ticket4 = new Ticket(4,22500,"DME","TOF",270);
    private Ticket ticket5 = new Ticket(5,2300,"KRR","DME",135);
    private Ticket ticket6 = new Ticket(6,19000,"DME","OVB",270);
    private Ticket ticket7 = new Ticket(7,13000,"DME","OVB",270);
    private Ticket ticket8 = new Ticket(8,50500,"DME","TOF",270);
    private Ticket ticket9 = new Ticket(9,30500,"DME","KRR",140);
    private Ticket ticket10 = new Ticket(10,1000,"DME","KRR",140);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void shouldFindFromDMEToOVB() {
        Ticket[] expected = new Ticket[] {ticket7, ticket6};
        Ticket[] actual = manager.searchBy("DME","OVB");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNothing() {
        Ticket[] expected = new Ticket[0] ;
        Ticket[] actual = manager.searchBy("KRR","OVB");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindKrrToDme() {
        Ticket[] expected = new Ticket[] {ticket5} ;
        Ticket[] actual = manager.searchBy("KRR","DME");
        assertArrayEquals(expected, actual);
    }
}
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
    public void shouldSortAllByPrice() {
        Ticket[] expected = new Ticket[] {ticket10, ticket5, ticket2, ticket1, ticket3, ticket7, ticket6, ticket4, ticket9, ticket8};
        Ticket[] actual= new Ticket[] {ticket10, ticket5, ticket2, ticket1, ticket3, ticket7, ticket6, ticket4, ticket9, ticket8};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindDMEToOVB() {
        Ticket[] expected = new Ticket[] {ticket7, ticket6};
        Ticket[] actual = manager.searchBy("DME","OVB");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortByPriceFromDMEToKRR() {
        Ticket[] expected = new Ticket[] {ticket10, ticket2, ticket1, ticket3, ticket9};
        Ticket[] actual = manager.searchBy("DME","KRR");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNothing() {
        Ticket[] expected = new Ticket[0] ;
        Ticket[] actual = manager.searchBy("KRR","OVB");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindKrrToDme() {
        Ticket[] expected = new Ticket[] {ticket5} ;
        Ticket[] actual = manager.searchBy("KRR","DME");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
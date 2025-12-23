package com.example.tickettracker.service;

import com.example.tickettracker.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTickets();

    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(Long id);

    void deleteTicket(Long id);

    List<Ticket> searchTickets(String keyword);
}

package com.example.tickettracker.service;

import com.example.tickettracker.entity.Ticket;
import com.example.tickettracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        ticket.setCreatedOn(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> searchTickets(String keyword) {
        return ticketRepository
                .findByTitleContainingIgnoreCaseOrShortDescriptionContainingIgnoreCase(
                        keyword, keyword
                );
    }
}

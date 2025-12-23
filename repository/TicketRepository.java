package com.example.tickettracker.repository;

import com.example.tickettracker.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByTitleContainingIgnoreCaseOrShortDescriptionContainingIgnoreCase(
            String title, String shortDescription
    );
}

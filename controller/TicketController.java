package com.example.tickettracker.controller;

import com.example.tickettracker.entity.Ticket;
import com.example.tickettracker.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "index";
    }

    @GetMapping("/new")
    public String createTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "create-ticket";
    }

    @PostMapping("/save")
    public String saveTicket(@ModelAttribute Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "edit-ticket";
    }

    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewTicket(@PathVariable Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "view-ticket";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("tickets", ticketService.searchTickets(keyword));
        return "index";
    }
}

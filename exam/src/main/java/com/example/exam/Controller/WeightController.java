package com.example.exam.Controller;

import com.example.exam.Models.User;
import com.example.exam.Models.WeightEntry;
import com.example.exam.Repository.WeightEntryRepository;
import com.example.exam.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/weights")
public class WeightController {

    private final WeightEntryRepository weightEntryRepo;
    private final UserService userService;
    private static final int PAGE_SIZE = 10;

    @Autowired
    public WeightController(WeightEntryRepository weightEntryRepo, UserService userService) {
        this.weightEntryRepo = weightEntryRepo;
        this.userService = userService;
    }

    private Optional<User> getCurrentUser(Principal principal) {
        if (principal == null) return Optional.empty();
        return userService.findByUsername(principal.getName());
    }

    @GetMapping
    public String listWeights(
            Model model,
            Principal principal,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end
    ) {
        Optional<User> uOpt = getCurrentUser(principal);
        if (uOpt.isEmpty()) {
            return "redirect:/login";
        }
        User user = uOpt.get();

        if (start != null && end != null && !start.isBlank() && !end.isBlank()) {
            // date-range search
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            List<WeightEntry> list = weightEntryRepo.findByUserAndDateBetweenOrderByDateDesc(user, startDate, endDate);
            model.addAttribute("weights", list);
            model.addAttribute("start", start);
            model.addAttribute("end", end);
            model.addAttribute("isRange", true);
            return "weights";
        } else {
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            Page<WeightEntry> weightPage = weightEntryRepo.findByUserOrderByDateDesc(user, pageable);
            model.addAttribute("weightsPage", weightPage);
            model.addAttribute("currentPage", page);
            model.addAttribute("isRange", false);
            return "weights";
        }
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("weightEntry", new WeightEntry());
        return "weight_form";
    }

    @PostMapping("/add")
    public String addWeight(
            @ModelAttribute WeightEntry weightEntry,
            Principal principal,
            RedirectAttributes redirectAttributes
    ) {
        Optional<User> uOpt = getCurrentUser(principal);
        if (uOpt.isEmpty()) return "redirect:/login";
        User user = uOpt.get();

        LocalDate today = LocalDate.now();

        // Ensure only one weight per day per user
        Optional<WeightEntry> already = weightEntryRepo.findByUserAndDate(user, today);
        if (already.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "You have already added weight for today.");
            return "redirect:/weights";
        }

        weightEntry.setUser(user);
        weightEntry.setDate(today);
        weightEntry.setCreatedAt(java.time.LocalDateTime.now());
        weightEntryRepo.save(weightEntry);

        redirectAttributes.addFlashAttribute("success", "Weight added.");
        return "redirect:/weights";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        Optional<User> uOpt = getCurrentUser(principal);
        if (uOpt.isEmpty()) return "redirect:/login";
        User user = uOpt.get();

        Optional<WeightEntry> opt = weightEntryRepo.findById(id);
        if (opt.isEmpty() || !opt.get().getUser().getId().equals(user.getId())) {
            redirectAttributes.addFlashAttribute("error", "Entry not found or not allowed.");
            return "redirect:/weights";
        }

        model.addAttribute("weightEntry", opt.get());
        return "weight_form";
    }

    @PostMapping("/edit/{id}")
    public String editSubmit(@PathVariable Long id, @ModelAttribute WeightEntry weightEntry, Principal principal, RedirectAttributes redirectAttributes) {
        Optional<User> uOpt = getCurrentUser(principal);
        if (uOpt.isEmpty()) return "redirect:/login";
        User user = uOpt.get();

        Optional<WeightEntry> opt = weightEntryRepo.findById(id);
        if (opt.isEmpty() || !opt.get().getUser().getId().equals(user.getId())) {
            redirectAttributes.addFlashAttribute("error", "Entry not found or not allowed.");
            return "redirect:/weights";
        }

        WeightEntry existing = opt.get();

        // If changing date, ensure uniqueness for that date
        LocalDate newDate = weightEntry.getDate() != null ? weightEntry.getDate() : existing.getDate();
        if (!newDate.equals(existing.getDate())) {
            Optional<WeightEntry> conflict = weightEntryRepo.findByUserAndDate(user, newDate);
            if (conflict.isPresent()) {
                redirectAttributes.addFlashAttribute("error", "An entry already exists for that date.");
                return "redirect:/weights";
            }
        }

        existing.setWeight(weightEntry.getWeight());
        existing.setDate(newDate);
        // keep createdAt as original
        weightEntryRepo.save(existing);

        redirectAttributes.addFlashAttribute("success", "Entry updated.");
        return "redirect:/weights";
    }

    @PostMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Long id, Principal principal, RedirectAttributes redirectAttributes) {
        Optional<User> uOpt = getCurrentUser(principal);
        if (uOpt.isEmpty()) return "redirect:/login";
        User user = uOpt.get();

        Optional<WeightEntry> opt = weightEntryRepo.findById(id);
        if (opt.isEmpty() || !opt.get().getUser().getId().equals(user.getId())) {
            redirectAttributes.addFlashAttribute("error", "Entry not found or not allowed.");
            return "redirect:/weights";
        }

        weightEntryRepo.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Entry deleted.");
        return "redirect:/weights";
    }
}

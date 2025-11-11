package com.example.exam.Repository;

import com.example.exam.Models.WeightEntry;
import com.example.exam.Models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeightEntryRepository extends JpaRepository<WeightEntry, Long> {

    Optional<WeightEntry> findByUserAndDate(User user, LocalDate date);

    Page<WeightEntry> findByUserOrderByDateDesc(User user, Pageable pageable);

    List<WeightEntry> findByUserAndDateBetweenOrderByDateDesc(User user, LocalDate start, LocalDate end);
}

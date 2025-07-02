package com.conectaduoc.repository;

import com.conectaduoc.model.GlobalNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GlobalNotificationRepository extends JpaRepository<GlobalNotification, Long> {
    List<GlobalNotification> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDate inicio, LocalDate fin);
}

package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.magalums.entity.Notification;

public interface NotificationRepositoy extends JpaRepository<Notification, Long> {

}

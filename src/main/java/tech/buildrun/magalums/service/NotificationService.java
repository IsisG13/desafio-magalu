package tech.buildrun.magalums.service;

import org.springframework.stereotype.Service;

import tech.buildrun.magalums.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalums.repository.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }
}
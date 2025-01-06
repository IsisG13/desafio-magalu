package tech.buildrun.magalums.service;

import tech.buildrun.magalums.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.Status;
import tech.buildrun.magalums.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);
        notification.ifPresent(n -> {
            n.setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(n);
        });
    }

    // public void cancelNotification(Long notificationId) {
    // var notification = findById(notificationId);

    // if (notification.isPresent()) {
    // notification.get().setStatus(Status.Values.CANCELED.toStatus());
    // notificationRepository.save(notification.get());
    // }
    // }
}
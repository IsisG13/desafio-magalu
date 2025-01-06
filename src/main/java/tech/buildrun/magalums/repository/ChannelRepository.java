package tech.buildrun.magalums.repository;

import tech.buildrun.magalums.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
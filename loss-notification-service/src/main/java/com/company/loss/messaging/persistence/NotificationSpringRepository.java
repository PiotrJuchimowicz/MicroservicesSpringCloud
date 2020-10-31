package com.company.loss.messaging.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NotificationSpringRepository extends JpaRepository<Notification, NotificationId> {
}

package com.company.loss.management.infrastructure.persistence;

import com.company.loss.management.domain.business.Loss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
interface LossSpringRepository extends JpaRepository<Loss, UUID> {

    @Query("SELECT loss FROM Loss loss JOIN LossAdjuster lossAdjuster ON loss.id = lossAdjuster.id.lossId " +
            "WHERE lossAdjuster.id.adjusterId =:adjusterId")
    Set<Loss> findByLossAdjusterId(@Param("adjusterId") UUID adjusterId);
}

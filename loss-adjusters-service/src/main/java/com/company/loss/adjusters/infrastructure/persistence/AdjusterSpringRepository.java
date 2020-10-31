package com.company.loss.adjusters.infrastructure.persistence;

import com.company.loss.adjusters.domain.bussiness.Adjuster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface AdjusterSpringRepository extends JpaRepository<Adjuster, UUID> {

}

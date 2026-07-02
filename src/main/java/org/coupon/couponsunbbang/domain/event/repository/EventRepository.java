package org.coupon.couponsunbbang.domain.event.repository;

import org.coupon.couponsunbbang.domain.event.entity.Event;
import org.coupon.couponsunbbang.domain.event.entity.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    // QueryDSL은 EventQueryRepository에서 처리

    // 단건 조회: 삭제되지 않은 이벤트
    @Query("SELECT e FROM Event e WHERE e.id = : id AND e.deletedAt IS NULL")
    Optional<Event> findByIdAndNotDeleted(@Param("id") Long id);

    // 전체 목록 조회: 삭제되지 않은 이벤트
    @Query("SELECT e FROM Event  e WHERE e.deletedAt IS NUll")
    List<Event> findAllNotDeleted();

    // 상태별 목록 조회: 삭제되지 않고 특정 status인 이벤트만 (QueryParm ?status= 용)
    @Query("SELECT e FROM Event  e WHERE e.status = :status AND e.deletedAt IS NULL")
    List<Event> findByStatusAndNotDeleted(@Param("status") EventStatus status);

}

package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Message;

public interface MessageDao extends JpaRepository<Message, Long> {
    List<Message> findByIsBroadcastOrderByTimestampDesc(boolean isBroadcast);
}

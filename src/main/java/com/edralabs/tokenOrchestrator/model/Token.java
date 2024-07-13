package com.edralabs.tokenOrchestrator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Token {
    private String key;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private Boolean isBlocked=false;
    private LocalDateTime blockedAt;
    private LocalDateTime nextAutoUnBlockAt;

    public Token(String key, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.key = key;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(LocalDateTime blockedAt) {
        this.blockedAt = blockedAt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public LocalDateTime getNextAutoUnBlockAt() {
        return nextAutoUnBlockAt;
    }

    public void setNextAutoUnBlockAt(LocalDateTime nextAutoUnBlockAt) {
        this.nextAutoUnBlockAt = nextAutoUnBlockAt;
    }
}

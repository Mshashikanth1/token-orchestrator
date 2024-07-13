package com.edralabs.tokenOrchestrator.model.response;

import java.time.LocalDateTime;

public class TokenInfoResponse {
    private Integer id;
    private LocalDateTime createdAt;

    public TokenInfoResponse(Integer id, LocalDateTime createdAt, LocalDateTime expiresAt, Boolean isBlocked, LocalDateTime nextAutoUnBlockAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.isBlocked = isBlocked;
        this.nextAutoUnBlockAt = nextAutoUnBlockAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    private LocalDateTime expiresAt;
    private Boolean isBlocked;
    private LocalDateTime nextAutoUnBlockAt;
}

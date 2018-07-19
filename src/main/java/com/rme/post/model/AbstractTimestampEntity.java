package com.rme.post.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractTimestampEntity {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false)
	private Date lastUpdateTime;

	@PrePersist
	protected void onCreate() {
		lastUpdateTime = creationTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		lastUpdateTime = new Date();
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}

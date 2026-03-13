package com.gba.tasks.model;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {
	
	private long id;
	private String summary = "";
	private String description = "";
	private boolean done = false;
	private LocalDate dueDate;
	
	public Todo() {}
	
	public Todo(long id) {
		this.id = id;
	}

	public Todo(long id, String summary, String description, boolean done, LocalDate dueDate) {
		super();
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.done = done;
		this.dueDate = dueDate;
	}
	
	public Todo copy() {
		return new Todo(this.id, this.summary, this.description, this.done, this.dueDate);
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", summary=" + summary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return id == other.id;
	}
	
	
}

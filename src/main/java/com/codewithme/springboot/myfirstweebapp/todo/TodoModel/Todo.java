package com.codewithme.springboot.myfirstweebapp.todo.TodoModel;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

//DataBase(MySQL)

public class Todo {
	private int id;
	private String userName;
	
	@Size(min = 10, message = "Enter atleast 10 Characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	
	public Todo(int id, String userName, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDiscription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [Id=" + id + ", userName=" + userName + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
}

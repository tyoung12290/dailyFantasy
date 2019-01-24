package com.newjoiner.webapp.dailyfantasy.entity;

import java.sql.Timestamp;

public class Game {
	
private int id;
	
	private Integer gameId;
	
	private Object home;
	
	private Object away;
	
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Object getHome() {
		return home;
	}

	public void setHome(Object home) {
		this.home = home;
	}

	public Object getAway() {
		return away;
	}

	public void setAway(Object away) {
		this.away = away;
	}

	public Timestamp getTime() {
		return time;
	}

	public void Timestamp(Timestamp time) {
		this.time = time;
	}	


	
	

}

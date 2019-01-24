package com.newjoiner.webapp.dailyfantasy.entity;

import java.sql.Date;
import java.util.List;


public class PlayerDetail {

	public PlayerDetail() {};
	
	private int id;
	
	private Player player;
	
	private Team team;
	
	private List<Lineup> lineups;

	private Integer salary;
	
	private Integer actualScore;
	
	private Integer projectedScore;

	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	
	

	public Integer getActualScore() {
		return actualScore;
	}

	public void setActualScore(Integer actualScore) {
		this.actualScore = actualScore;
	}

	public Integer getProjectedScore() {
		return projectedScore;
	}

	public void setProjectedScore(Integer projectedScore) {
		this.projectedScore = projectedScore;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public List<Lineup> getLineups() {
		return lineups;
	}

	public void setLineups(List<Lineup> lineups) {
		this.lineups = lineups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + salary;
		result = prime * result + actualScore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDetail other = (PlayerDetail) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (salary != other.salary)
			return false;
		if (actualScore != other.actualScore)
			return false;
		return true;
	}
	
}

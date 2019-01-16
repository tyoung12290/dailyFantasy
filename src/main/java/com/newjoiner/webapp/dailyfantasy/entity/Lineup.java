package com.newjoiner.webapp.dailyfantasy.entity;

import java.sql.Date;
import java.util.List;
 
public class Lineup {
	
	public Lineup() {};
	

	private int id;
	
	private int userId;
 
	
    private List<PlayerDetail> playerDetails;
	
    private Date date;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<PlayerDetail> getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(List<PlayerDetail> playerDetails) {
        this.playerDetails = playerDetails;
    }
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + userId;
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
		Lineup other = (Lineup) obj;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
    	
}
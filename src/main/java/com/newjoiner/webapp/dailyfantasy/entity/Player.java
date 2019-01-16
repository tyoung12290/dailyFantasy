package com.newjoiner.webapp.dailyfantasy.entity;
 
public class Player {
	
	public Player() {}
 
	private int id;
 
    private String firstName;
     
    private String lastName;
 
    private String pos;
    
    private String team;
    

    public Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	

}
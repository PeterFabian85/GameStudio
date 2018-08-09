package sk.tsystems.gamestudio.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

public class Score implements Serializable, Comparable<Score>{
	private String game;
	private String player;
	private int points;
	private Date playedOn;

	public Score() {
	}

	public Score(String game, String player, int points, Date playedOn) {
		this.player = player;
		this.points = points;
		this.playedOn = playedOn;
		this.game = game;
	}
	 public String getGame() {
	        return game;
	    }

	    public void setGame(String game) {
	        this.game = game;
	    }
	   public Date getPlayedOn() {
		return playedOn;
	}



	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getWhen() {
		return playedOn;
	}

	public void setWhen(Date playedOn) {
		this.playedOn = playedOn;
	}

	@Override
    public String toString() {
        return "Score{" +
                "game='" + game + '\'' +
                ", username='" + player + '\'' +
                ", points=" + points +
                ", playedOn=" + playedOn +
                '}';
    }
	@Override
    public int compareTo(Score s) {
        return s.getPoints() - this.points;
    }



}

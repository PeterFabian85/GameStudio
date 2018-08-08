package sk.tsystems.gamestudio.service.ScoreService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sk.tsystems.gamestudio.entity.Score;


public class ScoreServiceJDBC implements ScoreService {
	
	
	private static final String URL = "jdbc:postgresql://localhost/gamestudio";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    
   
    private static final String INSERT =
            "INSERT INTO score (game, username, points, played_on) VALUES (?, ?, ?, ?)";

    private static final String SELECT =
            "SELECT game, username, points, played_on FROM score " +
                    "WHERE game = ? ORDER BY points DESC";
    
   
    

        @Override
        public void addScore(Score score) throws ScoreException {
            try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {
                try (PreparedStatement ps = c.prepareStatement(INSERT)) {
                	
                    ps.setString(1, score.getGame());
                    ps.setString(2, score.getPlayer());
                    ps.setInt(3, score.getPoints());
                    ps.setTimestamp(4, new Timestamp(score.getPlayedOn().getTime()));

                    ps.execute();
                } catch (SQLException e) {
                    throw new ScoreException("Error saving score", e);
                }
            } catch (SQLException e) {
                throw new ScoreException("Error connecting to database", e);
            }
        }




		public List<Score> getBestScores(String gameName) {
			   List<Score> scores = new ArrayList<>();

	            try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {
	                try (PreparedStatement ps = c.prepareStatement(SELECT)) {
	                    ps.setString(1, gameName);

	                    ResultSet rs = ps.executeQuery();
	                    while (rs.next()) {
	                        Score s = new Score(
	                                rs.getString(1),
	                                rs.getString(2),
	                                rs.getInt(3),
	                                rs.getTimestamp(4)
	                        );
	                        scores.add(s);
	                    }

	                } catch (SQLException e) {
	                    throw new ScoreException("Error saving score", e);
	                }
	            } catch (SQLException e) {
	                throw new ScoreException("Error connecting to database", e);
	            }

	            return scores;
	        }
		}

        

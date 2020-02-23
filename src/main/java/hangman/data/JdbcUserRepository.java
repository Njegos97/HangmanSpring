package hangman.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hangman.entity.User;

@Repository
public class JdbcUserRepository implements UserRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	
	
	@Override
	public User save(User user) {
		jdbc.update("insert into Users( username, email, password, enabled) values(?, ?, ?, ?) ",
     	user.getUsername(),
		user.getEmail(),
		user.getPassword(),
		user.isEnabled());
		
		jdbc.update("insert into Authorities (username, authority) values(?, ?)",
		user.getUsername(),
		user.getAuthority().toString());
		return null;
	}

	@Override
	public User findByUsername(String username) {
		User user = jdbc.queryForObject("select Users.username, email, password, enabled, authority "
				+ " from Users join Authorities on "
				+ " Users.username = Authorities.username where Users.username = ? ",
				this:: mapRowToUser, username);
		return user;
	}
	
	private User mapRowToUser(ResultSet rs, int rowNumber) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		user.setAuthority(User.Authority.valueOf(rs.getString("authority")));
		return user;
		
	}

}

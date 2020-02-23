package hangman.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcWordsRepository implements WordsRepository{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public String getRandomWord() {
		String word = jdbc.queryForObject("select name from Words order by Rand() limit 1", String.class);
		return word;
	}


}

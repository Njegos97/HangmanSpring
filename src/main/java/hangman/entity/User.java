package hangman.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	
	private String username;
	private String email;
	private String password;
	private boolean enabled;
	private Authority authority;
	
	public static enum Authority{
		ROLE_USER, ROLE_ADMIN
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.getAuthority().toString()));
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}

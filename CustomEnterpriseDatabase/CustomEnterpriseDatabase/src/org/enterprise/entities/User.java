package org.enterprise.entities;

/**
 * This class is also the 'enterprise_users' table in MySQL. <br />
 * To know more, just query the database to watch detail.<br />
 * 
 * @author PabloDNR
 *
 */
public class User {

	/*
	 * user_id int not null auto_increment,
	 * username nvarchar(30) not null,
	 * password nvarchar(15) not null,
	 * banned bit default 0,
	 */

	private int id = 0;				// Initialized to 0
	private char[] username;			// Still not initialized
	private char[] password;			// Still not initialized
	private boolean banned = true;	// No invites are not welcome here!

	public User( int id, char[] username, char[] password, boolean banned ) {
		if ( id == 0 ) {
			throw new IllegalArgumentException( "Id zero value is default and it's not permitted" );
		} else {
			if ( username.length < 8 | password.length < 8 ) {
				throw new IllegalArgumentException( "Username or password must be 8 characters lenght" );
			}
			this.id = id;
			this.username = username;
			this.password = password;
		}
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public char[] getUsername() {
		return username;
	}

	public void setUsername( char[] username ) {
		if ( username.length < 8 | password.length < 8 ) {
			throw new IllegalArgumentException( "Username or password must be 8 characters lenght" );
		}
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword( char[] password ) {
		this.password = password;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned( boolean banned ) {
		this.banned = banned;
	}
}

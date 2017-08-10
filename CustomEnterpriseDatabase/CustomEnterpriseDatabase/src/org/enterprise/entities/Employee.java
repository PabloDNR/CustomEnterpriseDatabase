package org.enterprise.entities;

import java.math.BigInteger;

/**
 * 
 * */
public class Employee {

	private int id = 0;
	private char[] firstName;
	private char[] lastName;
	private double salary = 0.0f;
	private String address1 = "";
	private String address2 = "";
	private BigInteger phone_number;
	private BigInteger cellphone_number;

	public Employee( int id, char[] firstName, char[] lastName, double salary, String address1,
	        String address2, BigInteger phone_number, BigInteger cellphone_number ) {
		if ( id == 0 ) {
			throw new IllegalArgumentException( "Id Zero is default, and you should use a valid ID." );
		} else {

			if ( firstName.length < 1 | lastName.length < 1 ) {
				throw new IllegalArgumentException( "Either first name or last name are empty and this is not normal" );
			}
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.salary = salary;
			this.address1 = address1;
			this.address2 = address2;
			this.phone_number = phone_number;
			this.cellphone_number = cellphone_number;
		}

	}

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public char[] getFirstName() {
		return firstName;
	}

	public void setFirstName( char[] firstName ) {
		this.firstName = firstName;
	}

	public char[] getLastName() {
		return lastName;
	}

	public void setLastName( char[] lastName ) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary( double salary ) {
		this.salary = salary;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1( String address1 ) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2( String address2 ) {
		this.address2 = address2;
	}

	public BigInteger getPhone_number() {
		return phone_number;
	}

	public void setPhone_number( BigInteger phone_number ) {
		this.phone_number = phone_number;
	}

	public BigInteger getCellphone_number() {
		return cellphone_number;
	}

	public void setCellphone_number( BigInteger cellphone_number ) {
		this.cellphone_number = cellphone_number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "Employee [id=" );
		builder.append( id );
		builder.append( ", firstName=" );
		builder.append( String.valueOf( firstName ) );
		builder.append( ", lastName=" );
		builder.append( String.valueOf( lastName ) );
		builder.append( ", salary=" );
		builder.append( salary );
		builder.append( ", address1=" );
		builder.append( address1 );
		builder.append( ", address2=" );
		builder.append( address2 );
		builder.append( ", phone_number=" );
		builder.append( phone_number.toString() );
		builder.append( ", cellphone_number=" );
		builder.append( cellphone_number.toString() );
		builder.append( "]" );
		return builder.toString();
	}
}
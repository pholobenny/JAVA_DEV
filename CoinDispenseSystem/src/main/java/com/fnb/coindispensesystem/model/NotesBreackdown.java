package com.fnb.coindispensesystem.model;

/**
 * 
 * @author Benny Pholo
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotesBreackdown {

	private String name; 
	private String value; 
	
	public NotesBreackdown(){
		super();
	}
	
	public NotesBreackdown(String name, String value){
		super();
		setName(name);
		setValue(value);
	}
	public void setName(String name){
		this.name= name; 
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getName(){
		return this.name;
	}
	public String getValue(){
		return this.value;
	}
	
	
	
}

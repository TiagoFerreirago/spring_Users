package com.thlifestore.users.user.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 30, nullable = false)
	private String name;
	@Column(length = 15, nullable = false)
	private String cpf;
	@Column(name= "dt_nasc",nullable = false)
	
	private LocalDate dt_Nasc;
	@Column(length = 10, nullable = false)
	private String genre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDt_Nasc() {
		return dt_Nasc;
	}
	public void setDt_Nasc(LocalDate dt_Nasc) {
		this.dt_Nasc = dt_Nasc;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dt_Nasc, genre, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dt_Nasc, other.dt_Nasc)
				&& Objects.equals(genre, other.genre) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	
	
}

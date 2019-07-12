package com.crud.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.crud.demo.util.LocalDateDeserializer;
import com.crud.demo.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue	
	private Long id;
	
	private String fullName;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateOfBith;
	
	private String cpf;
	
	private String rg;
	
	private String email;

	public User() {
	}

	public User(String fullName, LocalDate dateOfBith, String cpf, String rg, String email) {
		this.fullName = fullName;
		this.dateOfBith = dateOfBith;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
	}
	
	
	
	public User(Long id, String fullName, LocalDate dateOfBith, String cpf, String rg, String email) {
		this.id = id;
		this.fullName = fullName;
		this.dateOfBith = dateOfBith;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBith() {
		return dateOfBith;
	}

	public void setDateOfBith(LocalDate dateOfBith) {
		this.dateOfBith = dateOfBith;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dateOfBith == null) ? 0 : dateOfBith.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dateOfBith == null) {
			if (other.dateOfBith != null)
				return false;
		} else if (!dateOfBith.equals(other.dateOfBith))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", dateOfBith=" + dateOfBith + ", cpf=" + cpf + ", rg="
				+ rg + ", email=" + email + "]";
	}
	
	
	
}

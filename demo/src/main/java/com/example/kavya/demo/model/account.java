package com.example.kavya.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class account {
	@Id
	@GeneratedValue
	 int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
		public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCretaedDate() {
		return cretaedDate;
	}
	public void setCretaedDate(String cretaedDate) {
		this.cretaedDate = cretaedDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	String accountName;
	 String createdBy;
	 String cretaedDate; 
	 String lastModifiedBy;
	 String lastModifiedDate;
	 
	 public user getOwner() {
		return owner;
	}
	public void setOwner(user owner) {
		this.owner = owner;
	}
	@OneToOne(cascade = CascadeType.ALL)
	 user owner;

}

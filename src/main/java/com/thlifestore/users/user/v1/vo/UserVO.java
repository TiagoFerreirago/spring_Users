package com.thlifestore.users.user.v1.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class UserVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		private Long key;
		private String name;
		private String cpf;
		private LocalDate dt_Nasc;
		private String genre;
		
		public UserVO(Long key, String name, String cpf, LocalDate dt_Nasc, String genre) {
			
			this.key = key;
			this.name = name;
			this.cpf = cpf;
			this.dt_Nasc = dt_Nasc;
			this.genre = genre;
		}

		public Long getKey() {
			return key;
		}

		public void setKey(Long key) {
			this.key = key;
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
			return Objects.hash(cpf, dt_Nasc, genre, key, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserVO other = (UserVO) obj;
			return Objects.equals(cpf, other.cpf) && Objects.equals(dt_Nasc, other.dt_Nasc)
					&& Objects.equals(genre, other.genre) && Objects.equals(key, other.key)
					&& Objects.equals(name, other.name);
		}
		
		
		
		
}

package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class PersonTest {
				
		@Id
		@Column(length=30) @LabelFormat(LabelFormatType.SMALL)
		private String user;
		
		@LabelFormat(LabelFormatType.NO_LABEL)
		@Editor("ValidValuesVerticalRadioButtonWithOutLabel")
		private UserType userType;

		public enum UserType {
			STUDENT, TEACHER, PUBLICOFFICIAL
		};


		@Column(length=30) @Stereotype("PASSWORD")
		@LabelFormat(LabelFormatType.SMALL)
		private String password;
		

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getUser() {
			return user;
		}

		public UserType getUserType() {
			return userType;
		}

		public void setUserType(UserType userType) {
			this.userType = userType;
		}


}

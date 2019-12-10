package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StGenGstRate implements java.io.Serializable {
		private static final long serialVersionUID = 1L;
		private Integer id;
		
		private Float gstRate;
		private Timestamp gstApplyDate;

		private Timestamp creationTime;

		public StGenGstRate() {
		}
		public StGenGstRate(Integer id, Float gstRate, Timestamp gstApplyDate, Timestamp creationTime) {
			super();
			this.id = id;
			this.gstRate = gstRate;
			this.gstApplyDate = gstApplyDate;
			this.creationTime = creationTime;
		}
		public StGenGstRate( Float gstRate, Timestamp gstApplyDate, Timestamp creationTime) {
			super();
			
			this.gstRate = gstRate;
			this.gstApplyDate = gstApplyDate;
			this.creationTime = creationTime;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Float getGstRate() {
			return gstRate;
		}
		public void setGstRate(Float gstRate) {
			this.gstRate = gstRate;
		}
		public Timestamp getGstApplyDate() {
			return gstApplyDate;
		}
		public void setGstApplyDate(Timestamp gstApplyDate) {
			this.gstApplyDate = gstApplyDate;
		}
		public Timestamp getCreationTime() {
			return creationTime;
		}
		public void setCreationTime(Timestamp creationTime) {
			this.creationTime = creationTime;
		}

		
		
		

	}
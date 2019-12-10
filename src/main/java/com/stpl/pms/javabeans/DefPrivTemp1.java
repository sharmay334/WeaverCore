package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class DefPrivTemp1 implements Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		LinkedHashMap<String,DefPrivTemp2>  actionServiceM;
		
		public DefPrivTemp1() {
			
		}
		
		public LinkedHashMap<String, DefPrivTemp2> getActionServiceM() {
			return actionServiceM;
		}

		public void setActionServiceM(
				LinkedHashMap<String, DefPrivTemp2> actionServiceM) {
			this.actionServiceM = actionServiceM;
		}
		
		
	}



package com.stpl.pms.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.stpl.pms.javabeans.LoyaltyMasterBean;
import com.stpl.pms.javabeans.LoyaltyMasterHistoryBean;
import com.stpl.pms.javabeans.PlrTicketHistoryBean;

public class XMLSAXParser extends DefaultHandler{
	 public List<LoyaltyMasterBean> loyaltyList = new ArrayList<LoyaltyMasterBean>();
	 public List<LoyaltyMasterHistoryBean> loyaltyHistoryList  = new ArrayList<LoyaltyMasterHistoryBean>();
	 public List<PlrTicketHistoryBean> ticketHistoryList = new ArrayList<PlrTicketHistoryBean>();
	    private Stack<String> elementStack = new Stack<String>();
	    private Stack<Object> objectStack  = new Stack<Object>();
	    LoyaltyMasterBean loyaltyBean = new LoyaltyMasterBean();
	    LoyaltyMasterHistoryBean historyBean = null;
	    PlrTicketHistoryBean ticketHistoryBean = null;
	    String lastUpdateTime = null;
	    String setSuccess = null;
	    Integer balance=0;
		 public void startElement(String uri, String localName,
			        String qName, Attributes attributes) throws SAXException {

			        this.elementStack.push(qName);
			        String id=null;
			        
			        if("Result".equals(qName)){
			        	id = attributes.getValue("Name");
			        	String success = attributes.getValue("Success");
			        	if("GetUserLoyaltyPointsStatementLanguage".equals(id)){
			        		setSuccess = success;
			        	}else if("GetUserLoyaltyPointsBalanceDetails".equals(id)){
			        		loyaltyBean.setName(id);
			        		loyaltyBean.setSuccess(success);
			        	}else if("GetPlayerTicketHistory()".equals(id)){
			        		setSuccess = success;
			        	}
			        }else if("TierID".equals(qName)){
			        	id = attributes.getValue("value");
			        	loyaltyBean.setTierId(Integer.parseInt(id));
			        }else if ("TierName".equals(qName)) {
			        	id = attributes.getValue("value");
						loyaltyBean.setTierName(id);		
					}else if ("DateTierEntered".equals(qName)) {
						id = attributes.getValue("value");
						loyaltyBean.setDateTierEntered(id);
					}else if ("Balance".equals(qName)){
						id = attributes.getValue("value");
						if(id!=null)
							loyaltyBean.setBalance(Long.parseLong(id));
					}else if("PointsThisPeriod".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setPointsThisPeriod(Integer.parseInt(id));
					}else if("BasePointsThisPeriod".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setBasePointsThisPeriod(Integer.parseInt(id));
					}else if ("TierForLife".equals(qName)) {
						id = attributes.getValue("value");
						loyaltyBean.setTierForLife(Boolean.valueOf(id));
					}else if("IsEnabled".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setIsEnabled(Boolean.parseBoolean(id));
					}else if("GracePeriodDelta".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setGracePeriodDelta(Integer.parseInt(id));
					}else if("PeriodStartDate".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setPeriodStartDate(id);
					}else if("PeriodEndDate".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setPeriodEndDate(id);
					}else if("RakedAmountThisPeriod".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setRakedAmountThisPeriod(Integer.parseInt(id));
					}else if("RakedHandCountThisPeriod".equals(qName)){
						id = attributes.getValue("value");
						loyaltyBean.setRakedHandCountThisPeriod(Integer.parseInt(id));
					}
			        if("LoyaltyPointStatement".equals(qName)){
			        	historyBean = new LoyaltyMasterHistoryBean();
			        	historyBean.setTimeLastUpdate(lastUpdateTime);
			        	historyBean.setBalance(balance);
			        	historyBean.setSuccess(setSuccess);
			        	 this.objectStack.push(historyBean);
			        	 this.loyaltyHistoryList.add(historyBean);
			        }if("TimeLastUpdated".equals(qName)){
			        	lastUpdateTime = attributes.getValue("Value");
			        }if("Balance".equals(qName)){
			        	id = attributes.getValue("Value");
			        	if(id!=null)
			        		balance =Integer.parseInt(id);
			        }if("Date".equals(qName)){
			        	id = attributes.getValue("Value");
			        	historyBean.setHistoryDate(id);
			        }if("Amount".equals(qName)){
			        	id = attributes.getValue("Value");
			        	historyBean.setAmount(Integer.parseInt(id));
			        }if("EventID".equals(qName)){
			        	id = attributes.getValue("Value");
			        	historyBean.setEventId(Integer.parseInt(id));
			        }if("Description".equals(qName)){
			        	id = attributes.getValue("Value");
			        	historyBean.setDesc(id);
			        }if("TicketsHistory".equals(qName)){
			        	ticketHistoryBean = new PlrTicketHistoryBean();
			        	ticketHistoryBean.setSuccess(setSuccess);
			        	 this.objectStack.push(ticketHistoryBean);
			        	 this.ticketHistoryList.add(ticketHistoryBean);
			        }if("TicketID".equals(qName)){
			        	ticketHistoryBean.setTicketId(Integer.parseInt(attributes.getValue("Value")));
			        }if("TicketDescription".equals(qName)){
			        	id = attributes.getValue("Value");
			        	ticketHistoryBean.setTicketDesc(attributes.getValue("Value"));
			        }if("Currency".equals(qName)){
			        	ticketHistoryBean.setCurrency(attributes.getValue("Value"));
			        }if("BuyIn".equals(qName)){
			        	id = attributes.getValue("Value");
			        	ticketHistoryBean.setBuyIn(Integer.parseInt(id));
			        }if("Fee".equals(qName)){
			        	id = attributes.getValue("Value");
			        	ticketHistoryBean.setFee(Integer.parseInt(id));
			        }if("Expiry".equals(qName)){
			        	id = attributes.getValue("Value");
			        	ticketHistoryBean.setExpiry(id);
			        }if("TicketStatus".equals(qName)){
			        	id = attributes.getValue("Value");
			        	ticketHistoryBean.setTicketStatus(Integer.parseInt(id));
			        }
			       if(objectStack.size()==0){
			    	   this.objectStack.push(loyaltyBean);
			            this.loyaltyList.add(loyaltyBean);
			       }
			    }
}

package com.stpl.pms.controller.lm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.stpl.pms.hibernate.factory.HibernateSessionFactory;
import com.stpl.pms.hibernate.mapping.Itgs;

public class DiskSpaceController {

	public Double getDiskSpace() {
		// TODO Auto-generated method stub
		try{
			List<String> tableName = new ArrayList<>();
			List<String> cases = new ArrayList<>();
			cases.add("Generated");
			cases.add("Downloaded");
			Double totalSize = 0.0;
			Double totalMemory = 0.0;
			Map<String,Double> diskSpace = new HashedMap();
			Session session = HibernateSessionFactory.getSession();
			Criteria criteria = session.createCriteria(Itgs.class);
			criteria.add(Restrictions.in("status",cases));
			List<Itgs> result = criteria.list();
			if(result!=null){
				for(Itgs obj:result){
					tableName.add("ig_ticket_archive_"+obj.getGame_No()+"_batchNo_"+obj.getBatch_no());
				}
			}
			if(tableName!=null || !tableName.isEmpty()){
				String queryString = "SELECT table_name AS 'Table',ROUND(((data_length + index_length) / 1024 / 1024 / 1024), 2) AS 'Size (GB)' FROM information_schema.TABLES WHERE table_schema = 'itgs_new' ORDER BY (data_length + index_length) DESC";
				SQLQuery query2 = session.createSQLQuery(queryString);
				List<Object[]> dataSize = query2.list();
				
				if(dataSize!=null){
					for(Object[] obj:dataSize){
						diskSpace.put(obj[0].toString(),Double.valueOf(obj[1].toString()));	
					}
					
				}
				
				for(String s:tableName){
					totalSize = totalSize + diskSpace.get(s);
				}
				
				String queryString1 = "select * from itgs_disk_space";
				SQLQuery query3 = session.createSQLQuery(queryString1);
				List<Object[]> totmemory = query3.list();
				if(totmemory!=null){
					for(Object[] obj:totmemory){
						totalMemory = Double.valueOf(obj[1].toString());
					}
				}
				
			}
			Double percentage = (totalSize/totalMemory)*100;
			return percentage;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
		
	}

}

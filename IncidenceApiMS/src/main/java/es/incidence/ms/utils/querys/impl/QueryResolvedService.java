package es.incidence.ms.utils.querys.impl;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import es.incidence.ms.utils.querys.IQueryResolvedService;


@Service
public class QueryResolvedService implements IQueryResolvedService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("rawtypes")
	@Override
	public String getJpqlConsulterForLikeExpression(final String sqlQuery, final String sqlCcondition, final Object sqlParam, Map<String, Object> sqlParamsQuery, final Boolean sqlRequired) {
		// TODO Auto-generated method stub
		
		if( sqlParam == null 
				|| BooleanUtils.isNotTrue(sqlRequired)
				|| ( (sqlParam instanceof String) && ( StringUtils.isBlank( ((String) sqlParam) ) ) ) 
				|| ( (sqlParam instanceof Collection) && ((Collection) sqlParam).size() < 1 ) )
		
			return sqlQuery;
		
		String sqlQueryRemplace = sqlQuery;
		
		String sqlNameParamQuery = null;		
		Pattern pattern = Pattern.compile(":(\\w*)");
		Matcher m = pattern.matcher(sqlCcondition);
		
		if (m.find()) {
			sqlNameParamQuery = m.group(1);
		}
		
		
		if ( StringUtils.isNotBlank(sqlNameParamQuery) ) {
			
			sqlQueryRemplace = sqlQuery.concat(sqlCcondition+" ");
			
			sqlParamsQuery.put(sqlNameParamQuery, "%"+sqlParam+"%");
		}
		
		return sqlQueryRemplace;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getJpqlConsulterForNumberExpression(final String sqlQuery, final String sqlCcondition, final Object sqlParam, Map<String, Object> sqlParamsQuery, final Boolean sqlRequired) {
		// TODO Auto-generated method stub

		if( sqlParam == null 
				|| BooleanUtils.isNotTrue(sqlRequired)
				|| ( (sqlParam instanceof String) && ( StringUtils.isBlank( ((String) sqlParam) ) ) ) 
				|| ( (sqlParam instanceof Collection) && ((Collection) sqlParam).size() < 1 ) )
		
			return sqlQuery;
		
		String sqlQueryRemplace = sqlQuery;
		
		String sqlNameParamQuery = null;
		Pattern pattern = Pattern.compile(":(\\w*)");
		Matcher m = pattern.matcher(sqlCcondition);
		
		if (m.find()) {
			
			sqlNameParamQuery = m.group(1);
		}
		
		if ( StringUtils.isNotBlank(sqlNameParamQuery) ) {
			
			sqlQueryRemplace = sqlQuery.concat(sqlCcondition+" ");
			
			sqlParamsQuery.put(sqlNameParamQuery, sqlParam);
		}
		
		return sqlQueryRemplace;
	}

	@Override
	public Long countJpqlConsulterWithConditionExpression(Query queryCount, Map<String, Object> sqlParamsQuery) {
		// TODO Auto-generated method stub
		
		if (sqlParamsQuery!=null && !sqlParamsQuery.isEmpty() ) {
			this.getMergerSqlParamsQueryForJpqlConsulter(queryCount,sqlParamsQuery);
		}
		
		Long countRegisters = 0L;
		
		try {
			
			countRegisters = (Long) queryCount.getSingleResult();
			
		}
		catch(NoResultException nre) {
			
			logger.error("if there is no result");
			
		}
		catch(NonUniqueResultException nure) {
			
			logger.error("if more than one result");
			
		}
		catch(IllegalStateException ise) {
			
			logger.error("if called for a JavaPersistence query language UPDATE or DELETE statement");
			
		}
		catch(QueryTimeoutException qte) {
			
			logger.error("if the query execution exceedsthe query timeout value set and only the statement isrolled back");
			
		}
		catch(TransactionRequiredException tre) {
			
			logger.error("if a lock mode other than NONE has been set and there is no transactionor the persistence context has not been joined to the transaction");
			
		}
		catch(PessimisticLockException ple) {
			
			logger.error("if pessimistic lockingfails and the transaction is rolled back");
			
		}
		catch(LockTimeoutException lte) {
			
			logger.error("if pessimistic lockingfails and only the statement is rolled back");
			
		}
		catch(PersistenceException pe) {
			
			logger.error(" if the query execution exceedsthe query timeout value set and the transactionis rolled back ");
			
		}finally {
 
			if( countRegisters == null ) 
				countRegisters = 0L;
        }
		
		return countRegisters;
	}

	@Override
	public void getMergerSqlParamsQueryForJpqlConsulter(Query queryCount, Map<String, Object> sqlParamsQuery) {
		// TODO Auto-generated method stub
		
	}

}

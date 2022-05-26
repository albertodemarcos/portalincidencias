package es.incidence.ms.utils.querys;

import java.util.Map;

import javax.persistence.Query;

public interface IQueryResolvedService {
	
	String getJpqlConsulterForLikeExpression(final String sqlQuery, final String sqlCcondition, final Object sqlParam, Map<String, Object> sqlParamsQuery, final Boolean sqlRequired);
	
	String getJpqlConsulterForNumberExpression(final String sqlQuery, final String sqlCcondition, final Object sqlParam, Map<String, Object> sqlParamsQuery, final Boolean sqlRequired);
	
	Long countJpqlConsulterWithConditionExpression(Query queryCount, Map<String, Object> sqlParamsQuery);
	
	void getMergerSqlParamsQueryForJpqlConsulter(Query queryCount, Map<String, Object> sqlParamsQuery);
	
}

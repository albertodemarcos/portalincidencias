package es.emailsnotification.ms.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "1ms")
public class ScheduledTaskConfiguration {

	@Bean
    public LockProvider lockProvider(DataSource dataSource) {
		/*JdbcTemplate  jdbcTemplate = new JdbcTemplate(dataSource);
		Configuration _configuration = JdbcTemplateLockProvider.Configuration.builder().withJdbcTemplate(jdbcTemplate).usingDbTime().build();
		LockProvider _provider = new JdbcTemplateLockProvider(_configuration);
		return _provider;*/
		return new JdbcTemplateLockProvider(dataSource);
    }
}

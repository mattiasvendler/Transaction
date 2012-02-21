package se.vendler.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 2/21/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private DataSource mysqlXADataSource;

    public JdbcTemplate mysqlXAJdbcTemplate() {
        return new JdbcTemplate(mysqlXADataSource);
    }

    public void scen1() {
       InsertXATableProc insertXATableProc = new InsertXATableProc();
        insertXATableProc.update(1,"bajs");
    }

    private class InsertXATableProc extends StoredProcedure {
        private InsertXATableProc() {
            super(mysqlXADataSource, "labs.xatable_ins");
            setFunction(true);
            declareParameter(new SqlParameter("p_id", Types.NUMERIC));
            declareParameter(new SqlParameter("p_message", Types.VARCHAR));
            compile();
        }
        public void update(int id,String text) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("p_id",id);
            map.put("p_message",text);
            execute(map);
        }
    }
}

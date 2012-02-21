package se.vendler.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 2/21/12
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionService {
    @Transactional
    public void scen1();
}

package com.stpl.pms.utility;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.impl.DefaultConnectionTester;

/**
 *
 * @author pratyush
 */
public class ReplicationConnectionTester extends DefaultConnectionTester {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* CAUTION: this will only work for ONE SLAVE ENVIRONMENT, since
     * this does not make sure all slaves are checked. */
    @Override
    public int activeCheckConnection(Connection connection, String arg1, Throwable[] arg2) {

        // Initially set to ok
        int status = CONNECTION_IS_OKAY;

        try {

            // remember state and
            boolean autoCommit = connection.getAutoCommit();
            boolean readOnly = connection.isReadOnly();

            // switch to slave and check slave
            connection.setReadOnly(true);
            connection.setAutoCommit(false);
            status = super.activeCheckConnection(connection, arg1, arg2);

            // if slave is fine, lets check the master
            if ( status == CONNECTION_IS_OKAY ){
                connection.setReadOnly(false);
                connection.setAutoCommit(autoCommit);
                status = super.activeCheckConnection(connection, arg1, arg2);
            }

            connection.setAutoCommit(autoCommit);
            connection.setReadOnly(readOnly);

        } catch (SQLException e) {
            status = CONNECTION_IS_INVALID;
        }

        // return final state
        return status;
    }
}

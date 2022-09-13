package com.solvd.pools;

import com.solvd.pools.connectionpools.connections.ConnectionPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

class DBCPTest {
    @InjectMocks
    private ConnectionPool dbcpConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private Statement mockStatement;

    @BeforeAll
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestMockDBCPConnection() throws Exception {
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
    }
}
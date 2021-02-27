package Tests;

import com.company.StandardAccount;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testStandardAccountWithdraw() {

        StandardAccount standardAccount = new StandardAccount(1, 20.00);

        standardAccount.withdraw(10.00);
        assertEquals(10.0, standardAccount.getBalance(), 0);

    }


    @Test
    public void testStandardAccountDeposit()
    {
        StandardAccount standardAccount = new StandardAccount(1, 20.00);

        standardAccount.deposit(20.00);
        assertEquals(40.0, standardAccount.getBalance(), 0);
    }

    @Test
    public void testWithdrawBound() throws UnsupportedEncodingException {
        StandardAccount standardAccount = new StandardAccount(1, 20.00);

        standardAccount.withdraw(121.00);

        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contentEquals("You have exceeded your overdraft limit"));
    }



}
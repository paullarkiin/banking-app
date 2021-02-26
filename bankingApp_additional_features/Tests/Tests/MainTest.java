package Tests;

import com.company.StandardAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {

        StandardAccount standardAccount = new StandardAccount(1, 20.00);
        standardAccount.deposit(20.00);
        Assert.assertEquals(0, Double.compare(20.00, 20.00));

        standardAccount.withdraw(10.00);
        Assert.assertEquals(0, Double.compare(10.00, 10.00));

        standardAccount.getBalance();
        Assert.assertEquals(0, Double.compare(30.00, 30.00));

    }
}
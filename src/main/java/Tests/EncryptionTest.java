package Tests;

import Webservices.Authentication.Encryption;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {

    @Test
    void encrypt() {
        Assert.notNull(Encryption.encrypt("UnitTest"));
    }
}
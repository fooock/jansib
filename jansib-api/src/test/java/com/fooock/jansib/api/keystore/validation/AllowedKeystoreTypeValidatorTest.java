package com.fooock.jansib.api.keystore.validation;

import com.fooock.jansib.api.inventory.validation.AllowedInventoryTypeValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllowedKeystoreTypeValidatorTest {
    private final AllowedKeystoreTypeValidator validator = new AllowedKeystoreTypeValidator();

    @Test
    void testAllowedKeystoreType() {
        assertTrue(validator.isValid("ssh", null));
        assertTrue(validator.isValid("SSH", null));
    }

    @Test
    void testNotAllowedKeystoreType() {
        assertFalse(validator.isValid("hello", null));
        assertFalse(validator.isValid("static", null));
    }
}
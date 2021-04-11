package com.fooock.jansib.api.inventory.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllowedInventoryTypeValidatorTest {
    private final AllowedInventoryTypeValidator validator = new AllowedInventoryTypeValidator();

    @Test
    void testAllowedFileType() {
        assertTrue(validator.isValid("file", null));
        assertTrue(validator.isValid("FILE", null));
    }

    @Test
    void testNotAllowedFileType() {
        assertFalse(validator.isValid("hello", null));
        assertFalse(validator.isValid("static", null));
    }
}
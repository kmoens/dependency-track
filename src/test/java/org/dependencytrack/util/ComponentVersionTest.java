package org.dependencytrack.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComponentVersionTest {
    @Test
    public void testParseSimpleOpenSslVersion() {
        ComponentVersion version = new ComponentVersion("1.1.1j");

        List<String> parts = version.getVersionParts();
        Assert.assertEquals(3, parts.size());
        Assert.assertEquals("1", parts.get(0));
        Assert.assertEquals("1", parts.get(1));
        Assert.assertEquals("1j", parts.get(2));
    }

    @Test
    public void testParseUbuntuOpenSslVersion() {
        ComponentVersion version = new ComponentVersion("1.1.1j-1ubuntu2.10");

        List<String> parts = version.getVersionParts();
        Assert.assertEquals(6, parts.size());
        Assert.assertEquals("1", parts.get(0));
        Assert.assertEquals("1", parts.get(1));
        Assert.assertEquals("1", parts.get(2));
        Assert.assertEquals("1", parts.get(3));
        Assert.assertEquals("ubuntu2", parts.get(4));
        Assert.assertEquals("10", parts.get(5));
    }

    @Test
    public void testCompareSimpleOpenSslVersion() {
        ComponentVersion version = new ComponentVersion("1.1.1j");

        // equality
        Assert.assertEquals(0, version.compareTo(new ComponentVersion("1.1.1j")));
        Assert.assertNotEquals(0, version.compareTo(new ComponentVersion("1.1.1b")));
        Assert.assertNotEquals(0, version.compareTo(new ComponentVersion("1.1.1")));

        // less then
        Assert.assertEquals(-1, version.compareTo(new ComponentVersion("1.1.2")));
        Assert.assertEquals(-1, version.compareTo(new ComponentVersion("1.1.1k")));

        // greater then
        Assert.assertEquals(1, version.compareTo(new ComponentVersion("1.1.0")));
        Assert.assertEquals(1, version.compareTo(new ComponentVersion("1.1.1i")));
    }

    @Test
    public void testCompareUbuntuOpenSslVersion() {
        ComponentVersion version = new ComponentVersion("1.1.1j-1ubuntu2.10");

        // equality
        Assert.assertEquals(0, version.compareTo(new ComponentVersion("1.1.1j")));
        Assert.assertNotEquals(0, version.compareTo(new ComponentVersion("1.1.1b")));
        Assert.assertNotEquals(0, version.compareTo(new ComponentVersion("1.1.1")));

        // less then
        Assert.assertEquals(-1, version.compareTo(new ComponentVersion("1.1.2")));
        Assert.assertEquals(-1, version.compareTo(new ComponentVersion("1.1.1k")));

        // greater then
        Assert.assertEquals(1, version.compareTo(new ComponentVersion("1.1.0")));
        Assert.assertEquals(1, version.compareTo(new ComponentVersion("1.1.1i")));
    }
}

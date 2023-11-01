package com.custodio.study.revolut.urlshortner;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;
import org.junit.Test;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class URLShortenerTest
{
    @Test
    public void given_ValidURL_When_ShorteningIt_Then_ReturnAlias() throws MalformedURLException
    {
        //given
        final URL url = new URL("https://www.google.com");
        final int length = 6;
        //when
        final String encoded = new SimpleURLShortener().encode(url, length);
        //then
        assertFalse("The alias must not be empty.", encoded.isEmpty());
        assertTrue("The alias maximum length is 6.", encoded.length() <= length);
    }

    @Test
    public void given_EmptyURL_When_ShorteningIt_Then_ThrowsIllegalArgumentException()
    {
        //given
        final URL url = null;
        final int length = 6;
        //then
        assertThrows("The url is mandatory.", IllegalArgumentException.class, () -> {
            //when
            new SimpleURLShortener().encode(url, length);
        });
    }

    @Test
    public void given_ExistingAlias_When_DecodingIt_Then_ReturnFullURL() throws MalformedURLException
    {
        //given
        final String alias = "ac6bb6";
        final Map<String, URL> aliases = Map.of(alias, new URL("https://www.google.com"));
        //when
        final Optional<URL> actual = new SimpleURLShortener(aliases).decode(alias);
        //then
        assertTrue(actual.isPresent());
        final URL expected = new URL("https://www.google.com");
        assertEquals(expected, actual.get());
    }

    @Test
    public void given_EmptyAlias_When_DecodingIt_Then_ThrowsIllegalArgumentException()
    {
        //given
        final String alias = null;
        //then
        assertThrows("The alias is mandatory.", IllegalArgumentException.class, () -> {
            //when
            new SimpleURLShortener().decode(alias);
        });

    }

    private static class SimpleURLShortener implements URLShortener
    {
        private final Map<String, URL> aliases;
        private final MessageDigest message;

        private SimpleURLShortener()
        {
            this(new HashMap<>());
        }

        @VisibleForTesting
        private SimpleURLShortener(@NotNull final Map<String, URL> aliases)
        {
            try
            {
                this.aliases = requireNonNull(aliases, "The map of aliases is mandatory.");
                this.message = MessageDigest.getInstance("SHA-256");
            }
            catch (final NoSuchAlgorithmException exception)
            {
                throw new IllegalStateException(exception);
            }
        }

        @Override
        public String encode(final URL url, final int length)
        {
            if (url == null)
            {
                throw new IllegalArgumentException("The url is mandatory.");
            }
            final byte[] urlBytes = url.toString().getBytes(UTF_8);
            //Calculates message digest.
            final byte[] alias = message.digest(urlBytes);
            //Converts into signum representation.
            final BigInteger signum = new BigInteger(1, alias);
            //Converts to hexadecimal.
            final String hash = signum.toString(16);
            //Reduces to the maximum allowed length.
            return hash.substring(0, length);
        }

        @Override
        public Optional<URL> decode(final String alias)
        {
            if (alias == null)
            {
                throw new IllegalArgumentException("The alias is mandatory.");
            }
            return Optional.ofNullable(aliases.get(alias));
        }
    }

    private interface URLShortener
    {

        /**
         * Given a certain url generates a hash version of it.
         *
         * @param url    The full url to be hashed.
         * @param length The maximum length the alias must have.
         * @return The hashed version of the url.
         * @throws IllegalArgumentException If the url is not defined.
         */
        String encode(URL url, int length);

        /**
         * Given a certain alias retrieve the full url representation.
         *
         * @param alias The alias to be used as based for the search.
         * @return The url if found any.
         * @throws IllegalArgumentException If the alias is not defined or is empty.
         */
        Optional<URL> decode(String alias);
    }
}

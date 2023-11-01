package com.custodio.study.revolut.loadbalancer;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Server
{
    private final String host;
    private final int port;

    private Server(@NotNull final String host, final int port)
    {
        this.port = port;
        this.host = requireNonNull(host, "The host is mandatory.").trim();
        if (this.host.isEmpty())
        {
            throw new IllegalArgumentException("The host is mandatory.");
        }
    }

    @NotNull
    public static Builder builder()
    {
        return new Builder();
    }

    @NotNull
    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    @Override
    public boolean equals(final Object other)
    {
        if(other instanceof Server) {
            final Server otherServer = (Server) other;
            return port == otherServer.port && Objects.equals(host, otherServer.host);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(host, port);
    }

    public static class Builder
    {
        private String host;
        private int port;

        private Builder()
        {
        }

        @NotNull
        public Builder host(@NotNull final String host)
        {
            this.host = Objects.requireNonNull(host, "The host is mandatory.").trim();
            if (this.host.isEmpty())
            {
                throw new IllegalArgumentException("The host is mandatory.");
            }
            return this;
        }

        @NotNull
        public Builder port(final int port)
        {
            this.port = port;
            return this;
        }

        @NotNull
        public Server build()
        {
            return new Server(host, port);
        }
    }
}

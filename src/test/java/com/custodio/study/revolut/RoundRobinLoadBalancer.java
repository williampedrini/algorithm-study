package com.custodio.study.revolut;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer implements LoadBalancer
{
    private final AtomicInteger counter;

    private final List<Server> servers;

    @VisibleForTesting
    RoundRobinLoadBalancer(@NotNull final List<Server> servers)
    {
        this.counter = new AtomicInteger(0);
        this.servers = Objects.requireNonNull(servers, "The servers are mandatory.");
    }

    public RoundRobinLoadBalancer()
    {
        this.counter = new AtomicInteger(0);
        this.servers = new ArrayList<>();
    }

    @Override
    public void add(@NotNull final Server server)
    {
        Objects.requireNonNull(server, "The server is mandatory");
        servers.add(server);
    }

    @NotNull
    @Override
    public Optional<Server> get()
    {
        if (servers.isEmpty())
        {
            return Optional.empty();
        }
        final int index = counter.getAndIncrement() % servers.size();
        return Optional.of(servers.get(index));
    }
}

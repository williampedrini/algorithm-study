package com.custodio.study.revolut.loadbalancer;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface LoadBalancer
{

    /**
     * Adds a certain server as part of the pool of server for the load to be balanced to.
     *
     * @param server The server to be added.
     */
    void add(@NotNull Server server);

    /**
     * Get a server from a pool of servers.
     *
     * @return The server if the list is not empty.
     */
    @NotNull
    Optional<Server> get();
}

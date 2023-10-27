package com.custodio.study.revolut;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//As a developer I want to be able to:
//Add a server to a list of server.
//Be able to retrieve a server using round-robin algorithm.
//Be able to remove a server from a list of servers.
public class LoadBalancerTest
{
    @Test
    public void when_CreatingServerWithoutHostName_Then_ShouldThrowException()
    {
        //given
        final String hostname = null;
        final int port = 8080;
        //then
        Assert.assertThrows("The host is mandatory.", IllegalArgumentException.class, () -> {
            //when
            Server.builder()
                  .host(hostname)
                  .port(port)
                  .build();
        });
    }

    @Test
    public void when_CreatingServerWithEmptyHostName_Then_ShouldThrowException()
    {
        //given
        final String hostname = "";
        final int port = 8080;
        //then
        Assert.assertThrows("The host is mandatory.", IllegalArgumentException.class, () -> {
            //when
            Server.builder()
                  .host(hostname)
                  .port(port)
                  .build();
        });
    }

    @Test
    public void given_NullServer_When_AddingToLoadBalancer_Then_ShouldThrowException()
    {
        //given
        final Server server = null;
        //then
        Assert.assertThrows("The server is mandatory.", IllegalArgumentException.class, () -> {
            //when
            new RoundRobinLoadBalancer().add(server);
        });
    }

    @Test
    public void given_ValidServer_When_AddingToLoadBalancerPool_Then_ShouldNotThrowAnyException()
    {
        //given
        final Server server = Server.builder()
                                    .host("localhost")
                                    .port(8080)
                                    .build();
        final List<Server> servers = new ArrayList<>();
        //when
        new RoundRobinLoadBalancer(servers).add(server);
        //then
        Assert.assertFalse(servers.isEmpty());
        Assert.assertEquals(server, servers.stream().findFirst().get());
    }

    @Test
    public void given_LoadBalancerPoolWithMoreThanOneServer_When_GettingServerFromPool_Then_ShouldReturnServerInRoundRobinManner()
    {
        //given
        final Server server1 = Server.builder()
                                     .host("localhost")
                                     .port(8080)
                                     .build();
        final Server server2 = Server.builder()
                                     .host("localhost")
                                     .port(8081)
                                     .build();
        final List<Server> servers = List.of(server1, server2);
        //when
        final LoadBalancer loadBalancer = new RoundRobinLoadBalancer(servers);
        final Optional<Server> actualServer1 = loadBalancer.get();
        final Optional<Server> actualServer2 = loadBalancer.get();
        //then
        Assert.assertTrue(actualServer1.isPresent());
        Assert.assertEquals(server1, actualServer1.get());
        Assert.assertTrue(actualServer2.isPresent());
        Assert.assertEquals(server2, actualServer2.get());
    }
}
package org.lantern;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;

/**
 * Interface for all classes that keep track of proxies.
 */
public interface ProxyTracker {

    void clear();

    void clearPeerProxySet();

    void addProxy(URI jid, String hostPort);

    void addProxy(URI jid, InetSocketAddress iae);

    void addJidProxy(URI jid);

    void removePeer(URI uri);

    boolean hasJidProxy(URI uri);

    ProxyHolder getProxy();

    ProxyHolder getJidProxy();

    boolean hasProxy();

    /**
     * Return a collection of all proxies in order of preference for using them.
     * 
     * @return
     */
    Collection<ProxyHolder> getAllProxiesInOrderOfFallbackPreference();
    
    /**
     * Called when a connection to a proxy fails.
     * 
     * @param proxyAddress The address of the proxy.
     */
    void onCouldNotConnect(ProxyHolder proxyAddress);

    void onError(URI peerUri);

}

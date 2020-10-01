package ru.job4j.gc.cache;

/**
 * Interface Cache.
 *
 * @param <V> the type parameter
 * @param <K> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.10.2020
 */
public interface Cache<V, K> {
    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    V get(K key);
}

package demo.pxportfolio.realestateagency.config.cache;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final CacheManager cacheManager;

    public void evictCache(String cacheName) {
        if (cacheManager.getCache(cacheName) != null) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
    }

    public void clearCache() {
        cacheManager.getCacheNames().forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }
}

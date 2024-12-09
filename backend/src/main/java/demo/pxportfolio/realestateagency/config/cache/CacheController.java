package demo.pxportfolio.realestateagency.config.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cache")
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @DeleteMapping("/{cacheName}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void evictCache(@PathVariable String cacheName) {
        cacheService.evictCache(cacheName);
    }

    @DeleteMapping("/clear")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void clearCache() {
        cacheService.clearCache();
    }
}
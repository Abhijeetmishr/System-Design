package internal

import (
	factory "cache/factory"
)

type CacheService interface {
	Set(key string, value string) error
	Get(key string) (string, error)
	Delete(key string) error
}

type cacheService struct {
	repo    CacheRepository
	factory factory.CacheEvictionFactory // Updated to use the new package
}

func NewCacheService(repo CacheRepository, factory factory.CacheEvictionFactory) CacheService {
	return &cacheService{repo: repo, factory: factory}
}

// Delete implements CacheService.
func (c *cacheService) Delete(key string) error {
	return c.repo.Delete(key)
}

// Get implements CacheService.
func (c *cacheService) Get(key string) (string, error) {
	return c.repo.Get(key)
}

// Set implements CacheService.
func (c *cacheService) Set(key string, value string) error {
	err := c.repo.Set(key, value)
	it := c.repo.(*cacheRepository).mem
	if err == nil && len(it) >= 2 {
		cacheEvictionStrategy := c.factory.GetEvictionStrategy("LRU")
		cacheEvictionStrategy.Evict(it)
	}
	return err
}

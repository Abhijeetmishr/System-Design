package internal

import (
	"cache/strategy"
	"errors"
	"time"
)

type CacheRepository interface {
	Set(key string, value string) error
	Get(key string) (string, error)
	Delete(key string) error
}

type cacheRepository struct {
	mem map[string]strategy.CacheItem
}

func NewCacheRepository(mem map[string]strategy.CacheItem) CacheRepository {
	return &cacheRepository{mem: mem}
}

// Delete implements CacheRepository.
func (c *cacheRepository) Delete(key string) error {
	for k := range c.mem {
		if k == key {
			delete(c.mem, k)
			return nil
		}
	}
	return errors.New("key not found")
}

// Get implements CacheRepository.
func (c *cacheRepository) Get(key string) (string, error) {
	if item, exists := c.mem[key]; exists {
		item.LastUsedTime = time.Now()
		item.AccessCount++
		c.mem[key] = item // Update the map with the modified item
		return item.Value, nil
	}
	return "", errors.New("key not found")
}

// Set implements CacheRepository.
func (c *cacheRepository) Set(key string, value string) error {
	item := &strategy.CacheItem{
		Value:        value,
		CreatedTime:  time.Now(),
		LastUsedTime: time.Now(),
		AccessCount:  1,
	}
	c.mem[key] = *item
	return nil
}

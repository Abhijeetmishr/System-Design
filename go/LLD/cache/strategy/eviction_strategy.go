package strategy

import (
	"time"
)

type CacheItem struct {
	Value        string
	LastUsedTime time.Time
	AccessCount  int
	CreatedTime  time.Time
}

type EvictionStrategy interface {
	Evict(mem map[string]CacheItem) error
}

type LRUStrategy struct{}

func NewLRUStrategy() EvictionStrategy {
	return &LRUStrategy{}
}

func (l *LRUStrategy) Evict(mem map[string]CacheItem) error {
	if len(mem) == 0 {
		return nil
	}

	for k, v := range mem {
		if v.LastUsedTime.Before(time.Now()) {
			delete(mem, k)
			break
		}
	}

	return nil
}

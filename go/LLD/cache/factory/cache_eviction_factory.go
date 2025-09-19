package factory

import "cache/strategy"

type CacheEvictionFactory interface {
	GetEvictionStrategy(strategyType string) strategy.EvictionStrategy
}

type cacheEvictionFactory struct{}

func NewCacheEvictionFactory() CacheEvictionFactory {
	return &cacheEvictionFactory{}
}

func (c *cacheEvictionFactory) GetEvictionStrategy(strategyType string) strategy.EvictionStrategy {
	switch strategyType {
	case "LRU":
		return strategy.NewLRUStrategy()
	// case "LFU":
	// 	return strategy.NewLFUStrategy()
	// case "FIFO":
	// 	return strategy.NewFIFOStrategy()
	default:
		return nil
	}
}

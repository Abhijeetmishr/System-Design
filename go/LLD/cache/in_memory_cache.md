## Design In memory cache system
### Requirements
- user should be able to set cache as key, value pair with optional TTL

- user should be able to get val using key

- user can delete cache based on key

- cache can automatically evict based on policy implemented(LFU, LRU etc)

- By default, tasks should expire after TTL, if TTL was provided.

### Non-Functional

- Must handle concurrent access (multiple goroutines).

- Must follow SOLID principles.

- Must use Strategy pattern for eviction policies.

- Must use Dependency Injection so policies can be plugged in without modifying cache logic.

- All data should be stored in-memory (no DB, no external libraries like Redis).


### API 
- SET(string key, map[string]interface{} val, ttl optional)

- GET(string key) map[string]interface{}

- DELETE(string key)

- STATS()


### CLASSES

### Prezentiranje proekt:

---

### Settings:
___
Configuration for localhost machine and docker-compose with Dockerfiles:
### `  "baseURL: 'http://localhost:8081',`

___

Configuration for k8s docker images:
### `  "baseURL: '/api',` (axios.js)
### `  "proxy: 'http://localhost:8081',` (package.json)
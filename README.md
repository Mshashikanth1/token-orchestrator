# token-orchestrator



# api collection


```

{
	"info": {
		"_postman_id": "7a80a4fc-8e00-47f2-895b-c8243ddb6bd0",
		"name": "Token Orches EDRA LABS MachineCodingRound",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "22867529"
	},
	"item": [
		{
			"name": "http://localhost:8080/token-orchestrator/create-key",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/create-key",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"create-key"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/available-key",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/available-key",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"available-key"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/info-key/",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/info-key/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"info-key",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/unblock-key/1",
			"request": {
				"method": "PUT",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/unblock-key/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"unblock-key",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/remove-key/1",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/remove-key/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"remove-key",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/remove-expired-keys",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/remove-expired-keys",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"remove-expired-keys"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/token-orchestrator/auto-unblock-keys",
			"request": {
				"method": "PUT",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/token-orchestrator/auto-unblock-keys",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"token-orchestrator",
						"auto-unblock-keys"
					]
				}
			},
			"response": []
		}
	]
}

```
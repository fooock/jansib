start-db:
	docker run -d \
	--rm=true \
	--name jansib_pg_test \
	-e POSTGRES_USER=test \
	-e POSTGRES_PASSWORD=test \
	-e POSTGRES_DB=jansib_db \
	-p 5432:5432 \
	postgres:12

stop-db:
	docker kill jansib_pg_test
	docker rm jansib_pg_test

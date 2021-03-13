# Overview
Running postgres as a docker container

# Pre-req
Docker is installed and running
```
docker version
```

# Startup
```
# Run container
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -v postgres_data:/var/lib/postgresql/data -p5432:5432 -d postgres
```

# Login to psql cli
```
docker exec -it some-postgres psql -U postgres
```
